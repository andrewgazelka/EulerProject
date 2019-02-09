package com.github.andrewgazelka.eulerproject.test

import com.github.andrewgazelka.eulerproject.problems.Problem1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem1Test{

    @Test
    fun `test right`(){
        println(Problem1().Obvious().solve())
        println(Problem1().Efficient().solve())
    }

    @Test
    fun `test example`(){
        val problem1 = Problem1(10)
        assertEquals(23, problem1.Obvious().solve())
        assertEquals(23, problem1.Efficient().solve())
    }
}
