package com.clearfashion.sdk.widgets.utility

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun getString(@StringRes id: Int, vararg formatArgs: String ): String {
    val resources = LocalContext.current.resources
    return resources.getString(id, formatArgs);
}