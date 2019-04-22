package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.divisorCount
import com.github.andrewgazelka.eulerproject.util.halfDivisorsBf
import com.github.andrewgazelka.eulerproject.util.triangleNumbers

object Problem12 {
    fun solveBruteForce(threshold: Int = 500): Long {
        return triangleNumbers()
            .first { it.divisorCount() > threshold }
    }
}
