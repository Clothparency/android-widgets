package com.clearfashion.sdk.widgets

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.model.getWidget
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.utility.setLocale
import java.util.*

/**
 * The languages supported by the widget
 */
enum class ClearFashionWidgetLanguage(val locale: Locale) {
    /**
     * Set the widget language to english
     */
    ENGLISH(Locale("en")),

    /**
     * Set the widget language to french
     */
    FRENCH(Locale("fr"))
}

/**
 * The widget types currently supported.
 */
enum class ClearFashionWidgetType {
    /**
     * Get the AGEC widget
     */
    AGEC
}

/**
 * Displays the Clear Fashion's AGEC widget.
 *
 * @param lang The language of the widget. This parameter defaults to french.
 * @param type The type of the widget. This parameter defaults to AGEC which currently the only
 * type supported.
 */
@Composable
fun ClearFashionWidget(
    lang: ClearFashionWidgetLanguage = ClearFashionWidgetLanguage.FRENCH,
    type: ClearFashionWidgetType = ClearFashionWidgetType.AGEC
) {
    setLocale(lang)

    val resources = getResources()
    val widget = getWidget(type)

    WidgetButton(
        title = resources.getString(widget.titleResourceID),
        closedContent = widget.closedContent
    ) {
        widget.content()
    }
}
