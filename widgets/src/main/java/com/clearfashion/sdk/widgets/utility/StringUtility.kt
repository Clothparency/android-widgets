package com.clearfashion.sdk.widgets.utility

internal class Strings {
    companion object {
        const val Empty = ""
        const val Coma = ","
        const val Space = " "
        const val NewLine = "\n"
    }
}

fun joinWithComa(list: Array<String>): String {
    return list.joinToString("${Strings.Coma}${Strings.Space}")
}