package com.clearfashion.sdk.widgets.utility

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun getResources(): Resources {
    return LocalContext.current.resources;
}