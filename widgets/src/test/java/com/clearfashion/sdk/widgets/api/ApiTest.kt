package com.clearfashion.sdk.widgets.api

import android.content.Context
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.model.Product.Companion.EMPTY_PRODUCT
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.test.TestScope
import okhttp3.*
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

import org.mockito.kotlin.*



class ApiTest {
    private val apiEntityResponse = Api.APIEntity(Api.EntityData(EMPTY_PRODUCT))
    private val responseBodyAsString: String = Gson().toJson(apiEntityResponse)

    @Test
    fun testEntityData_attributes() {
        val product = EMPTY_PRODUCT
        val entityData = Api.EntityData(product)
        assertEquals(product, entityData.attributes)
    }

    @Test
    fun testAPIEntity_data() {
        val product = EMPTY_PRODUCT
        val entityData = Api.EntityData(product)
        val apiEntity = Api.APIEntity(entityData)
        assertEquals(entityData, apiEntity.data)
    }

    private fun createApiWithClient(
        server: MockWebServer,
        client: OkHttpClient,
        coroutineScope: CoroutineScope = mock(),
        withoutCoroutineScore: Boolean = false
    ): Api {
        val context = mock<Context>()

        val baseApiUrl = server.url("").toUrl()
        val path = Api.PathBuilder().brand("code").agecProduct("key").build()
        val coroutineScope = if (withoutCoroutineScore) null else coroutineScope
        return spy(
            Api(context, client, baseApiUrl)
                .withPath(path)
                .withCoroutineScope(coroutineScope)
        )
    }

    private fun runWithServer(runnable: (server: MockWebServer) -> Unit) {
        val server = MockWebServer()
        server.start()

        runnable(server)

        server.shutdown()
    }

    @Test
    fun testFetchAndExecute_enqueueRequest() {
        runWithServer { server ->
            run {
                val call = mock<Call>()
                val client = mock<OkHttpClient>() {
                    on { newCall(any()) } doReturn call
                }
                val api = createApiWithClient(server, client)

                val onSuccess = mock<(_: Product) -> Unit>()
                val onFailure = mock<(_: APIError) -> Unit>()

                api.fetchAndExecute(Product::class.java, onFailure, onSuccess)

                verify(client).newCall(any())
                verify(call).enqueue(any())
            }
        }
    }


    private fun testOnResponse_error(responseCode: Int) {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val api = createApiWithClient(server, client)

                val response = mock<Response>() {
                    on { isSuccessful } doReturn false
                    on { code } doReturn responseCode
                }
                val onSuccess = mock<(_: Product) -> Unit>()
                val onFailure = mock<(_: APIError) -> Unit>()

                doNothing().whenever(api).onRequestFailure(any(), any(), any())

                api.onResponse(response, Product::class.java, onFailure, onSuccess)

                val expectedError = APIError(responseCode)

                verify(response).isSuccessful
                verify(response).close()
                verify(api).onRequestFailure(eq(expectedError), any(), eq(onFailure))
                verify(api, never()).onRequestSuccessful<Product>(any(), any(), any())
            }
        }
    }

    @Test
    fun testOnResponse_error500() {
        testOnResponse_error(500)
    }

    @Test
    fun testOnResponse_error404() {
        testOnResponse_error(404)
    }

    @Test
    fun testOnResponse_error401() {
        testOnResponse_error(401)
    }

    @Test
    fun testOnResponse_errorGeneral() {
        testOnResponse_error(-1)
    }

    @Test
    fun testOnResponse_success() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val api = createApiWithClient(server, client)

                val response = mock<Response>() {
                    on { isSuccessful } doReturn true
                }
                val onSuccess = mock<(_: Product) -> Unit>()
                val onFailure = mock<(_: APIError) -> Unit>()

                doNothing().whenever(api).onRequestSuccessful<Product>(any(), any(), any())

                api.onResponse(response, Product::class.java, onFailure, onSuccess)

                verify(response).isSuccessful
                verify(response).close()
                verify(api)
                    .onRequestSuccessful(eq(response), eq(Product::class.java), eq(onSuccess))
                verify(api, never()).onRequestFailure(any(), any(), any())
            }
        }
    }

    @Test
    fun testOnRequestSuccessful_withoutCoroutineScope() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val api = createApiWithClient(server, client, withoutCoroutineScore = true)

                val responseBody = mock<ResponseBody>() {
                    on { string() } doReturn responseBodyAsString
                }
                val response = mock<Response>() {
                    on { body } doReturn responseBody
                }
                val onSuccess = mock<(_: Product) -> Unit>()

                api.onRequestSuccessful(response, Product::class.java, onSuccess)

                verify(onSuccess).invoke(EMPTY_PRODUCT)
            }
        }
    }

    @Test
    fun testOnRequestSuccessful_withoutCoroutineScope_parsingError() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val api = createApiWithClient(server, client, withoutCoroutineScore = true)

                val responseBody = mock<ResponseBody>() {
                    on { string() } doReturn responseBodyAsString.substring(2)
                }
                val response = mock<Response>() {
                    on { body } doReturn responseBody
                }
                val onSuccess = mock<(_: Product) -> Unit>()

                assertThrows(APIError::class.java) {
                    api.onRequestSuccessful(response, Product::class.java, onSuccess)
                }
            }
        }
    }

    @Test
    fun testOnRequestSuccessful_withCoroutineScope() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val coroutineScope = TestScope()
                val api = createApiWithClient(server, client, coroutineScope)

                val responseBody = mock<ResponseBody>() {
                    on { string() } doReturn responseBodyAsString
                }
                val response = mock<Response>() {
                    on { body } doReturn responseBody
                }
                val onSuccess = mock<(_: Product) -> Unit>()

                api.onRequestSuccessful(response, Product::class.java, onSuccess)

                verify(api).launchWithCoroutineScope(eq(EMPTY_PRODUCT), eq(onSuccess))
            }
        }
    }

    @Test
    fun testOnRequestFailure_withoutCoroutineScope() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val api = createApiWithClient(server, client, withoutCoroutineScore = true)

                val onFailure = mock<(_: APIError) -> Unit>()
                val apiError = APIError(500)

                api.onRequestFailure(apiError, "message", onFailure)

                verify(onFailure).invoke(apiError)
            }
        }
    }

    @Test
    fun testOnRequestFailure_withCoroutineScope() {
        runWithServer { server ->
            run {
                val client = OkHttpClient()
                val coroutineScope = TestScope()
                val api = createApiWithClient(server, client, coroutineScope)

                val onFailure = mock<(_: APIError) -> Unit>()
                val apiError = APIError(500)

                api.onRequestFailure(apiError, "message", onFailure)

                verify(api).launchWithCoroutineScope(eq(apiError), eq(onFailure))
            }
        }
    }
}
