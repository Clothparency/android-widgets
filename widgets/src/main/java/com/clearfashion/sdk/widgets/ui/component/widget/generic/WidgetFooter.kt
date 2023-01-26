package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.component.Description
import com.clearfashion.sdk.widgets.ui.component.LogoWithText
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.utility.getResources

@Composable
internal fun WidgetFooter(modifier: Modifier = Modifier) {
    val resources = getResources()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp, 32.dp)
    ) {
        LogoWithText(modifier = Modifier.height(14.dp))
        Spacer(modifier = Modifier.size(16.dp))
        Description(
            text = resources.getString(R.string.general_footer_legals, "Sweat mixte bleu glycine"),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Description(text = resources.getString(R.string.general_footer_updated_at, "13/08/2023"))
    }
}