package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.window.Popup
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetButtonTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val widgetOpenedText: String = "Opened Widget"
    private val widgetClosedText: String = "Closed Widget"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetButton(Product.EMPTY_PRODUCT, title = {}, closedContent = { Text(widgetClosedText) }) {
                Popup {
                    Text(widgetOpenedText)
                }
            }
        }
    }

    @Test
    fun testWidgetButton_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetButton_displayClosedContent() {
        composeTestRule.onNodeWithText(widgetClosedText)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetButton_opensPopup() {
        composeTestRule.onRoot().performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText(widgetOpenedText)
            .assertExists()
            .assertIsDisplayed()
    }
}