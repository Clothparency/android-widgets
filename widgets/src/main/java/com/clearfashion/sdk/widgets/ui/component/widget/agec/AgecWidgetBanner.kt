package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.theme.DefaultFont
import com.clearfashion.sdk.widgets.utility.getResources

@Composable
internal fun AgecWidgetBanner(product: Product) {
    val resources = getResources()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Grey20)
            .padding(32.dp, 24.dp)
    ) {
        Text(
            text = resources.getString(R.string.agec_banner, product.brandName),
            color = Color.Grey600,
            fontFamily = DefaultFont,
            textAlign = TextAlign.Center
        )
    }
}