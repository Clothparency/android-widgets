package com.clearfashion.sdk.widgets.utility

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage
import java.io.InputStream
import java.util.*

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

@Composable
internal fun getConfigurationProperties(): Properties {
    val properties = Properties()
    properties.load(getContext().assets.open("configuration.properties"))
    return properties
}

@Composable
internal fun getConfigurationProperty(key: String): String {
    return getConfigurationProperties().getProperty(key)
}


internal fun getConfigurationProperties(context: Context): Properties {
    val properties = Properties()
    properties.load(context.assets.open("configuration.properties"))
    return properties
}

internal fun getConfigurationProperty(context: Context, key: String): String {
    return getConfigurationProperties(context).getProperty(key)
}