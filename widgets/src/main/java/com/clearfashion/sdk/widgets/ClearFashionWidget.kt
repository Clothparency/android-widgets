package com.clearfashion.sdk.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.clearfashion.sdk.widgets.api.fetchProductFromAPI
import com.clearfashion.sdk.widgets.model.EMPTY_PRODUCT
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import com.clearfashion.sdk.widgets.utility.getWidget
import com.clearfashion.sdk.widgets.utility.setLocale

/**
 * Displays the Clear Fashion's AGEC widget.
 *
 * @param brandCode The code of your brand
 * @param productIdentifier The identifier of the product.
 *  This can be either the product reference or its key.
 * @param lang The language of the widget. This parameter defaults to french.
 * @param type The type of the widget. This parameter defaults to AGEC which currently the only
 * type supported.
 */
@Composable
fun ClearFashionWidget(
    brandCode: String,
    productIdentifier: String,
    lang: ClearFashionWidgetLanguage = ClearFashionWidgetLanguage.FRENCH,
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC
) {
    setLocale(lang)

    var (error, setError) = remember { mutableStateOf(false) }
    var (loading, setLoading) = remember { mutableStateOf(true) }
    var (product, setProduct) = remember { mutableStateOf<Product>(EMPTY_PRODUCT) }

    // FIXME: Avoid second call
    fetchProductFromAPI(
        brandCode,
        productIdentifier,
        onFailure = { setError(true)}
    ) { product: Product ->
        run {
            setProduct(product)
            setLoading(false)
        }
    }
    val widget = getWidget(type, product)

    // TODO: Handle errors properly
    if (loading) {
        Text("Loading...")
    } else if (error) {
        Text(text = "Error")
    } else {
        WidgetButton(
            product = product,
            title = widget.title,
            closedContent = widget.closedContent
        ) {
            widget.content()
        }
    }
}
