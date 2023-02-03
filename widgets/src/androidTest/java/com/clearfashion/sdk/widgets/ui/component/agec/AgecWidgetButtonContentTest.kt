package com.clearfashion.sdk.widgets.ui.component.agec

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetButtonContent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgecWidgetButtonContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            AgecWidgetButtonContent(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testAgecWidgetButtonContent_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}