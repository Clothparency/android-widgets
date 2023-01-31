package com.clearfashion.sdk.widgets.model

internal data class ProductionStepOrigin(
    val step: String,
    val country_name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductionStepOrigin

        if (step != other.step) return false
        if (country_name != other.country_name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = step.hashCode()
        result = 31 * result + country_name.hashCode()
        return result
    }
}
