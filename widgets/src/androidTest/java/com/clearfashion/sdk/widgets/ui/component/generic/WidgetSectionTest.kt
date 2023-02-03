package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSection
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetSectionTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val title = "Title"
    private val content = "Content"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetSection(title) {
                Text(content)
            }
        }
    }

    @Test
    fun testWidgetSection_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSection_displayTitle() {
        composeTestRule.onNodeWithText(title)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSection_displayContent() {
        composeTestRule.onNodeWithText(content)
            .assertExists()
            .assertIsDisplayed()
    }
}