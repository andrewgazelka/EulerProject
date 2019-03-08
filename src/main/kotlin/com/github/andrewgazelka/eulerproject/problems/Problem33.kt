package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Fraction
import com.github.andrewgazelka.eulerproject.util.Problem
import com.github.andrewgazelka.eulerproject.util.fakeDivide

class Problem33 : Problem<Fraction> {
    override fun solve(): Fraction {

        return (10..99)
            .filterNot { it % 10 == 0 }
            .flatMap { denominator ->
                (10 until denominator)
                    .map { numerator ->
                        Fraction(numerator, denominator)
                    }
            }.mapNotNull {
                val fakeDivide = it.fakeDivide
                if (fakeDivide?.decimal == it.decimal) fakeDivide else null
            }
            .reduce { acc, fraction -> acc * fraction }
            .simplified
    }
}
