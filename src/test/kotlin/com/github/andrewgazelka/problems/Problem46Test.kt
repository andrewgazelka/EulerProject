package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem46
import com.github.andrewgazelka.eulerproject.problems.isValid
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Problem46Test {

    @Test
    fun `test abc`(){
        assertTrue(3L.isValid())
        assertTrue(5L.isValid())
        assertTrue(7L.isValid())
        assertTrue(9L.isValid())
        assertTrue(11L.isValid())
        assertTrue(13L.isValid())
    }

    @Test
    fun `test result`(){
        print(Problem46().solve())
    }
}
