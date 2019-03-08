package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.Problem3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem3Test {

    @Test
    fun `test solution`(){
        val solve = Problem3().Simple().solve()
        assertEquals(6857, solve)
    }
}
