package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.transform
import com.github.andrewgazelka.eulerproject.util.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class UtilsTest {

    @Test
    fun `test transform correct`() {
        val original = listOf(1, 2, 3, 4)
        allCombinations(1..2, 5)
        assertEquals(listOf(2, 3, 4, 5, 6), original.transform(2))
    }

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

    @Test
    fun `test all combinations`() {
        
        val expected = listOf(
            listOf(0, 1),
            listOf(0, 2),
            listOf(0, 3),
            listOf(0, 4),
            listOf(0, 5),
            listOf(1, 2),
            listOf(1, 3),
            listOf(1, 4),
            listOf(1, 5),
            listOf(2, 3),
            listOf(2, 4),
            listOf(2, 5),
            listOf(3, 4),
            listOf(3, 5),
            listOf(4, 5)
        )

        val result = allCombinations(0 until 6, 2)
            .filter { it.asIterable().increasing() }
            .map { it.toList() }
            .toList()

        assertEquals(expected, result)
    }

}
