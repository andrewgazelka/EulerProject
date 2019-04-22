package com.github.andrewgazelka.eulerproject.problems

object Problem103 {

    operator fun invoke(length: Int){
        solve(length)
            .format()
    }

    fun solve(length: Int) = generateSequence(listOf(1)) { it.nextIter() }
            .first { it.size == length }

    fun List<Int>.nextIter(): List<Int> {
        val head = this[size / 2]
        val tail = this.map { it + head }
        return listOf(head) + tail
    }


    fun List<Int>.format() = this.fold("") { acc, i ->
        "$acc$i"
    }
}
