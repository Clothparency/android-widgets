package com.clearfashion.sdk.widgets.type

import java.util.*

/**
 * The languages supported by the widget
 */
enum class ClearFashionWidgetLanguage(val locale: Locale) {
    /**
     * Set the widget language to english
     */
    EN(Locale("en")),

    /**
     * Set the widget language to french
     */
    FR(Locale("fr"))
}