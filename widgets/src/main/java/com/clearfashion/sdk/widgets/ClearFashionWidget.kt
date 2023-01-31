package com.clearfashion.sdk.widgets

import androidx.compose.runtime.*
import com.clearfashion.sdk.widgets.api.APIError
import com.clearfashion.sdk.widgets.api.fetchProductFromAPI
import com.clearfashion.sdk.widgets.model.EMPTY_PRODUCT
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.ui.component.Loadable
import com.clearfashion.sdk.widgets.ui.component.LoadableState
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import com.clearfashion.sdk.widgets.utility.Strings
import com.clearfashion.sdk.widgets.utility.getContext
import com.clearfashion.sdk.widgets.utility.getWidget
import com.clearfashion.sdk.widgets.utility.setLocale

/**
 * Displays the Clear Fashion's AGEC widget.
 *
 * @param brandId The code of your brand
 * @param productIdentifier The identifier of the product.
 *  This can be either the product reference or its key.
 * @param lang The language of the widget. This parameter defaults to french.
 * @param type The type of the widget. This parameter defaults to AGEC which currently the only
 * type supported.
 */
@Composable
fun ClearFashionWidget(
    brandId: String,
    productIdentifier: String,
    lang: ClearFashionWidgetLanguage = ClearFashionWidgetLanguage.FR,
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC
) {
        setLocale(lang)

        val coroutineScope = rememberCoroutineScope()
        val context = getContext()

        var (errorMessage, setErrorMessage) = remember { mutableStateOf(Strings.Empty) }
        var (state, setState) = remember { mutableStateOf(LoadableState.Loading) }
        var (product, setProduct) = remember { mutableStateOf(EMPTY_PRODUCT) }

        val apiCall = {
            run {
                fetchProductFromAPI(
                    brandId,
                    productIdentifier,
                    coroutineScope,
                    context,
                    onFailure = { e: APIError ->
                        run {
                            setState(LoadableState.Error)
                            setErrorMessage(context.resources.getString(e.errorMessageResourceID))
                        }
                    }
                ) { product: Product ->
                    run {
                        setProduct(product)
                        setState(LoadableState.Loaded)
                    }
                }
            }
        }

        val widget = getWidget(type, product)

        Loadable(state, errorMessage, apiCall) {
            WidgetButton(
                product = product,
                title = widget.title,
                closedContent = widget.closedContent
            ) {
                widget.content()
            }
        }

}
