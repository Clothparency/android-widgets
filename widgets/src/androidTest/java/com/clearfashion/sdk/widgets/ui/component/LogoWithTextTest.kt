package com.clearfashion.sdk.widgets.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class LogoWithTextTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testLogoWithText_display() {
        composeTestRule.setContent {
            LogoWithText()
        }

        composeTestRule.onNodeWithContentDescription("Clear Fashion")
            .assertExists()
            .assertIsDisplayed()
    }
}