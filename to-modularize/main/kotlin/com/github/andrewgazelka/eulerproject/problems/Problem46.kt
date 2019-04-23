package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem

class Problem46 : Problem<Long> {

    override fun solve(): Long {
        return generateSequence(3L) { it + 2L }
            .filter { !it.isPrime } // must be composite
            .first { !it.isValid() } // filter not valid
    }
}

fun Long.isValid() =
    generateSequence(1) { it + 1 }
        .map { 2 * it * it } // perfect square times 2
        .takeWhile { it < this }
        .any { (this - it).isPrime }

