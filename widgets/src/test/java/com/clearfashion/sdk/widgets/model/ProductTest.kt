package com.clearfashion.sdk.widgets.model

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductTest {
    private val name: String = "Name"
    private val brandName: String = "Brand Name"
    private val brandCode: String = "Brand Code"
    private val readableRecyclability: String = "Recyclability"
    private val shouldDisplayRecyclability: Boolean = true
    private val productCategory: String = "Product Category"
    private val emittingMicroFiber: Boolean = true
    private val recycledPercentage: Int = 45
    private val syntheticPercentage: Int = 67
    private val productionStepOrigins: Array<ProductionStepOrigin> = arrayOf(
        ProductionStepOrigin("Step", "Country")
    )
    private val dangerousSubstances: Array<String> = arrayOf("Dangerous Substance")
    private val concerningSubstances: Array<String> = arrayOf("Concerning Substance")
    private val hasMaterialImpacts: Boolean = true
    private val importedAt: String = "20/02/2023"

    @Test fun testProduct() {
        val product = Product(
            name,
            brandName,
            brandCode,
            readableRecyclability,
            shouldDisplayRecyclability,
            productCategory,
            emittingMicroFiber,
            recycledPercentage,
            syntheticPercentage,
            productionStepOrigins,
            dangerousSubstances,
            concerningSubstances,
            hasMaterialImpacts,
            importedAt
        )

        assertEquals(name, product.name)
        assertEquals(brandName, product.brandName)
        assertEquals(brandCode, product.brandCode)
        assertEquals(readableRecyclability, product.readableRecyclability)
        assertEquals(shouldDisplayRecyclability, product.shouldDisplayRecyclability)
        assertEquals(productCategory, product.productCategory)
        assertEquals(emittingMicroFiber, product.emittingMicroFiber)
        assertEquals(recycledPercentage, product.recycledPercentage)
        assertEquals(syntheticPercentage, product.syntheticPercentage)
        assertArrayEquals(productionStepOrigins, product.productionStepOrigins)
        assertArrayEquals(dangerousSubstances, product.dangerousSubstances)
        assertArrayEquals(concerningSubstances, product.concerningSubstances)
        assertEquals(hasMaterialImpacts, product.hasMaterialImpacts)
    }
}