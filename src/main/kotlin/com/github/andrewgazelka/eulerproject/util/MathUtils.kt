package com.github.andrewgazelka.eulerproject.util

fun gauss(min: Int, max: Int, numberCount: Int): Int {
    return ((min + max) * numberCount)/2
}

fun Int.largestMultiple(factor: Int): Int {
    if(this < factor) throw IllegalArgumentException("factor must be less than number")
    return (this/factor) * factor
}
