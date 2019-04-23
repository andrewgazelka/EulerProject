package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem14
import com.github.andrewgazelka.eulerproject.problems.chainLength
import com.github.andrewgazelka.eulerproject.util.printTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem14Test{

    @Test
    fun `test result`(){
        assertEquals(837799L, Problem14().solve())
    }

    @Test
    fun `test basic cases`(){
        assertEquals(2, 2L.chainLength())
        assertEquals(8, 3L.chainLength())
    }

    @Test
    fun `test time`(){
        Problem14().printTime()
    }
}
