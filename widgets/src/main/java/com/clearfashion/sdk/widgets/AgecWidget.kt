package com.clearfashion.sdk.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetButtonContent
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetContent
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import com.clearfashion.sdk.widgets.utility.getResources

/**
 * DOC ME
 */
@Composable
fun AgecWidget(
    modifier: Modifier = Modifier,
) {
    val resources = getResources()

    WidgetButton(
        title = resources.getString(R.string.agec_title),
        modifier = modifier,
        closedContent = { AgecWidgetButtonContent() }
    ) {
        AgecWidgetContent()
    }
}
