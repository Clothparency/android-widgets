package com.clearfashion.sdk.widgets.model

import androidx.compose.runtime.Composable
import com.clearfashion.sdk.widgets.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetButtonContent
import com.clearfashion.sdk.widgets.ui.component.widget.agec.AgecWidgetContent

interface Widget {
    val titleResourceID: Int
    val closedContent: @Composable () -> Unit
    val content: @Composable () -> Unit
}

private class AgecWidget: Widget {
    override val titleResourceID: Int
        get() = R.string.agec_title
    override val closedContent: @Composable () -> Unit
        get() = { AgecWidgetButtonContent() }
    override val content: @Composable () -> Unit
        get() = { AgecWidgetContent() }
}

private val typeToWidget = mapOf<ClearFashionWidgetType, Widget>(
    ClearFashionWidgetType.AGEC to AgecWidget(),
)

fun getWidget(type: ClearFashionWidgetType): Widget {
    return typeToWidget[type]!!
}