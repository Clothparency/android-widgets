package com.clearfashion.sdk.widgets.api

import com.clearfashion.sdk.widgets.R

internal class APIError : Exception {
    val errorMessageResourceID: Int

    constructor(responseCode: Int): super(extractMessage(responseCode)) {
        this.errorMessageResourceID = extractErrorMessageResourceID(responseCode)
    }

    constructor(
        responseCode: Int,
        throwable: Throwable
    ): super(extractMessage(responseCode), throwable) {
        this.errorMessageResourceID = extractErrorMessageResourceID(responseCode)
    }

    companion object {
        private fun extractMessage(code: Int): String {
            return when (code) {
                500 -> "Internal Server Error"
                404 -> "Data not found"
                401 -> "Unauthorized"
                else -> "Something went wrong..."
            }
        }

        private fun extractErrorMessageResourceID(code: Int): Int {
            return when (code) {
                500 -> R.string.general_error_server_error
                404 -> R.string.general_error_no_data
                401 -> R.string.general_error_invalid_token
                else -> R.string.general_error_general
            }
        }
    }
}

