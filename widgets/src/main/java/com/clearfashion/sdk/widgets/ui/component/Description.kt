package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
fun Description(
    text : String,
    textAlign: TextAlign = TextAlign.Left,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = Color.Grey200,
        lineHeight = 18.sp,
        textAlign = textAlign,
        modifier = modifier
    )
}