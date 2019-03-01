package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem
import com.github.andrewgazelka.eulerproject.util.productSumFactors

class Problem88(private val max: Int = 24_000) : Problem<Int> {

    override fun solve(): Int {
        return productSumFactors(max)
            .filter { it.k in 2..12_000 }
            .groupBy { it.k }
            .map { entry -> entry.value.map { it.result }.min() ?: throw IllegalStateException("no min for ${entry.key}") }
            .sum()
    }
}

data class FactorResult(val k: Int, val result: Int, val list: List<Int>)
