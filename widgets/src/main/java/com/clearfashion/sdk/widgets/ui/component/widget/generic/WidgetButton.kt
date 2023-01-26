package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
fun WidgetButton(
    title: String,
    modifier: Modifier = Modifier,
    closedContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    var isPressed by remember {
        mutableStateOf(false)
    }
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        OpenedWidget(title = title, onClose = { showDialog = false }) {
            content()
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(if (isPressed) Color.Grey30 else Color.White, shape = RoundedCornerShape(5.dp))
            .border(1.dp, Color.Grey30, shape = RoundedCornerShape(5.dp))
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                        } finally {
                            isPressed = false
                            showDialog = true
                        }
                    },
                )
            }
            .padding(16.dp)
    ) {
        closedContent()
    }
}
