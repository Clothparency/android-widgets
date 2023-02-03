package com.clearfashion.sdk.widgets.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class DescriptionTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testDescription_display() {
        val text = "Some description"

        composeTestRule.setContent {
            Description(text)
        }

        composeTestRule.onNodeWithText(text)
            .assertExists()
            .assertIsDisplayed()
    }
}