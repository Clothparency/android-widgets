package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.ProductionStep

val stepToLogo = mapOf<ProductionStep, Int>(
    ProductionStep.Assembly to R.drawable.assembly,
    ProductionStep.DyeingAndPrinting to R.drawable.dyeing_and_printing,
    ProductionStep.Finishing to R.drawable.finishing,
    ProductionStep.Manufacturing to R.drawable.manufacturing,
    ProductionStep.Stitching to R.drawable.stitching,
    ProductionStep.Weaving to R.drawable.weaving
)

fun getProductionStepResourceID(step: ProductionStep): Int {
    return stepToLogo[step]!!
}
g
val stepToText = mapOf<ProductionStep, String>(
    ProductionStep.Assembly to "Assembly",
    ProductionStep.DyeingAndPrinting to "Dyeing and printing",
    ProductionStep.Finishing to "Finishing",
    ProductionStep.Manufacturing to "Manufacturing",
    ProductionStep.Stitching to "Stitching",
    ProductionStep.Weaving to "Weaving"
)

fun getProductionStepText(step: ProductionStep): String {
    return stepToText[step]!!
}