package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.*
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import org.junit.Test

import org.junit.Assert.*

class EnvironmentImpactUtilityTest {

    @Test
    fun testGetEnvironmentImpactLogoResourceID_withExistingImpact() {
        val actual = getEnvironmentImpactLogoResourceID(EnvironmentImpact.RawMaterial)
        val expected = R.drawable.raw_material
        assertEquals(expected, actual)
    }

    @Test
    fun testGetEnvironmentImpactTextResourceID_withExistingImpact() {
        val actual = getEnvironmentImpactTextResourceID(EnvironmentImpact.Recyclability)
        val expected = R.string.general_section_environment_impact_recyclability
        assertEquals(expected, actual)
    }

    @Test
    fun testHasDangerousSubstances_returnsTrue() {
        val product = Product(
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
            dangerousSubstances = arrayOf("Poil de carotte"),
            concerningSubstances = emptyArray(),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasDangerousSubstances(product))
    }

    @Test
    fun testHasDangerousSubstances_returnsFalse() {
        val product = EMPTY_PRODUCT

        assertFalse(hasDangerousSubstances(product))
    }

    @Test
    fun testHasConcerningSubstances_returnsTrue() {
        val product = Product(
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
            concerningSubstances = arrayOf("Poil de carotte"),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasConcerningSubstances(product))
    }

    @Test
    fun testHasConcerningSubstances_returnsFalse() {
        val product = EMPTY_PRODUCT

        assertFalse(hasConcerningSubstances(product))
    }

    @Test
    fun testHasRiskSubstances_withConcerningSubstances_returnsTrue() {
        val product = Product(
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
            concerningSubstances = arrayOf("Poil de carotte"),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasRiskSubstances(product))
    }

    @Test
    fun testHasRiskSubstances_withDangerousSubstances_returnsTrue() {
        val product = Product(
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
            dangerousSubstances = arrayOf("Poil de carotte"),
            concerningSubstances = emptyArray(),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasRiskSubstances(product))
    }

    @Test
    fun testHasRiskSubstances_withBoth_returnsTrue() {
        val product = Product(
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
            dangerousSubstances = arrayOf("Poil de carotte"),
            concerningSubstances = arrayOf("Poil de carotte"),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasRiskSubstances(product))
    }

    @Test
    fun testHasRiskSubstances_returnsFalse() {
        val product = EMPTY_PRODUCT

        assertFalse(hasRiskSubstances(product))
    }

    @Test
    fun testHasImpact_withMaterialImpacts_returnTrue() {
        val product = Product(
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
            hasMaterialImpacts = true,
            importedAt = Strings.Empty,
        )

        assertTrue(hasImpact(product))
    }

    @Test
    fun testHasImpact_withRecyclability_returnTrue() {
        val product = Product(
            name = Strings.Empty,
            brandName = Strings.Empty,
            brandCode = Strings.Empty,
            readableRecyclability = Strings.Empty,
            shouldDisplayRecyclability = true,
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

        assertTrue(hasImpact(product))
    }

    @Test
    fun testHasImpact_withMicroFiber_returnTrue() {
        val product = Product(
            name = Strings.Empty,
            brandName = Strings.Empty,
            brandCode = Strings.Empty,
            readableRecyclability = Strings.Empty,
            shouldDisplayRecyclability = false,
            productCategory = Strings.Empty,
            emittingMicroFiber = true,
            recycledPercentage = -1,
            syntheticPercentage = -1,
            productionStepOrigins = emptyArray(),
            dangerousSubstances = emptyArray(),
            concerningSubstances = emptyArray(),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasImpact(product))
    }

    @Test
    fun testHasImpact_withRiskSubstances_returnTrue() {
        val product = Product(
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
            concerningSubstances = arrayOf("Poil de carotte"),
            hasMaterialImpacts = false,
            importedAt = Strings.Empty,
        )

        assertTrue(hasImpact(product))
    }

    @Test
    fun testHasImpact_withAll_returnTrue() {
        val product = Product(
            name = Strings.Empty,
            brandName = Strings.Empty,
            brandCode = Strings.Empty,
            readableRecyclability = Strings.Empty,
            shouldDisplayRecyclability = true,
            productCategory = Strings.Empty,
            emittingMicroFiber = true,
            recycledPercentage = -1,
            syntheticPercentage = -1,
            productionStepOrigins = emptyArray(),
            dangerousSubstances = emptyArray(),
            concerningSubstances = arrayOf("Poil de carotte"),
            hasMaterialImpacts = true,
            importedAt = Strings.Empty,
        )

        assertTrue(hasImpact(product))
    }

    @Test
    fun testHasImpact_returnFalse() {
        val product = EMPTY_PRODUCT

        assertFalse(hasImpact(product))
    }
}