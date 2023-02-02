package com.clearfashion.sdk.widgets.utility

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.model.Product

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

internal fun hasDangerousSubstances(product: Product): Boolean {
    return product.dangerousSubstances.isNotEmpty()
}

internal fun hasConcerningSubstances(product: Product): Boolean {
    return product.concerningSubstances.isNotEmpty()
}

internal fun hasRiskSubstances(product: Product): Boolean {
    return hasDangerousSubstances(product) || hasConcerningSubstances(product)
}

@Composable
internal fun getHighRiskSubstanceSectionTitle(product: Product): String {
    if (!hasRiskSubstances(product)) return Strings.Empty

    val resources = getResources()
    val titleList = arrayListOf<String>()
    if (product.dangerousSubstances.isNotEmpty()) {
        titleList.add(
            resources.getQuantityString(
                R.plurals.agec_section_title_high_risk_substances,
                product.dangerousSubstances.size,
                joinWithComa(product.dangerousSubstances)
            )
        )
    }
    if (product.concerningSubstances.isNotEmpty()) {
        titleList.add(
            resources.getQuantityString(
                R.plurals.agec_section_title_concerning_substances,
                product.concerningSubstances.size,
                joinWithComa(product.concerningSubstances)
            )
        )
    }
    return titleList.joinToString(Strings.NewLine)
}

internal fun hasImpact(product: Product): Boolean {
    return product.hasMaterialImpacts
            || product.shouldDisplayRecyclability
            || product.emittingMicroFiber
            || hasRiskSubstances(product)
}