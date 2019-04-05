package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem103
import com.github.andrewgazelka.eulerproject.util.baseFrom
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem103Test {

    private val solutions = mapOf(
        1 to listOf(1),
        2 to listOf(1, 2),
        3 to listOf(2, 3, 4),
        4 to listOf(3, 5, 6, 7),
        5 to listOf(6, 9, 11, 12, 13),
        6 to listOf(11, 18, 19, 20, 22, 25),
        7 to listOf(20, 31, 38, 39, 40, 42, 45) // 20313839404245
    )

    @Test
    fun `test solution a `() {
        for (i in 1..7) {
            val solution = Problem103.solve(i)
            assertEquals(solutions[i], solution)
            println("$i: $solution")
        }
    }

    @Test
    fun `test solution`() {
        Problem103.apply {
            val nextIter = listOf(11, 18, 19, 20, 22, 25).nextIter()
                .format()
            println(nextIter)
        }
    }

    @Test
    fun `test transform correct`() {
        Problem103.apply {
            val original = listOf(1, 2, 3, 4)
            Assertions.assertEquals(listOf(2, 3, 4, 5, 6), original.baseFrom(2))
        }
    }
}
