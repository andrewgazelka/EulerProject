package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem12
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem12Test {

    @Test
    fun `test solution`() {

        // should be 76576500
        for (f in listOf(Problem12::solveBruteForce, Problem12::solveCombinatorics)) {
            assertEquals(76_576_500L, f(500)) { "$f" }
        }
    }
}
