package com.clearfashion.sdk.widgets.ui.component.agec

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetBanner
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AgecWidgetBannerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            AgecWidgetBanner(Product.EMPTY_PRODUCT)
        }
    }

    @Test
    fun testAgecWidgetBanner_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}