package com.github.andrewgazelka.problem002

import com.github.andrewgazelka.eulerproject.problem002.DEFAULT_TO
import com.github.andrewgazelka.eulerproject.problem002.solve
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem2Test {

    @Test
    fun `test solution`() {
        assertEquals(4613732, solve(DEFAULT_TO))
    }
}
