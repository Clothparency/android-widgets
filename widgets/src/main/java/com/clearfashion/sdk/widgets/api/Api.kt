package com.clearfashion.sdk.widgets.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.clearfashion.sdk.widgets.model.Product
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import okhttp3.*
import okio.IOException

// FIXME: use generics
internal class EntityData(var id: String, var type: String, var attributes: Product)

internal class Entity(var data: EntityData)

@Composable
internal fun fetchAndExecute(
    url: String,
    onSuccess: (product: Product) -> Unit,
    onFailure: (error: java.lang.Exception) -> Unit = {}
) {
    // FIXME: Configure a logger
    println("Attempting to fetch JSON")

    val request = Request.Builder().url(url).build()

    val client = OkHttpClient()
    val coroutineScope = rememberCoroutineScope()

    client.newCall(request).enqueue(object: Callback {
        override fun onResponse(call: Call, response: Response) {
            val body = response.body?.string()
            try {
                val gson = GsonBuilder().create()
                val entity = gson.fromJson<Entity>(body, Entity::class.java)

                coroutineScope.launch {
                    // FIXME: remove me when second API call will be avoided
                    println("onSuccess")
                    onSuccess(entity.data.attributes)
                }
            } catch (e: java.lang.Exception) {
                // FIXME: Configure a logger
                println("Failed to parse response")
                e.printStackTrace()
            }

        }

        override fun onFailure(call: Call, e: IOException) {
            // FIXME: Configure a logger
            println("Failed to execute request")
            e.printStackTrace()
            coroutineScope.launch {
                onFailure(e)
            }
        }
    })
}