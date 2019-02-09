package com.github.andrewgazelka.eulerproject

import com.github.andrewgazelka.eulerproject.util.Problem
import com.github.andrewgazelka.eulerproject.util.gauss
import com.github.andrewgazelka.eulerproject.util.largestMultiple

class Problem1(private val to: Int = 1000, val multiple1: Int = 3, val multiple2: Int = 5) {

    val methods by lazy { listOf(Efficient(), BruteForce()) }

    inner class Efficient : Problem<Int> {
        override fun solve(): Int {
            return multiplesSum(multiple1) + multiplesSum(multiple2) - multiplesSum(multiple1 * multiple2)
        }

        private fun multiplesSum(num: Int) = if (num >= to) 0 else {
            val oneLower = to - 1
            gauss(num, oneLower.largestMultiple(num), (oneLower) / num)
        }
    }

    inner class BruteForce : Problem<Int> {
        override fun solve(): Int {
            return (1 until to)
                .filter { it % multiple1 == 0 || it % multiple2 == 0 }
                .sum()
        }
    }

}
