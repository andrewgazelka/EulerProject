package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.divisorsCombinatoricsCount
import com.github.andrewgazelka.eulerproject.util.halfDivisorsBf
import com.github.andrewgazelka.eulerproject.util.triangleNumbers

object Problem12 {


    fun solve(threshold: Int = 500, numberToDivisors: (Long) -> Int): Long {
        return triangleNumbers()
            .first { num ->
                val divisorCount = numberToDivisors(num)
                divisorCount > threshold
            }
    }

    fun solveBruteForce(threshold: Int): Long = solve(threshold) { it.halfDivisorsBf().count() * 2 }

    fun solveCombinatorics(threshold: Int) = solve(threshold){ it.divisorsCombinatoricsCount() }
}
