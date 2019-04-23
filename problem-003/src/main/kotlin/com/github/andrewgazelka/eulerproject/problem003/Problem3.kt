package com.github.andrewgazelka.eulerproject.problem003

import com.github.andrewgazelka.eulerproject.utils.primeFactors

const val DEFAULT_TO_FACTOR = 600851475143L

fun solve(toFactor: Long): Long {
    val factors = toFactor.primeFactors()
    return factors.max() ?: throw IllegalArgumentException("no productSumFactors")
}
