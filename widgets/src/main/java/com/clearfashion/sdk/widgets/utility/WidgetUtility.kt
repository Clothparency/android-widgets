package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.model.AgecWidget
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.model.Widget

internal fun getWidget(type: ClearFashionWidgetType, product: Product): Widget {
    return when (type) {
        ClearFashionWidgetType.AGEC -> AgecWidget(product)
    }
}