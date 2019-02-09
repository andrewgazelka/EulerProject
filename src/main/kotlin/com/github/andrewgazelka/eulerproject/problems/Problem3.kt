package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem
import com.github.andrewgazelka.eulerproject.util.factors

class Problem3(private val toFactor: Long = 600851475143L) {
    inner class Simple: Problem<Long> {
        override fun solve(): Long {
            val factors = toFactor.factors()
            return factors.max() ?: throw IllegalArgumentException("no factors")
        }
    }
}
