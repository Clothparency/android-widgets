package com.clearfashion.sdk.widgets.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ErrorTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val errorMessage = "Oupsy, no good!"

    @Before
    fun setup() {
        composeTestRule.setContent {
            Error(errorMessage, {})
        }
    }

    @Test
    fun testError_displayText() {
        composeTestRule.onNodeWithText(errorMessage)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testError_displayButton() {
        composeTestRule.onNode(hasClickAction())
            .assertExists()
            .assertIsDisplayed()
    }
}