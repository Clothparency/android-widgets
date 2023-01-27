package com.clearfashion.sdk.widgets.model

internal enum class ProductionStep(val stepName: String) {
    Assembly("assembly"),
    DyeingAndPrinting("dyeing_and_printing"),
    Finishing("finishing"),
    Manufacturing("manufacturing"),
    Stitching("stitching"),
    Weaving("weaving"),
    Unknown("unknown");

    companion object {
        fun fromName(name: String): ProductionStep {
            for (step in ProductionStep.values()) {
                if (step.stepName == name) {
                    return step
                }
            }
            return Unknown
        }
    }
}