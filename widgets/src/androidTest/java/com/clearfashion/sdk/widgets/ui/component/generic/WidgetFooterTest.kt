package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetFooter
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetFooterTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetFooter(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testWidgetFooter_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}