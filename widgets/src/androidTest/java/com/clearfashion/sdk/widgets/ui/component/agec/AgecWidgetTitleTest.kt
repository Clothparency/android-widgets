package com.clearfashion.sdk.widgets.ui.component.agec

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetTitle
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgecWidgetTitleTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    g
    @Before
    fun setup() {
        composeTestRule.setContent {
            AgecWidgetTitle(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testAgecWidgetTitle_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}