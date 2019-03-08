package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.util.Fraction
import com.github.andrewgazelka.eulerproject.util.digits
import com.github.andrewgazelka.eulerproject.util.fakeDivide
import com.github.andrewgazelka.eulerproject.util.productSumFactors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class UtilsTest {

    @Test
    fun `test distinct`() {
        for (productSumFactor in productSumFactors(20)) {
            println(productSumFactor)
        }
    }

    @Test
    fun `test fake divisible`() {
        assertEquals(Fraction(4, 8), Fraction(49, 98).fakeDivide)
        assertEquals(Fraction(3, 8), Fraction(39, 98).fakeDivide)
        assertNull(Fraction(43, 98).fakeDivide)
        assertEquals(Fraction(1, 3), Fraction(10, 30).fakeDivide)
        assertNull(Fraction(17, 85).fakeDivide)
    }

    @Test
    fun `test digits`() {
        assertEquals(listOf(1, 5, 2), 152.digits)
    }

    @Test
    fun `test min`() {
        productSumFactors(24_000)
            .filter { it.k in 2..30 }
            .groupBy { it.k }
            .map { entry ->
                entry.value.map { it }.minBy { it.result } ?: throw IllegalStateException("no min for ${entry.key}")
            }
            .forEach { println(it) }
    }
}
