package com.github.andrewgazelka.eulerproject.test

import eulerproject.chainLength
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem14Test{

    fun `test result`(){
        // 837799
//        assertEquals(,870873746)
    }

    @Test
    fun `test basic cases`(){
        assertEquals(2, 2L.chainLength())
        assertEquals(8, 3L.chainLength())
    }
}
