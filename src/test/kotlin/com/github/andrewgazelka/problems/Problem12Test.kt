package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem12
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem12Test {

    @Test
    fun `test solution`(){

        // should be 76576500
        assertEquals(76_576_500L, Problem12.solveBruteForce())
    }
}
