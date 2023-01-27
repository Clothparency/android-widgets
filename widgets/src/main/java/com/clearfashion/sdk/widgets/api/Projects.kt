package com.clearfashion.sdk.widgets.api

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.model.Product

@Composable
internal fun fetchProductFromAPI(
    brandCode: String,
    productID: String,
    onFailure: (error: java.lang.Exception) -> Unit = {},
    onSuccess: (product: Product) -> Unit
) {
    // FIXME: Set base API URL in configuration file
    fetchAndExecute(
        url = "http://localhost:3000/api/partners/v1/brands/${brandCode}/products/${productID}",
        onSuccess = onSuccess,
        onFailure = onFailure
    )
}