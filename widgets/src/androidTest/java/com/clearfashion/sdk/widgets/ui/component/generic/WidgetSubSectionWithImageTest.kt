package com.clearfashion.sdk.widgets.ui.component.generic

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.ui.component.widget.generic.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WidgetSubSectionWithImageTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val content = "Content"

    @Before
    fun setup() {
        composeTestRule.setContent {
            WidgetSubSectionWithImage(R.drawable.dyeing_and_printing) {
                Text(content)
            }
        }
    }

    @Test
    fun testWidgetSubSectionWithImage_display() {
        composeTestRule.onRoot()
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSubSectionWithImage_displayContent() {
        composeTestRule.onNodeWithText(content)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testWidgetSubSectionWithImage_displayImage() {
        composeTestRule.onNodeWithContentDescription("Logo")
            .assertExists()
            .assertIsDisplayed()
    }
}