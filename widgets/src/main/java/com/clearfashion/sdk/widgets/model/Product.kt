package com.clearfashion.sdk.widgets.model

import com.clearfashion.sdk.widgets.utility.Strings
import java.util.Arrays

internal data class ProductionStepOrigin(
    val step: String,
    val country_name: String
) {
    val country = country_name
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductionStepOrigin

        if (step != other.step) return false
        if (country != other.country) return false

        return true
    }

    override fun hashCode(): Int {
        var result = step.hashCode()
        result = 31 * result + country.hashCode()
        return result
    }
}

internal data class Product(
    val name: String,
    val brandName: String,
    val brandCode: String,
    val readableRecyclability: String,
    val shouldDisplayRecyclability: Boolean,
    val productCategory: String,
    val emittingMicroFiber: Boolean,
    val recycledPercentage: Int,
    val syntheticPercentage: Int,
    val productionStepOrigins: Array<ProductionStepOrigin>, // Todo: change struct
    val dangerousSubstances: Array<String>,
    val concerningSubstances: Array<String>,
    val hasMaterialImpacts: Boolean,
    val importedAt: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (name != other.name) return false
        if (brandName != other.brandName) return false
        if (brandCode != other.brandCode) return false
        if (readableRecyclability != other.readableRecyclability) return false
        if (shouldDisplayRecyclability != other.shouldDisplayRecyclability) return false
        if (productCategory != other.productCategory) return false
        if (emittingMicroFiber != other.emittingMicroFiber) return false
        if (recycledPercentage != other.recycledPercentage) return false
        if (syntheticPercentage != other.syntheticPercentage) return false
        if (!productionStepOrigins.contentEquals(other.productionStepOrigins)) return false
        if (!dangerousSubstances.contentEquals(other.dangerousSubstances)) return false
        if (!concerningSubstances.contentEquals(other.concerningSubstances)) return false
        if (hasMaterialImpacts != other.hasMaterialImpacts) return false
        if (importedAt != other.importedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + brandName.hashCode()
        result = 31 * result + brandCode.hashCode()
        result = 31 * result + readableRecyclability.hashCode()
        result = 31 * result + shouldDisplayRecyclability.hashCode()
        result = 31 * result + productCategory.hashCode()
        result = 31 * result + emittingMicroFiber.hashCode()
        result = 31 * result + recycledPercentage
        result = 31 * result + syntheticPercentage
        result = 31 * result + productionStepOrigins.contentHashCode()
        result = 31 * result + dangerousSubstances.contentHashCode()
        result = 31 * result + concerningSubstances.contentHashCode()
        result = 31 * result + hasMaterialImpacts.hashCode()
        result = 31 * result + importedAt.hashCode()
        return result
    }
}

internal val EMPTY_PRODUCT = Product(
    name = Strings.Empty,
    brandName = Strings.Empty,
    brandCode = Strings.Empty,
    readableRecyclability = Strings.Empty,
    shouldDisplayRecyclability = false,
    productCategory = Strings.Empty,
    emittingMicroFiber = false,
    recycledPercentage = -1,
    syntheticPercentage = -1,
    productionStepOrigins = emptyArray(),
    dangerousSubstances = emptyArray(),
    concerningSubstances = emptyArray(),
    hasMaterialImpacts = false,
    importedAt = Strings.Empty,
)