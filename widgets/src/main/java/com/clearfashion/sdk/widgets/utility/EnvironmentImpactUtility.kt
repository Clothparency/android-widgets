package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.model.ProductionStep

val impactToLogo = mapOf<EnvironmentImpact, Int>(
    EnvironmentImpact.HighRiskSubstances to R.drawable.risks,
    EnvironmentImpact.RawMaterial to R.drawable.raw_material,
    EnvironmentImpact.Recyclability to R.drawable.recyclability,
    EnvironmentImpact.Uses to R.drawable.uses
)

fun getEnvironmentImpactResourceID(impact: EnvironmentImpact): Int {
    return impactToLogo[impact]!!
}