package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem41
import com.github.andrewgazelka.eulerproject.problems.isPermutation
import com.github.andrewgazelka.eulerproject.problems.isPrime
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Problem41Test {

    @Test
    fun `test abc`(){

        println(measureTimeMillis {
            val problem41 = Problem41()
            problem41.solve()
        })
    }

    @Test
    fun `testIsPermutation`(){
        val nums = setOf(1,2,3)
        assertTrue(123L.isPermutation(nums))
    }

    @Test
    fun `testRee`(){
        val num = 7654321L
        assertFalse(num.isPrime)
    }
}
