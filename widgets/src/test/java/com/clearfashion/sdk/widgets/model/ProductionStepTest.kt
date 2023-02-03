package com.clearfashion.sdk.widgets.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductionStepTest {

    @Test
    fun testProductionStep_fromName_assembly() {
        val name = "assembly"
        assertEquals(ProductionStep.Assembly, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_dyeingAndPrinting() {
        val name = "dyeing_and_printing"
        assertEquals(ProductionStep.DyeingAndPrinting, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_finishing() {
        val name = "finishing"
        assertEquals(ProductionStep.Finishing, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_manufacturing() {
        val name = "manufacturing"
        assertEquals(ProductionStep.Manufacturing, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_stitching() {
        val name = "stitching"
        assertEquals(ProductionStep.Stitching, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_weaving() {
        val name = "weaving"
        assertEquals(ProductionStep.Weaving, ProductionStep.fromName(name))
    }

    @Test
    fun testProductionStep_fromName_unknown() {
        val name = "random"
        assertEquals(ProductionStep.Unknown, ProductionStep.fromName(name))
    }
}