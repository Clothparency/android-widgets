package com.clearfashion.sdk.widgets.utility

internal class Strings {
    companion object {
        const val Empty = ""
        const val Coma = ","
        const val Space = " "
        const val NewLine = "\n"
        const val ForwardSlash = "/"
    }
}

fun joinWithComa(array: Array<String>): String {
    return array.joinToString("${Strings.Coma}${Strings.Space}")
}