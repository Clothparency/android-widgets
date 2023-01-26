package com.clearfashion.sdk.widgets.utility

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

@Composable
internal fun getContext(): Context {
    return LocalContext.current;
}

@Composable
internal fun getResources(): Resources {
    return getContext().resources;
}

@Composable
internal fun setLocale(lang: ClearFashionWidgetLanguage) {
    val resources = getResources()
    val configuration = resources.configuration
    configuration.setLocale(lang.locale)
    val displayMetrics = resources.displayMetrics

    resources.updateConfiguration(configuration, displayMetrics);
}