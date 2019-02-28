package com.github.andrewgazelka.eulerproject.test

import com.github.andrewgazelka.eulerproject.util.isPalindrome
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Problem4Test {

    @Test
    fun `test palindrome even`(){
        assertFalse(1572.isPalindrome)
        assertFalse(1571.isPalindrome)
        assertTrue(1221.isPalindrome)
    }

    @Test
    fun `test palindrome odd`(){
        assertFalse(157.isPalindrome)
        assertTrue(12521.isPalindrome)
    }
}
