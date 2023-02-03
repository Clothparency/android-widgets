package com.clearfashion.sdk.widgets.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class LoadableTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val errorMessage = "Oupsy, no good!"

    @Test
    fun testLoadable_display() {

        composeTestRule.setContent {
            Loadable(LoadableState.Loading, errorMessage, {}) {}
        }

        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }
}