package com.clearfashion.sdk.widgets.api

import org.junit.Assert.*
import org.junit.Test

class APIErrorTest {
    @Test
    fun testExtractMessage_generalError() {
        assertEquals(
            APIError.GENERAL_ERROR_MESSAGE,
            APIError.extractMessage(-1)
        )
    }

    @Test
    fun testExtractMessage_internalServerError() {
        assertEquals(
            APIError.INTERNAL_SERVER_ERROR_MESSAGE,
            APIError.extractMessage(500)
        )
    }

    @Test
    fun testExtractMessage_dataNotFoundError() {
        assertEquals(
            APIError.DATA_NOT_FOUND_ERROR_MESSAGE,
            APIError.extractMessage(404)
        )
    }

    @Test
    fun testExtractMessage_unauthorizedError() {
        assertEquals(
            APIError.UNAUTHORIZED_ERROR_MESSAGE,
            APIError.extractMessage(401)
        )
    }
    @Test
    fun testExtractErrorMessageResourceID_generalError() {
        assertEquals(
            APIError.GENERAL_ERROR_RESOURCE_ID,
            APIError.extractErrorMessageResourceID(-1)
        )
    }

    @Test
    fun testExtractErrorMessageResourceID_internalServerError() {
        assertEquals(
            APIError.INTERNAL_SERVER_ERROR_RESOURCE_ID,
            APIError.extractErrorMessageResourceID(500)
        )
    }

    @Test
    fun testExtractErrorMessageResourceID_dataNotFoundError() {
        assertEquals(
            APIError.DATA_NOT_FOUND_ERROR_RESOURCE_ID,
            APIError.extractErrorMessageResourceID(404)
        )
    }

    @Test
    fun testExtractErrorMessageResourceID_unauthorizedError() {
        assertEquals(
            APIError.UNAUTHORIZED_ERROR_RESOURCE_ID,
            APIError.extractErrorMessageResourceID(401)
        )
    }

    @Test
    fun testAPIError_constructorWithResponseCode() {
        val error = APIError(500)
        assertEquals(APIError.INTERNAL_SERVER_ERROR_MESSAGE, error.message)
        assertEquals(APIError.INTERNAL_SERVER_ERROR_RESOURCE_ID, error.errorMessageResourceID)
    }

    @Test
    fun testAPIError_constructorWithThrowable() {
        val error = APIError(500, Exception())
        assertEquals(APIError.INTERNAL_SERVER_ERROR_MESSAGE, error.message)
        assertEquals(APIError.INTERNAL_SERVER_ERROR_RESOURCE_ID, error.errorMessageResourceID)
    }
}