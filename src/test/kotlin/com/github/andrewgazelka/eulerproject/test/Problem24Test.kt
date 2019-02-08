package com.github.andrewgazelka.eulerproject.test

import nextIter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem24Test {

    private val answer = listOf(2, 7, 8, 3, 9, 1, 5, 4, 6, 0)
    private val start = (0..9).toList()

    @Test
    fun testSlow() {
        var nums = start
        repeat(1_000_000 - 1) { nums = nextIter(nums) }
        assertEquals(answer, nums)
    }

    @Test
    fun testFast() {
        val map = (1L..10L).associateBy({ it }, { it.factorial() })
        println(map)
        // 362880*2+40320*6+5040*6+720*2+120*5+24+6*2+2*2
        (start.size - 1).toLong().factorial()
    }

    fun Long.factorial(): Long {
        return when(this){
            0L, 1L -> 1L
            else -> (2..this).reduce { acc, i -> acc*i }
        }
    }
}
