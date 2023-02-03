package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSubSection
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetSubSectionTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val content = "Content"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetSubSection {
                Text(content)
            }
        }
    }

    @Test
    fun testWidgetSubSection_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSubSection_displayContent() {
        composeTestRule.onNodeWithText(content)
            .assertExists()
            .assertIsDisplayed()
    }
}