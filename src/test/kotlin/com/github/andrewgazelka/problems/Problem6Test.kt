package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem6
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem6Test {

    @Test
    fun `test solution`() {
        assertEquals(25164150L, Problem6.solve())
    }
}
