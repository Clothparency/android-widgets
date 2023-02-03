package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.ProductionStep
import org.junit.Test

import org.junit.Assert.*

class ProductionStepUtilityTest {

    @Test
    fun testGetProductionStepLogoResourceID_withExistingStep() {
        val actual = getProductionStepLogoResourceID(ProductionStep.Assembly)
        val expected = R.drawable.assembly
        assertEquals(expected, actual)
    }

    @Test
    fun testGetProductionStepLogoResourceID_withUnknownStep() {
        val actual = getProductionStepLogoResourceID(ProductionStep.Unknown)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun testGetProductionStepTextResourceID_withExistingStep() {
        val actual = getProductionStepTextResourceID(ProductionStep.Finishing)
        val expected = R.string.general_section_production_step_finishing
        assertEquals(expected, actual)
    }

    @Test
    fun testGetProductionStepTextResourceID_withUnknownStep() {
        val actual = getProductionStepTextResourceID(ProductionStep.Unknown)
        val expected = 0
        assertEquals(expected, actual)
    }
}