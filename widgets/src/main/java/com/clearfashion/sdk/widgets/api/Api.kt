package com.clearfashion.sdk.widgets.api

import android.content.Context
import com.clearfashion.sdk.widgets.utility.getConfigurationProperty
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.*
import okio.IOException
import java.lang.reflect.Type
import mu.KotlinLogging

private val LOGGER = KotlinLogging.logger {}

internal data class EntityData<T>(var attributes: T)

internal data class APIEntity<T>(var data: EntityData<T>)

internal fun <T>fetchAndExecute(
    relativeUrl: String,
    entityClass: Class<T>,
    coroutineScope: CoroutineScope,
    context: Context,
    onSuccess: (entity: T) -> Unit,
    onFailure: (error: APIError) -> Unit = {}
) {
    LOGGER.info("Attempting to fetch JSON")

    val baseAPIUrl = getConfigurationProperty(context, "BASE_API_URL")
    val request = Request.Builder().url("${baseAPIUrl}${relativeUrl}").build()
    val client = OkHttpClient()

    client.newCall(request).enqueue(object: Callback {
        override fun onResponse(call: Call, response: Response) {
            try {
                if (!response.isSuccessful) throw APIError(response.code)

                try {
                    val body = response.body?.string()
                    val gson = GsonBuilder().create()
                    val apiEntityType: Type = TypeToken.getParameterized(
                        APIEntity::class.java,
                        entityClass
                    ).type
                    val entity: APIEntity<T> = gson.fromJson(body, apiEntityType)
                    coroutineScope.launch {
                        onSuccess(entity.data.attributes)
                    }
                } catch (e: java.lang.Exception) {
                    throw APIError(-1, e)
                }

            } catch (e: APIError) {
                LOGGER.error("Failed to parse response")
                e.printStackTrace()
                coroutineScope.launch {
                    onFailure(e)
                }
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            LOGGER.error("Failed to execute request")
            e.printStackTrace()
            coroutineScope.launch {
                onFailure(APIError(-1, e))
            }
        }
    })
}