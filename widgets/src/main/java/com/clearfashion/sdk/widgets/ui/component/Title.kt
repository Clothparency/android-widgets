package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
internal fun Title(text : String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        color = Color.Grey600,
        lineHeight = 20.sp,
        modifier = modifier
    )
}