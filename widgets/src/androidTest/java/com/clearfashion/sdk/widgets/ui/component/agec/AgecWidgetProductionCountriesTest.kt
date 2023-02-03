package com.clearfashion.sdk.widgets.ui.component.agec

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetProductionCountries
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgecWidgetProductionCountriesTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            AgecWidgetProductionCountries(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testAgecWidgetProductionCountries_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}