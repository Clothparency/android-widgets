package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.utility.hasImpact

@Composable
internal fun AgecWidgetContent(product: Product) {
    AgecWidgetBanner(product)
    AgecWidgetProductionContries(product)
    if (hasImpact(product)) AgecWidgetImpact(product)
}