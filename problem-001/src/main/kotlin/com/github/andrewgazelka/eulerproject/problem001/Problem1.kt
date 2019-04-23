package com.github.andrewgazelka.eulerproject.problem001

import com.github.andrewgazelka.eulerproject.utils.gauss
import com.github.andrewgazelka.eulerproject.utils.largestMultiple

const val DEFAULT_TO = 1000
const val DEFAULT_MULTIPLE1 = 3
const val DEFAULT_MULTIPLE2 = 5

fun solveEfficient(to: Int, multiple1: Int, multiple2: Int): Int {
    fun multiplesSum(num: Int) = if (num >= to) 0 else {
        val oneLower = to - 1
        gauss(min = num, max = oneLower.largestMultiple(num), count = (oneLower) / num)
    }
    return multiplesSum(multiple1) + multiplesSum(multiple2) - multiplesSum(multiple1 * multiple2)
}

fun solveObvious(to: Int, multiple1: Int, multiple2: Int): Int {
    return (1 until to)
        .filter { it % multiple1 == 0 || it % multiple2 == 0 }
        .sum()
}
