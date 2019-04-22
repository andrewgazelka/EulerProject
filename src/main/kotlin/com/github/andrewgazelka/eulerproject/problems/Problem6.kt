package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.incrementingSequence

object Problem6 {
    fun solve(maxNaturalNumber: Int = 100): Long {
        val numbers =
            incrementingSequence(1)
            .takeWhile { it <= maxNaturalNumber }
            .map { it.toLong() }

        val squareAndSum = numbers.map { it * it }.sum()

        val summed = numbers.sum()
        val sumAndSquare = summed*summed

        return sumAndSquare - squareAndSum
    }
}
