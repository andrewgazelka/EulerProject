package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem
import com.github.andrewgazelka.eulerproject.util.fib
import com.github.andrewgazelka.eulerproject.util.isEven

class Problem2(private val to: Long = 4_000_000L) {

    inner class Obvious : Problem<Long> { // TODO: finish non-obvious solution
        override fun solve() = fib()
            .filter { it.isEven }
            .takeWhile { it <= to }
            .sum()
    }
}
