package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.diphantineReciprocalsCount
import com.github.andrewgazelka.eulerproject.util.incrementingSequence
import java.lang.IllegalArgumentException

object Problem108 {

    data class Result(val n: Int, val results: Int)

    fun solve(threshold: Int = 1_000): Result {

        incrementingSequence()
            .forEach {
                val reciprocalsSize = diphantineReciprocalsCount(it.toLong())
                if (reciprocalsSize > threshold) return Result(it, reciprocalsSize)
            }
        throw IllegalArgumentException("somehow did not finish")
    }

}
