package com.github.andrewgazelka.problem001

import com.github.andrewgazelka.eulerproject.problem001.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem1Test {

    @Test
    fun `test example`() {

        val functions = listOf(::solveEfficient, ::solveObvious)

        functions.forEach {
            assertEquals(23, it(10, DEFAULT_MULTIPLE1, DEFAULT_MULTIPLE2))
        }
    }
}
