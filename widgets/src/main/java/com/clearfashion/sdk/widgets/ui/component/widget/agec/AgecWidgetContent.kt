package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AgecWidgetContent(modifier: Modifier = Modifier) {
    AgecWidgetBanner()
    AgecWidgetProductionContries()
    AgecWidgetImpact()
}