package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetSectionTitle
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetSectionTitleTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val title = "Title"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetSectionTitle(title)
        }
    }

    @Test
    fun testWidgetSectionTitle_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSectionTitle_displayTitle() {
        composeTestRule.onNodeWithText(title)
            .assertExists()
            .assertIsDisplayed()
    }
}