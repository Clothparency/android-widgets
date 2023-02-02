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
        internal const val INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error"
        internal const val DATA_NOT_FOUND_ERROR_MESSAGE = "Data not found"
        internal const val UNAUTHORIZED_ERROR_MESSAGE = "Unauthorized"
        internal const val GENERAL_ERROR_MESSAGE = "Something went wrong..."
        internal val INTERNAL_SERVER_ERROR_RESOURCE_ID = R.string.general_error_server_error
        internal val DATA_NOT_FOUND_ERROR_RESOURCE_ID = R.string.general_error_no_data
        internal val UNAUTHORIZED_ERROR_RESOURCE_ID = R.string.general_error_invalid_token
        internal val GENERAL_ERROR_RESOURCE_ID = R.string.general_error_general

        internal fun extractMessage(code: Int): String {
            return when (code) {
                500 -> INTERNAL_SERVER_ERROR_MESSAGE
                404 -> DATA_NOT_FOUND_ERROR_MESSAGE
                401 -> UNAUTHORIZED_ERROR_MESSAGE
                else -> GENERAL_ERROR_MESSAGE
            }
        }

        internal fun extractErrorMessageResourceID(code: Int): Int {
            return when (code) {
                500 -> INTERNAL_SERVER_ERROR_RESOURCE_ID
                404 -> DATA_NOT_FOUND_ERROR_RESOURCE_ID
                401 -> UNAUTHORIZED_ERROR_RESOURCE_ID
                else -> GENERAL_ERROR_RESOURCE_ID
            }
        }
    }
}

