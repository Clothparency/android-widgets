package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class LoadableState {
    Loading, Error, Loaded
}

@Composable
fun Loadable(
    state: LoadableState,
    errorMessage: String,
    apiCall: () -> Unit,
    content: @Composable () -> Unit
) {
    when (state) {
        LoadableState.Loading -> {
            Spacer(modifier = Modifier.size(75.dp))
            apiCall()
        }
        LoadableState.Error -> Error(errorMessage = errorMessage, onRetry = apiCall)
        LoadableState.Loaded -> content()
    }
}