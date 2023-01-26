package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.ProductionStep
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetProductionCountry
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import com.clearfashion.sdk.widgets.utility.getResources


@Composable
internal fun AgecWidgetProductionContries() {
    val resources = getResources()

    WidgetSection(title = resources.getString(R.string.general_section_title_production_countries)) {
        WidgetProductionCountry(ProductionStep.Weaving, "Espagne")
        WidgetProductionCountry(ProductionStep.DyeingAndPrinting, "Portugal")
        WidgetProductionCountry(ProductionStep.Manufacturing, "France")
    }
}