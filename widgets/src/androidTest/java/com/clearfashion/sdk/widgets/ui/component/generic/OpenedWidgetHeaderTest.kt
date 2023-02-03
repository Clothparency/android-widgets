package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.ui.component.widget.generic.OpenedWidgetHeader
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OpenedWidgetHeaderTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            OpenedWidgetHeader(title = { }, onClose = { })
        }
    }

    @Test
    fun testOpenedWidgetHeader_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}