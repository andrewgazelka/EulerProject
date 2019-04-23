package com.github.andrewgazelka.eulerproject.problem004

import com.github.andrewgazelka.eulerproject.util.isPalindrome

fun largestPalindrome(): PalindromeResult? {

    var palindromeResult: PalindromeResult? = null
    for (a in 900..999) {
        for (b in 900..999) {
            val mult = a * b
            if (mult.isPalindrome) {
                if (palindromeResult == null || palindromeResult.result < mult) {
                    palindromeResult = PalindromeResult(a, b, mult)
                }
            }
        }
    }
    return palindromeResult
}

data class PalindromeResult(val a: Int, val b: Int, val result: Int)
