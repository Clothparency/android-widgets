package com.clearfashion.sdk.widgets.model

import androidx.compose.runtime.Composable
internal interface Widget {
    val title: @Composable () -> Unit
    val closedContent: @Composable () -> Unit
    val content: @Composable () -> Unit
}