package com.clearfashion.sdk.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetButtonContent
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetContent
import com.clearfashion.sdk.widgets.ui.component.widget.generic.WidgetButton
import com.clearfashion.sdk.widgets.utility.getString

/**
 * DOC ME
 */
@Composable
fun AgecWidget(
    modifier: Modifier = Modifier,
) {
    WidgetButton(
        title = getString(R.string.agec_title),
        modifier = modifier,
        closedContent = { AgecWidgetButtonContent() }
    ) {
        AgecWidgetContent()
    }
}
