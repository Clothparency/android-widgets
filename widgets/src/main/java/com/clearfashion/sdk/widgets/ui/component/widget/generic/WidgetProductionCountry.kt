package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.model.ProductionStep
import com.clearfashion.sdk.widgets.ui.component.SubTitle
import com.clearfashion.sdk.widgets.ui.component.Title
import com.clearfashion.sdk.widgets.utility.getProductionStepResourceID
import com.clearfashion.sdk.widgets.utility.getProductionStepText

@Composable
fun WidgetProductionCountry(step: ProductionStep, country: String, modifier: Modifier = Modifier) {
    WidgetSubSectionWithImage(
        resourceId = getProductionStepResourceID(step),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        SubTitle(getProductionStepText(step))
        Spacer(modifier = Modifier.size(8.dp))
        Title(country)
    }
}