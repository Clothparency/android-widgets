package com.clearfashion.sdk.widgets.utility

import org.junit.Test

import org.junit.Assert.*

class StringUtilityTest {

    @Test
    fun testJoinWithComa() {
        val array = arrayOf(
            "first",
            "second",
            "third"
        )
        val expected = "first, second, third"
        assertEquals("Did not join properly", expected, joinWithComa(array))
    }
}