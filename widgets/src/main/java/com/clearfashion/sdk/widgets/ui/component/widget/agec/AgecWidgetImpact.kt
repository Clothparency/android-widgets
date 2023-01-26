package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetEnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import com.clearfashion.sdk.widgets.utility.getString

@Composable
fun AgecWidgetImpact() {
    WidgetSection(title = getString(R.string.general_section_title_environment_impact)) {
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.RawMaterial,
            title = getString(R.string.agec_section_title_raw_material, "95%"),
            description = getString(R.string.agec_section_description_raw_material, "95%")
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.Recyclability,
            title = getString(R.string.agec_section_title_recyclability_entirely),
            description = getString(R.string.agec_section_description_recyclability_entirely)
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.Uses,
            title = getString(R.string.agec_section_title_uses),
            description = getString(R.string.agec_section_description_uses)
        )
        WidgetEnvironmentImpact(
            impact = EnvironmentImpact.HighRiskSubstances,
            title = getString(R.string.agec_section_title_high_risk_substances, "Poils d’ours"),
            description = getString(R.string.agec_section_description_high_risk_substances)
        )
    }
}