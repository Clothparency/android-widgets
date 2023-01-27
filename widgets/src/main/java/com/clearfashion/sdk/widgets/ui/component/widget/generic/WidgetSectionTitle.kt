package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.component.Title
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.utility.getBottomLineShape

@Composable
internal fun WidgetSectionTitle(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
            .border(
                1.dp,
                Color.Grey30,
                shape = getBottomLineShape(with(LocalDensity.current) { 1.dp.toPx() })
            )
    ) {
        if (text.isNotEmpty()) Title(text = text, modifier = Modifier.padding(0.dp, 24.dp))
        else Spacer(modifier = Modifier.size(24.dp))
    }
}