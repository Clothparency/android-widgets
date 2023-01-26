package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
internal fun OpenedWidget(
    title: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()
    Popup() {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column() {
                OpenedWidgetHeader(title, onClose)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(state = scrollState)
                ) {
                    content()
                    WidgetFooter()
                }
            }
        }
    }
}