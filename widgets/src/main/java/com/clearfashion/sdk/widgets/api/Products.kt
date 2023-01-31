package com.clearfashion.sdk.widgets.api

import android.content.Context
import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.model.Product
import kotlinx.coroutines.CoroutineScope

internal fun fetchProductFromAPI(
    brandCode: String,
    productID: String,
    coroutineScope: CoroutineScope,
    context: Context,
    onFailure: (error: APIError) -> Unit = {},
    onSuccess: (product: Product) -> Unit
) {
    fetchAndExecute(
        relativeUrl = "brands/${brandCode}/agec/products/${productID}",
        entityClass = Product::class.java,
        coroutineScope = coroutineScope,
        context = context,
        onSuccess = onSuccess,
        onFailure = onFailure
    )
}