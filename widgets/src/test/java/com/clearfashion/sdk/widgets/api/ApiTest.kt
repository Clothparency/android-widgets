package com.clearfashion.sdk.widgets.api

import android.content.Context
import com.clearfashion.sdk.widgets.model.EMPTY_PRODUCT
import com.clearfashion.sdk.widgets.model.Product
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import java.io.IOException


class ApiTest {
    private var server: MockWebServer? = null

    @Before
    @Throws(IOException::class)
    fun setup() {
        this.server = MockWebServer()
        this.server!!.start()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        this.server!!.shutdown()
    }

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

    @Test
    fun testFetchAndExecute_successful() {
        val relativeUrl = "brands/code/products/key"
        val entityClass = Product::class.java
        val coroutineScope = mock<CoroutineScope>()
        val context = mock<Context>()
        val onSuccess = mock<(_: Product) -> Unit>()
        val onFailure = mock<(_: APIError) -> Unit>()
        val client = mock<OkHttpClient>()
        val baseApiUrl = server!!.url("/").toUrl()
        val requestBuilder = mock<Request.Builder>()
        val api = Api(context, client, baseApiUrl, requestBuilder)

        // TODO
    }
}