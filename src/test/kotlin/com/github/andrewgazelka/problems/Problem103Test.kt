package com.github.andrewgazelka.problems

import com.github.andrewgazelka.eulerproject.problems.solve103
import com.github.andrewgazelka.eulerproject.problems.transform
import com.github.andrewgazelka.eulerproject.util.allCombinations
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem103Test {

    @Test
    fun `test solution`(){
        assertEquals(listOf(20, 31, 38, 39, 40, 42, 45), solve103())
    }
}
