package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.Title
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.utility.hasImpact

@Composable
internal fun AgecWidgetTitle(product: Product) {
    val resources = getResources()
    val titleResourceID =
        if (hasImpact(product)) R.string.agec_title
        else R.string.agec_title_tracability_only

    Title(
        text = resources.getString(titleResourceID),
        textAlign = TextAlign.Center
    )
}