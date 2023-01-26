package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.R

internal enum class LogoColor {
    Black, Grey
}

private val colorToLogo = mapOf<LogoColor, Int>(
    LogoColor.Grey to R.drawable.logo_with_text_grey,
    LogoColor.Black to R.drawable.logo_with_text_black,
)

@Composable
internal fun LogoWithText(color: LogoColor = LogoColor.Black, modifier: Modifier = Modifier.height(12.dp)) {
    Image(
        painter = painterResource(colorToLogo[color]!!),
        contentDescription = "Clear Fashion",
        modifier = modifier
    )
}