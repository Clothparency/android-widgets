package com.clearfashion.sdk.widgets

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
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
 * If your application uses Jetpack Compose you can simply add this method inside any composable
 * scopes as so:
 *
 * `
 * ```kotlin
 * // ...
 *
 * import com.clearfashion.sdk.widgets.ClearFashionWidget
 * import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
 *
 * // ...
 *
 * ClearFashionWidget(
 *     brandId = "The id of your brand as given by Clear Fashion",
 *     productIdentifier = "The identifier of your product as given by Clear Fashion",
 *     lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
 * )
 * ```
 *
 * For more informations on how to integrate a composable function in your code, please read:
 * [https://developer.android.com/jetpack/compose/interop/interop-apis](https://developer.android.com/jetpack/compose/interop/interop-apis)
 *
 *
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
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC,
    modifier: Modifier = Modifier
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

        Loadable(state, errorMessage, apiCall, modifier) {
            WidgetButton(
                product = product,
                title = widget.title,
                closedContent = widget.closedContent
            ) {
                widget.content()
            }
        }

}

/**
 * Displays the Clear Fashion's AGEC widget.
 *
 * If your application is fragments based, in the fragment XML file where you want to put the widget, add a compose view for the widget to live in:
 *
 *
 * ```xml
 * <androidx.compose.ui.platform.ComposeView
 *     android:id="@+id/cf_widget_compose_view"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"/>
 * ```
 *
 * And then in the onCreateView method, add the following:
 *
 *
 * ```kotlin
 * // ...
 *
 * import com.clearfashion.sdk.widgets.ClearFashionWidget
 * import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
 *
 * // ...
 *
 * override fun onCreate(savedInstanceState: Bundle?) {
 *
 * // ...
 *
 *     ClearFashionWidget(
 *         composeView = binding.cfWidgetComposeView,
 *         brandId = "The id of your brand as given by Clear Fashion",
 *         productIdentifier = "The identifier of your product as given by Clear Fashion",
 *         lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
 *     )
 *
 * // ...
 *
 * }
 * ```
 *
 * For more informations on how to integrate a composable function in your code, please read:
 * [https://developer.android.com/jetpack/compose/interop/interop-apis](https://developer.android.com/jetpack/compose/interop/interop-apis)
 *
 *
 *
 * @param composeView The compose view in which the widget will be displayed.
 * @param brandId The code of your brand.
 * @param productIdentifier The identifier of the product.
 *  This can be either the product reference or its key.
 * @param lang The language of the widget. This parameter defaults to french.
 * @param type The type of the widget. This parameter defaults to AGEC which currently the only
 * type supported.
 */
fun ClearFashionWidget(
    composeView: ComposeView,
    brandId: String,
    productIdentifier: String,
    lang: ClearFashionWidgetLanguage = ClearFashionWidgetLanguage.FR,
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC,
) {
    composeView.apply {
        // Dispose of the Composition when the view's LifecycleOwner is destroyed
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

        setContent() {
            ClearFashionWidget(brandId, productIdentifier, lang, type)
        }
    }
}

/**
 * Displays the Clear Fashion's AGEC widget
 *
 * If your application is view based , you can add the widget in the activity where you want it to be displayed:
 *
 *
 * ```kotlin
 * // ...
 *
 * import com.clearfashion.sdk.widgets.ClearFashionWidget
 * import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
 *
 * // ...
 *
 * ClearFashionWidget(
 *     activity = this,
 *     brandId = "The id of your brand as given by Clear Fashion",
 *     productIdentifier = "The identifier of your product as given by Clear Fashion",
 *     lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
 * )
 * ```
 *
 * For more informations on how to integrate a composable function in your code, please read:
 * [https://developer.android.com/jetpack/compose/interop/interop-apis](https://developer.android.com/jetpack/compose/interop/interop-apis)
 *
 *
 *
 * @param activity The activity in which you want to display the widget.
 * @param brandId The code of your brand.
 * @param productIdentifier The identifier of the product.
 *  This can be either the product reference or its key.
 * @param lang The language of the widget. This parameter defaults to french.
 * @param type The type of the widget. This parameter defaults to AGEC which currently the only
 * type supported.
 */
fun ClearFashionWidget(
    activity: ComponentActivity,
    brandId: String,
    productIdentifier: String,
    lang: ClearFashionWidgetLanguage = ClearFashionWidgetLanguage.FR,
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC
) {
    activity.setContent {
        ClearFashionWidget(brandId, productIdentifier, lang, type)
    }
}
