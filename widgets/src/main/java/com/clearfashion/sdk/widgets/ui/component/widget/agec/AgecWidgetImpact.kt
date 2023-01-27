package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetEnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import com.clearfashion.sdk.widgets.utility.*
import com.clearfashion.sdk.widgets.utility.getHighRiskSubstanceSectionTitle
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.utility.hasRiskSubstances

@Composable
internal fun AgecWidgetImpact(product: Product) {
    val resources = getResources()

    WidgetSection(title = resources.getString(R.string.general_section_title_environment_impact)) {
        if (product.hasMaterialImpacts) {
            WidgetEnvironmentImpact(
                impact = EnvironmentImpact.RawMaterial,
                title = resources.getString(R.string.agec_section_title_raw_material, "${product.recycledPercentage}%"),
                description = resources.getString(R.string.agec_section_description_raw_material_recycled)
            )
        }
        if (product.shouldDisplayRecyclability) {
            WidgetEnvironmentImpact(
                impact = EnvironmentImpact.Recyclability,
                title = product.readableRecyclability,
                description = resources.getString(R.string.agec_section_description_recyclability_entirely)
            )
        }
        if (product.emittingMicroFiber) {
            WidgetEnvironmentImpact(
                impact = EnvironmentImpact.Uses,
                title = resources.getString(R.string.agec_section_title_uses),
                description = resources.getString(
                    R.string.agec_section_description_uses,
                    "${product.syntheticPercentage}%"
                )
            )
        }
        if (hasRiskSubstances(product)) {
            WidgetEnvironmentImpact(
                impact = EnvironmentImpact.HighRiskSubstances,
                title = getHighRiskSubstanceSectionTitle(product),
                description = resources.getString(R.string.agec_section_description_high_risk_substances)
            )
        }
    }
}