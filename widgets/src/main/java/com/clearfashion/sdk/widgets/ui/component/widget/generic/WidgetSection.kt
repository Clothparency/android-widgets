package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
fun WidgetSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        WidgetSectionTitle(text = title)
        content()
    }
}