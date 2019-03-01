package com.github.andrewgazelka.eulerproject.test

import com.github.andrewgazelka.eulerproject.util.productSumFactors
import org.junit.jupiter.api.Test

class MathUtilsTest {

    @Test
    fun `distinct test`() {
        for (productSumFactor in productSumFactors(20)) {
            println(productSumFactor)
        }
    }

    @Test
    fun `test min`(){
        productSumFactors(24_000)
            .filter { it.k in 2..30 }
            .groupBy { it.k }
            .map { entry -> entry.value.map { it }.minBy{it.result} ?: throw IllegalStateException("no min for ${entry.key}") }
            .forEach { println(it) }
    }
}
