package com.clearfashion.sdk.widgets.model

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetButtonContent
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetContent
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetTitle
import com.clearfashion.sdk.widgets.utility.hasImpact

internal class AgecWidget: Widget {
    val _product: Product;

    constructor(product: Product) {
        _product = product
    }

    override val title: @Composable () -> Unit
        get() = { AgecWidgetTitle(_product) }
    override val closedContent: @Composable () -> Unit
        get() = { AgecWidgetButtonContent(_product) }
    override val content: @Composable () -> Unit
        get() = { AgecWidgetContent(_product) }
}