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
import com.clearfashion.sdk.widgets.utility.getEnvironmentImpactLogoResourceID
import com.clearfashion.sdk.widgets.utility.getEnvironmentImpactTextResourceID
import com.clearfashion.sdk.widgets.utility.getResources

@Composable
internal fun WidgetEnvironmentImpact(
    impact: EnvironmentImpact,
    title: String,
    description: String
) {
    val resources = getResources();

    WidgetSubSectionWithImage(resourceId = getEnvironmentImpactLogoResourceID(impact)) {
        SubTitle(resources.getString(getEnvironmentImpactTextResourceID(impact)))
        Spacer(modifier = Modifier.size(8.dp))
        Title(text = title)
        Spacer(modifier = Modifier.size(8.dp))
        Description(text = description)
    }
}