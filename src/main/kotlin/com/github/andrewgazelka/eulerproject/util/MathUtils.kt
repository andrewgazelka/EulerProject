package com.github.andrewgazelka.eulerproject.util

import com.github.andrewgazelka.eulerproject.problems.FactorResult
import kotlin.math.ceil
import kotlin.math.log2
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


fun Collection<Long>.product(): Long = reduce { acc, l -> acc * l }

fun sudoko() {

}


fun generateS(number: Long) {

}


fun distinctLoop(depth: Int, range: IntRange, block: (IntArray) -> Unit) = distinctLoopHelper(depth, range, 0, IntArray(depth), block)

private fun distinctLoopHelper(depth: Int, range: IntRange, on: Int, counter: IntArray, block: (IntArray) -> Unit) {
    for (i in range) {
        counter[on] = i
        if (depth == 1) {
            block(counter)
        }
        else distinctLoopHelper(depth-1, i..range.endInclusive, on+1, counter, block)
    }
}


fun generateTest(boolean: Boolean) = sequence {
    if(boolean) yieldAll(setOf(1,2,3))
    else yield(generateTest(!boolean))
}

fun productSumFactors(max: Int) = sequence {

    val size = log2(max.toDouble()).toInt() + 1
    val array = List(size) { 1 }.toIntArray()

    while (true) {
        var indexOn = array.size - 1
        array[indexOn]++
        var reduced: Int

        while (array.reduce { acc, i -> acc * i }.also { reduced = it } > max) { // for doesn't work
            indexOn--
            if (indexOn < 0) return@sequence
            val nextIndex = ++array[indexOn]
            array[indexOn + 1] = nextIndex
        }

        val sum = array.sum()
        val k = size + (reduced - sum)

        yield(FactorResult(k, reduced, array.toList()))
    }
}

tailrec fun Long.factors(from: Long = 2L, list: ArrayList<Long> = ArrayList()): List<Long> {
    val to = ceil(sqrt(this.toDouble())) // ceil because of floating point when really should be floor
    for (i in from..to.toLong()) {
        if (this % i == 0L) {
            list.add(i)
            return (this / i).factors(from, list)
        }
    }
    list.add(this)
    return list
}

val Int.isPalindrome: Boolean
    get() {
        val string = this.toString()
        val midpoint = string.length / 2

        val midpointEnd = midpoint
        val midpointStart = if (string.length % 2 == 0) midpoint else midpoint + 1

        val beginning = string.substring(0 until midpointEnd)
        val end = string.substring(midpointStart until string.length).reversed()
        return beginning == end
    }
