package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetEnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import com.clearfashion.sdk.widgets.utility.getResources

@Composable
fun AgecWidgetImpact() {
    val resources = getResources()

    WidgetSection(title = resources.getString(R.string.general_section_title_environment_impact)) {
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.RawMaterial,
            title = resources.getString(R.string.agec_section_title_raw_material, "95%"),
            description = resources.getString(R.string.agec_section_description_raw_material_recycled)
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.Recyclability,
            title = resources.getString(R.string.agec_section_title_recyclability_entirely),
            description = resources.getString(R.string.agec_section_description_recyclability_entirely)
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.Uses,
            title = resources.getString(R.string.agec_section_title_uses),
            description = resources.getString(R.string.agec_section_description_uses, "100%")
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.HighRiskSubstances,
            title = resources.getQuantityString(R.plurals.agec_section_title_high_risk_substances, 1, "Poils d’ours"),
            description = resources.getString(R.string.agec_section_description_high_risk_substances)
        )
    }
}