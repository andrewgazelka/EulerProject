package com.github.andrewgazelka.eulerproject.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UtilsTest {


    private val specialSubsets = listOf(
        listOf(1),
        listOf(1, 2),
        listOf(2, 3, 4),
        listOf(3, 5, 6, 7),
        listOf(6, 9, 11, 12, 13)
    )

    @Test
    fun `test all subsections`() {
        assertEquals(
            "[[], [1], [3], [9], [1, 3], [1, 9], [3, 9], [1, 3, 9]]",
            listOf(1, 3, 9).allSubsections().toList().toString()
        )
    }

    @Test
    fun `test distinct true`() {
        for (productSumFactor in productSumFactors(20)) {
            println(productSumFactor)
        }
    }


    @Test
    fun `test factors`() {
        assertEquals(listOf(2, 2), 4.primeFactors())
        assertEquals(listOf(2, 2, 2, 3), 24.primeFactors())
    }

    @Test
    fun `test triangle numbers`(){
        val triangleNums = triangleNumbers().take(8).toList()
        assertEquals(listOf(1,3,6,10,15,21,28,36), triangleNums)
    }

    @Test
    fun `test reciprocal count`() {
        diophantineReciprocals(4)
            .forEach { println(it) }
    }

    @Test
    fun `test multi for`() {

        val expected = listOf(
            listOf(0, 0, 0),
            listOf(0, 0, 1),
            listOf(0, 0, 2),
            listOf(0, 1, 0),
            listOf(0, 1, 1),
            listOf(0, 1, 2),
            listOf(0, 2, 0),
            listOf(0, 2, 1),
            listOf(0, 2, 2),
            listOf(1, 0, 0),
            listOf(1, 0, 1),
            listOf(1, 0, 2),
            listOf(1, 1, 0),
            listOf(1, 1, 1),
            listOf(1, 1, 2),
            listOf(1, 2, 0),
            listOf(1, 2, 1),
            listOf(1, 2, 2),
            listOf(2, 0, 0),
            listOf(2, 0, 1),
            listOf(2, 0, 2),
            listOf(2, 1, 0),
            listOf(2, 1, 1),
            listOf(2, 1, 2),
            listOf(2, 2, 0),
            listOf(2, 2, 1),
            listOf(2, 2, 2)
        )

        assertEquals(3 * 3 * 3, expected.size)
        val result = multiForSequence(0 until 3, 3)
            .map { it.asList() }
            .toList()

        assertEquals(expected, result)
    }

    @Test
    fun `test special subset true`() {
        specialSubsets.forEach {
            println("testing: $it")
            assertTrue(it.isSpecialSubset())
        }
    }

    @Test
    fun `test special subset false`() {
        assertFalse(listOf(1, 3, 4, 5).isSpecialSubset())
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

        val result = multiForSequence(0 until 6, 2)
            .filter { it.asIterable().isIncreasing() }
            .map { it.toList() }
            .toList()

        assertEquals(expected, result)
    }

}
