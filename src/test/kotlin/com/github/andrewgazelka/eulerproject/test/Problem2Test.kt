package com.github.andrewgazelka.eulerproject.test

import com.github.andrewgazelka.eulerproject.Problem2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem2Test{

    @Test
    fun `test solution`(){
        assertEquals(4613732, Problem2().Obvious().solve())
    }
}
