package com.github.andrewgazelka.problem003

import com.github.andrewgazelka.eulerproject.problem003.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem3Test {

    @Test
    fun `test solution`(){
        val solve = solve(DEFAULT_TO_FACTOR)
        assertEquals(6857, solve)
    }
}
