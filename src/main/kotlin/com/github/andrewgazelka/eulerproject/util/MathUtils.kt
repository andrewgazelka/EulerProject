package com.github.andrewgazelka.eulerproject.util

import kotlin.math.ceil
import kotlin.math.sqrt

fun gauss(min: Int, max: Int, numberCount: Int): Int {
    return ((min + max) * numberCount) / 2
}

fun Int.largestMultiple(factor: Int): Int {
    if (this < factor) throw IllegalArgumentException("factor must be less than number")
    return (this / factor) * factor
}

fun fib(base: Pair<Long, Long> = Pair(1L, 2L)) = generateSequence(base) {
    Pair(it.second, it.first + it.second)
}.map { it.first }

val Int.isEven get() = this % 2 == 0
val Long.isEven get() = this % 2 == 0L

val Int.isOdd get() = !isEven
val Long.isOdd get() = this % 2 == 0L


tailrec fun Long.factors(from: Long = 2L, list: ArrayList<Long> = ArrayList()): List<Long> {
    val to = ceil(sqrt(this.toDouble())) // ceil because of floating point when really should be floor
    for(i in from..to.toLong()){
        if(this % i == 0L) {
            list.add(i)
            return (this/i).factors(from, list)
        }
    }
    list.add(this)
    return list
}
