package com.clearfashion.sdk.widgets.ui.component.agec

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetImpact
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgecWidgetImpactTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            AgecWidgetImpact(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testAgecWidgetImpact_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}