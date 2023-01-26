package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.model.ProductionStep
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetProductionCountry
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection

@Composable
fun AgecWidgetProductionContries() {
    WidgetSection(title = "Principaux pays de production") {
        WidgetProductionCountry(ProductionStep.Weaving, "Espagne")
        WidgetProductionCountry(ProductionStep.DyeingAndPrinting, "Portugal")
        WidgetProductionCountry(ProductionStep.Manufacturing, "France")
    }
}