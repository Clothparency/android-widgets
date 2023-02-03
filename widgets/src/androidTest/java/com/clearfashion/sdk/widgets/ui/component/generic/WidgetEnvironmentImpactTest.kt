package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetEnvironmentImpact
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetEnvironmentImpactTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val title = "Title"
    private val description = "Description"


    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetEnvironmentImpact(EnvironmentImpact.Uses, title, description)
        }
    }

    @Test
    fun testWidgetEnvironmentImpact_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetEnvironmentImpact_displayTitle() {
        composeTestRule.onNodeWithText(title)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetEnvironmentImpact_displayDescription() {
        composeTestRule.onNodeWithText(description)
            .assertExists()
            .assertIsDisplayed()
    }
}