package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.allCombinations
import com.github.andrewgazelka.eulerproject.util.increasing

val solve103 = fun(): List<Int> {
    val initList = listOf(11, 18, 19, 20, 22, 25)

    return generateSequence(1) { it + 1 }
        .map {
            initList.transform(it)
        }
        .first { it.isValid() }
}

val solve103Formatted = {
    solve103().fold("") { acc, i ->
        "$acc$i"
    }
}

fun List<Int>.transform(b: Int): List<Int> {
    val last = this.map { it + b }
    val first = arrayListOf(b)
    first.addAll(last)
    return first
}

fun doubleSplitIndexes(lists: List<Int>) = sequence {
    val allIndexes = (1 until lists.size).toSet()
    val primaryIndexes = (0..lists.size)
        .asSequence()
        .flatMap { permutationSize ->
            allCombinations(0 until lists.size, permutationSize).filter {
                it.asIterable().increasing()
            }
        }
        .map { it.toSet() }

    for (primaryIndex in primaryIndexes) {
        val secondaryIndex = allIndexes - primaryIndex
        yield(Pair(primaryIndex, secondaryIndex))
    }
}

fun doubleSplit(list: List<Int>) =
    doubleSplitIndexes(list)
        .map { pair ->
            val firstPart = pair.first.map { list[it] }
            val secondPart = pair.second.map { list[it] }
            Pair(firstPart, secondPart)
        }

fun List<Int>.isValid(): Boolean {
    val doubleSplit = doubleSplit(this)
    return doubleSplit
        .filter { it.first.size > it.second.size }
        .all { pair ->
            val firstSum = pair.first.sum()
            val secondSum = pair.second.sum()
            firstSum > secondSum
        }
}
