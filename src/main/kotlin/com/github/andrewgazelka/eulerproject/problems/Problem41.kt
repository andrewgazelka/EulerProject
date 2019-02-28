package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem
import kotlin.math.sqrt

class Problem41: Problem<Long> {

    private val nums = setOf(7,6,5,4,3,2,1)

    override fun solve(): Long {

        val largest = 1E7.toLong()
        val thePrime = (largest downTo 1L)
            .asSequence()
            .filter { it.isPermutation(nums) }
            .first { it.isPrime }

        println("The prime: $thePrime")
        return thePrime
    }


}

fun Long.isPermutation(mustContain: Set<Int>): Boolean {
    val toSet = this.toString()
        .map { it.toString().toInt() }
        .toSet()
    return toSet == mustContain
}

val Long.isPrime get(): Boolean {
    val sqrt = sqrt(this.toDouble())
    return (2L..sqrt.toLong())
        .none { this@isPrime % it == 0L }
}
