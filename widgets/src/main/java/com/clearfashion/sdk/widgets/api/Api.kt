package com.clearfashion.sdk.widgets.api

import android.content.Context
import androidx.compose.ui.text.intl.Locale
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
    private val requestBuilder: Request.Builder = Request.Builder()
    private var path: String = Strings.Empty
    private var coroutineScope: CoroutineScope? = null
    private var locale : String? = null

    internal constructor(context: Context) {
        this.context = context
        this.client = OkHttpClient()
        this.baseAPIUrl = URL(getConfigurationProperty(context, BASE_API_CONFIG_KEY))
    }

    internal constructor(
        context: Context,
        client: OkHttpClient,
        baseAPIUrl: URL
    ) {
        this.context = context
        this.client = client
        this.baseAPIUrl = baseAPIUrl
    }

    internal fun withPath(path: String): Api {
        this.path = path
        return this
    }

    internal fun withCoroutineScope(coroutineScope: CoroutineScope?): Api {
        this.coroutineScope = coroutineScope
        return this
    }

    internal fun withLocale(locale: String): Api {
        this.locale = locale
        return this
    }

    internal fun <T> onResponse(
        response: Response,
        entityClass: Class<T>,
        onFailure: (e: APIError) -> Unit,
        onSuccess: (entity: T) -> Unit
    ) {
        try {
            if (!response.isSuccessful) throw APIError(response.code)

            onRequestSuccessful(response, entityClass, onSuccess)
        } catch (e: APIError) {
            onRequestFailure(e, "Failed to parse response", onFailure)
        } finally {
            response.close()
        }
    }

    internal fun <T> launchWithCoroutineScope(entity: T, onSuccess: (entity: T) -> Unit) {
        if (coroutineScope == null) return

        onSuccess(entity)
    }

    internal fun launchWithCoroutineScope(error: APIError, onFailure: (e: APIError) -> Unit) {
        if (coroutineScope == null) return

        onFailure(error)
    }

    internal fun <T> onRequestSuccessful(
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

            if (coroutineScope == null) onSuccess(entity.data.attributes)
            else launchWithCoroutineScope(entity.data.attributes, onSuccess)
        } catch (e: java.lang.Exception) {
            throw APIError(-1, e)
        }
    }

    internal fun onRequestFailure(
        error: APIError,
        message: String,
        onFailure: (e: APIError) -> Unit
    ) {
        LOGGER.error(error) { message }
        if (coroutineScope == null) onFailure(error)
        else launchWithCoroutineScope(error, onFailure)
    }

    internal fun <T> fetchAndExecute(
        entityClass: Class<T>,
        onFailure: (error: APIError) -> Unit = {},
        onSuccess: (entity: T) -> Unit
    ) {
        LOGGER.info("Attempting to fetch data via API")
        val urlBuilder = java.lang.StringBuilder("${baseAPIUrl}${path}")
        if (locale != null) urlBuilder.append("?locale=$locale")
        val request = requestBuilder.url(urlBuilder.toString()).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                onResponse(response, entityClass, onFailure, onSuccess)
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
            if (brandID == null) return Strings.Empty
            if (agecProductID == null) return createBrandPath()

            return "${createBrandPath()}${createAgecProductPath()}"
        }
    }
}