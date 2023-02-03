package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.ProductionStep
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetProductionCountry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetProductionCountryTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val countryName: String = "Country"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetProductionCountry(ProductionStep.Assembly, countryName)
        }
    }

    @Test
    fun testWidgetProductionCountry_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetProductionCountry_displayCountry() {
        composeTestRule.onNodeWithText(countryName)
            .assertExists()
            .assertIsDisplayed()
    }
}