package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.model.AgecWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.model.Widget

private val typeToWidget = mapOf<ClearFashionWidgetType, Widget>(
    ClearFashionWidgetType.AGEC to AgecWidget(),
)

internal fun getWidget(type: ClearFashionWidgetType): Widget {
    return typeToWidget[type]!!
}