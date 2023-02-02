package com.clearfashion.sdk.widgets.api

import android.content.Context
import com.clearfashion.sdk.widgets.utility.Strings
import com.clearfashion.sdk.widgets.utility.getConfigurationProperty
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import mu.KotlinLogging
import okhttp3.*
import okio.IOException
import java.lang.reflect.Type
import java.net.URL

private val LOGGER = KotlinLogging.logger {}

internal class Api {

    companion object {
        private const val BASE_API_CONFIG_KEY = "BASE_API_URL"
    }

    internal data class EntityData<T>(var attributes: T)
    internal data class APIEntity<T>(var data: EntityData<T>)

    private val context: Context
    private val client: OkHttpClient
    private val baseAPIUrl: URL
    private val requestBuilder: Request.Builder
    private var path: String = Strings.Empty
    private var coroutineScope: CoroutineScope? = null

    constructor(context: Context) {
        this.context = context
        this.client = OkHttpClient()
        this.baseAPIUrl = URL(getConfigurationProperty(context, BASE_API_CONFIG_KEY))
        this.requestBuilder = Request.Builder()
    }

    constructor(
        context: Context,
        client: OkHttpClient,
        baseAPIUrl: URL,
        requestBuilder: Request.Builder
    ) {
        this.context = context
        this.client = client
        this.baseAPIUrl = baseAPIUrl
        this.requestBuilder = requestBuilder
    }

    internal fun withPath(path: String): Api {
        this.path = path
        return this
    }

    internal fun withCoroutineScope(coroutineScope: CoroutineScope): Api {
        this.coroutineScope = coroutineScope
        return this
    }

    private fun <T> onRequestSuccessful(
        response: Response,
        entityClass: Class<T>,
        onSuccess: (entity: T) -> Unit
    ) {
        try {
            val body = response.body?.string()
            val gson = GsonBuilder().create()
            val apiEntityType: Type = TypeToken.getParameterized(
                APIEntity::class.java,
                entityClass
            ).type
            val entity: APIEntity<T> = gson.fromJson(body, apiEntityType)

            LOGGER.info("Data fetched successfully")

            coroutineScope?.launch {
                onSuccess(entity.data.attributes)
            } ?: onSuccess(entity.data.attributes)
        } catch (e: java.lang.Exception) {
            throw APIError(-1, e)
        }
    }

    private fun onRequestFailure(
        error: APIError,
        message: String,
        onFailure: (e: APIError) -> Unit,
    ) {
        LOGGER.error(error) { message }
        coroutineScope?.launch {
            onFailure(error)
        } ?: onFailure(error)
    }

    internal fun <T> fetchAndExecute(
        entityClass: Class<T>,
        onFailure: (error: APIError) -> Unit = {},
        onSuccess: (entity: T) -> Unit
    ) {
        LOGGER.info("Attempting to fetch data via API")
        val request = requestBuilder.url("${baseAPIUrl}${path}").build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                try {
                    if (!response.isSuccessful) throw APIError(response.code)

                    onRequestSuccessful(response, entityClass, onSuccess)
                } catch (e: APIError) {
                    onRequestFailure(e, "Failed to parse response", onFailure)
                } finally {
                    response.close()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(
                    APIError(-1, e),
                    "Failed to execute request",
                    onFailure
                )
            }
        })

    }
    internal fun <T> buildCallable(
        entityClass: Class<T>,
        onFailure: (error: APIError) -> Unit = {},
        onSuccess: (entity: T) -> Unit
    ): () -> Unit {
        return { run { fetchAndExecute(entityClass, onFailure, onSuccess) } }
    }


    internal class PathBuilder {
        private var brandID: String? = null
        private var agecProductID: String? = null

        fun brand(id: String): PathBuilder {
            brandID = id
            return this
        }

        fun agecProduct(id: String): PathBuilder {
            agecProductID = id
            return this
        }

        private fun createBrandPath(): String {
            return "${Strings.ForwardSlash}brands${Strings.ForwardSlash}$brandID"
        }

        private fun createAgecPath(): String {
            return "${Strings.ForwardSlash}agec"
        }

        private fun createAgecProductPath(): String {
            return "${createAgecPath()}${Strings.ForwardSlash}" +
                    "products${Strings.ForwardSlash}$agecProductID"
        }

        fun build(): String {
            if (brandID == null) throw Exception("Please set a brand id")
            if (agecProductID == null) return createBrandPath()

            return "${createBrandPath()}${createAgecProductPath()}"
        }
    }
}