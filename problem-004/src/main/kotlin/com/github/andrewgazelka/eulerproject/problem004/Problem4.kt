package com.github.andrewgazelka.eulerproject.problem004

import com.github.andrewgazelka.eulerproject.utils.isPalindrome

fun solve(): PalindromeResult? { // TODO: include max

    var palindromeResult: PalindromeResult? = null
    for (first in 900..999) {
        for (second in 900..999) {
            val mult = first * second
            if (mult.isPalindrome) {
                if (palindromeResult == null || palindromeResult.product < mult) {
                    palindromeResult = PalindromeResult(first, second, mult)
                }
            }
        }
    }
    return palindromeResult
}

data class PalindromeResult(val first: Int, val second: Int, val product: Int)
