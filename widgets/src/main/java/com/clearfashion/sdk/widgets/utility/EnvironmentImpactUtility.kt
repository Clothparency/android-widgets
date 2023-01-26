package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.model.ProductionStep

private val impactToLogo = mapOf<EnvironmentImpact, Int>(
    EnvironmentImpact.HighRiskSubstances to R.drawable.risks,
    EnvironmentImpact.RawMaterial to R.drawable.raw_material,
    EnvironmentImpact.Recyclability to R.drawable.recyclability,
    EnvironmentImpact.Uses to R.drawable.uses
)

internal fun getEnvironmentImpactLogoResourceID(impact: EnvironmentImpact): Int {
    return impactToLogo[impact]!!
}

private val impactToText = mapOf<EnvironmentImpact, Int>(
    EnvironmentImpact.HighRiskSubstances to R.string.general_section_environment_impact_high_risk_substances,
    EnvironmentImpact.RawMaterial to R.string.general_section_environment_impact_raw_material,
    EnvironmentImpact.Recyclability to R.string.general_section_environment_impact_recyclability,
    EnvironmentImpact.Uses to R.string.general_section_environment_impact_uses
)

internal fun getEnvironmentImpactTextResourceID(impact: EnvironmentImpact): Int {
    return impactToText[impact]!!
}