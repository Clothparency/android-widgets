package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.ProductionStep

private val stepToLogo = mapOf<ProductionStep, Int>(
    ProductionStep.Assembly to R.drawable.assembly,
    ProductionStep.DyeingAndPrinting to R.drawable.dyeing_and_printing,
    ProductionStep.Finishing to R.drawable.finishing,
    ProductionStep.Manufacturing to R.drawable.manufacturing,
    ProductionStep.Stitching to R.drawable.stitching,
    ProductionStep.Weaving to R.drawable.weaving
)

fun getProductionStepLogoResourceID(step: ProductionStep): Int {
    return stepToLogo[step]!!
}

private val stepToText = mapOf<ProductionStep, Int>(
    ProductionStep.Assembly to R.string.general_section_production_step_assembly,
    ProductionStep.DyeingAndPrinting to R.string.general_section_production_step_dyeing_and_printing,
    ProductionStep.Finishing to R.string.general_section_production_step_finishing,
    ProductionStep.Manufacturing to R.string.general_section_production_step_manufacturing,
    ProductionStep.Stitching to R.string.general_section_production_step_stitching,
    ProductionStep.Weaving to R.string.general_section_production_step_weaving
)

fun getProductionStepTextResourceID(step: ProductionStep): Int {
    return stepToText[step]!!
}