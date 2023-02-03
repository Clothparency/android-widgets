package com.clearfashion.sdk.widgets.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductionStepOriginTest {

    private val step: String = "Step"
    private val countryName: String = "Country"

    @Test
    fun testProductionStepOrigin() {
        val productionStepOrigin = ProductionStepOrigin(step, countryName)

        assertEquals(step, productionStepOrigin.step)
        assertEquals(countryName, productionStepOrigin.countryName)
    }
}