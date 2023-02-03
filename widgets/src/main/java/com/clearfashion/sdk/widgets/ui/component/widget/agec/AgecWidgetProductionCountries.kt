package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.model.ProductionStep
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetProductionCountry
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import com.clearfashion.sdk.widgets.utility.Strings
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.utility.hasImpact


@Composable
internal fun AgecWidgetProductionCountries(product: Product) {
    val resources = getResources()

    val title =
        if (hasImpact(product))
            resources.getString(R.string.general_section_title_production_countries)
        else Strings.Empty

    WidgetSection(title) {
        product.productionStepOrigins.forEach { productionStepOrigin ->
            val step = ProductionStep.fromName(productionStepOrigin.step)

            if (step != ProductionStep.Unknown) {
                WidgetProductionCountry(
                    step = ProductionStep.fromName(productionStepOrigin.step),
                    country = productionStepOrigin.countryName
                )
            }
        }
    }
}