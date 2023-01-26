package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.model.EnvironmentImpact
import com.clearfashion.sdk.widgets.ui.component.Description
import com.clearfashion.sdk.widgets.ui.component.SubTitle
import com.clearfashion.sdk.widgets.ui.component.Title
import com.clearfashion.sdk.widgets.utility.getEnvironmentImpactResourceID

@Composable
fun WidgetEnvironmentImpact(
    impact: EnvironmentImpact,
    title: String,
    description: String
) {
    WidgetSubSectionWithImage(resourceId = getEnvironmentImpactResourceID(impact)) {
        SubTitle(impact.name)
        Spacer(modifier = Modifier.size(8.dp))
        Title(text = title)
        Spacer(modifier = Modifier.size(8.dp))
        Description(text = description)
    }
}