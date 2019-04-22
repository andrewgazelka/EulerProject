package com.github.andrewgazelka.eulerproject.util

import com.github.andrewgazelka.eulerproject.problems.FactorResult
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
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

/**
 * @return if b=10 and the list is {5,8,9}, then returns {10,15,18,19}
 */
fun List<Int>.baseFrom(b: Int): List<Int> {
    val last = this.map { it + b }
    val first = arrayListOf(b)
    first.addAll(last)
    return first
}

//fun generateTest(boolean: Boolean) = sequence {
//    if (boolean) yieldAll(setOf(1, 2, 3))
//    else yield(generateTest(!boolean))
//}

suspend fun <A, B> Iterable<A>.cmap(f: suspend (A) -> B): List<B> = coroutineScope {
    this@cmap.map { async { f(it) } }
        .map { it.await() }
}

val Int.digits get() = this.toString().map { it.toString().toInt() }

/**
 * used in 33
 */

val Fraction.fakeDivide: Fraction?
    get() {
        val top = numerator.digits
        val bottom = denominator.digits
        require(top.size == 2 && bottom.size == 2) { "Must be 2 digits" }
        val numerator = top - bottom
        if (numerator.size != 1) return null
        val denominator = bottom - top
        if (denominator.size != 1) return null
        return Fraction(numerator.first(), (denominator.first()))
    }


fun Sequence<IntArray>.addOn(ints: Sequence<Int>) = this
    .flatMap { array ->
        ints.map { num ->
            val newArray = IntArray(array.size + 1)
            for (i in 0 until array.size) {
                newArray[i] = array[i]
            }
            newArray[array.size] = num
            newArray
        }
    }

// 2,248
// 1,905


fun List<Int>.allSubsections(): Sequence<List<Int>> {
    val dimensions = (0..size)

    return dimensions.asSequence()
        .flatMap { dimension ->
            multiForSequence(range = 0 until size, dimension = dimension)
                .filter { it.asIterable().isIncreasing() }
                .map { this.subList(it) }
        }
}

fun List<Int>.subList(indexes: IntArray) = indexes.map { this[it] }
fun List<Int>.subList(indexes: Iterable<Int>) = indexes.map { this[it] }

fun doubleSplitIndexes(list: List<Int>) = sequence {
    val allIndexes = (0 until list.size).toSet()

    val permutationSizes = 0..list.size
    val primaryIndexes = (permutationSizes)
        .asSequence()
        .flatMap { permutationSize ->
            multiForSequence(range = 0 until list.size, dimension = permutationSize).filter {
                it.asIterable().isIncreasing() // avoids repeated indexes
            }
        }
        .map { it.toSet() }

    for (primaryIndex in primaryIndexes) {
        val secondaryIndex = allIndexes - primaryIndex
        val pair = Pair(primaryIndex, secondaryIndex)
        yield(pair)
    }
}

fun doubleSplit(list: List<Int>) =
    doubleSplitIndexes(list)
        .map { indexPair ->
            val firstPart = list.subList(indexPair.first)
            val secondPart = list.subList(indexPair.second)
            Pair(firstPart, secondPart)
        }

fun List<Int>.allTwoSubsets(): Sequence<Pair<List<Int>, List<Int>>> {
    val doubleSplit = doubleSplit(this)
        .flatMap { (first, second) ->
            second.allSubsections().map { Pair(first, it) }
        }

    return doubleSplit
}

fun <T> Pair<T, T>.all(predicate: (T) -> Boolean) = this.toList().all(predicate)

fun List<Int>.isSpecialSubset(): Boolean {
    val doubleSplit = this.sorted().allTwoSubsets().filter { pair ->
        pair.all { it.isNotEmpty() }
    }

    return doubleSplit.all {

        val first = it.first
        val firstSum by lazy { first.sum() }

        val second = it.second
        val secondSum by lazy { second.sum() }

        val size1 = first.size
        val size2 = second.size

        if (size1 > size2) {
            return@all firstSum > secondSum
        } else if (size1 == size2) {
            return@all firstSum != secondSum
        }
        return@all true
    }
}


fun diophantineReciprocals(n: Long) = sequence {

    // 1/x + 1/y = 1/n
    // (y + x) /(xy) = 1/n
    // n(y+x) = (xy)
    // ny + nx = xy
    // nx = (x-n)y
    // y = nx/(x-n)


    // 1/x

    for (x in (n+1).. n * 2) {
        if ((n * x) % (x - n) == 0L) yield(Pair(x, (n*x) / (x-n)))
    }
}

fun triangleNumbers() = sequence {
    var counter = 1
    yield(1)
    incrementingSequence(2).forEach {
        counter+=it
        yield(counter)
    }
}

fun diphantineReciprocalsCount(n: Long): Int {
    var count = 0
    for (x in (n+1)..n * 2) {
        if (n * x % (x - n) == 0L) count++
    }
    return count
}

fun multiForSequence(range: Iterable<Int>, dimension: Int) =
    generateSequence(sequenceOf(intArrayOf())) { it.addOn(range.asSequence()) }
        .take(dimension + 1)
        .last()

fun multiFor(range: Iterable<Int>, dimension: Int, block: (IntArray) -> Unit) =
    multiForSequence(range, dimension).map(block)


fun Iterable<Int>.isIncreasing(): Boolean {
    var lastNum = Int.MIN_VALUE
    for (num in this) {
        if (num > lastNum) {
            lastNum = num
        } else return false
    }
    return true
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
            for (i in indexOn until size) array[i] = nextIndex
        }

        val sum = array.sum()
        val k = size + (reduced - sum)

        yield(FactorResult(k, reduced, array.toList()))
    }
}

fun incrementingSequence(base: Int = 1) = generateSequence(base) {
    it + 1
}

fun Int.factors(from: Int = 2, list: ArrayList<Int> = ArrayList()): List<Int> {
    val to = sqrt(this.toDouble()).toInt() + 1 // ceil because of floating point when really should be floor
    for (i in from..to) {
        if (this % i == 0) {
            list.add(i)
            return (this / i).factors(from, list)
        }
    }
    if (this > 1) list.add(this)
    return list
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

fun Iterable<Int>.product() = reduce { acc, i -> acc * i }


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
