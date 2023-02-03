package com.clearfashion.sdk.widgets.utility

import com.clearfashion.sdk.widgets.model.AgecWidget
import com.clearfashion.sdk.widgets.model.Product.Companion.EMPTY_PRODUCT
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetType
import org.junit.Test

import org.junit.Assert.*

class WidgetUtilityTest {

    @Test
    fun testGetWidget_instantiateTheCorrectWidget() {
        assertTrue(getWidget(ClearFashionWidgetType.AGEC, EMPTY_PRODUCT) is AgecWidget)
    }
}