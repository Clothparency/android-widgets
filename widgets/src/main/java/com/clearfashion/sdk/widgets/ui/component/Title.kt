package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.ui.theme.DefaultFont

@Composable
internal fun Title(text : String, textAlign: TextAlign = TextAlign.Left, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontFamily = DefaultFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        color = Color.Grey600,
        lineHeight = 20.sp,
        textAlign = textAlign,
        modifier = modifier
    )
}