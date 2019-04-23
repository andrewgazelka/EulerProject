package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem88
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Problem 88")
class Problem88Test {

    @Test
    fun `test problem 88`() {
        // currently returns 72_469_545
        assertEquals(7_587_457, Problem88().solve())
    }
}
