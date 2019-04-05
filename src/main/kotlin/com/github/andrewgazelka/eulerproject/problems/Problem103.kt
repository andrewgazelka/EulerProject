package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.*

object Problem103 {

    operator fun invoke(length: Int){
        solve(length)
            .format()
    }

    fun solve(length: Int) = generateSequence(emptyList<Int>()) { it.nextIter() }
            .first { it.size == length }

    fun List<Int>.nextIter() = generateSequence(1) { it + 1 }
        .map { this.baseFrom(it) }
        .first { it.isSpecialSubset() }

    fun List<Int>.format() = this.fold("") { acc, i ->
        "$acc$i"
    }
}
