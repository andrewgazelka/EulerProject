package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.isPalindrome

fun main() {
    largestPalendrome()?.also { println(it) }
}
fun largestPalendrome(): PalindromeResult? {

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
