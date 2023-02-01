package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.ui.theme.DefaultFont

@Composable
internal fun SubTitle(text : String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontFamily = DefaultFont,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = Color.Grey600,
        lineHeight = 18.sp,
        modifier = modifier
    )
}