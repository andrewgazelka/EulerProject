package com.github.andrewgazelka.eulerproject.utils

data class Fraction(val numerator: Int, val denominator: Int) {

    operator fun times(other: Fraction) = Fraction(other.numerator*numerator, other.denominator * denominator)

    val decimal by lazy { numerator.toDouble() / denominator }
    val simplified by lazy {
        val top = numerator.primeFactors().toMutableList()

        val bottom = denominator.primeFactors().toMutableList()

        val iterator = bottom.iterator()
        while (iterator.hasNext()){
            val element = iterator.next()
            if(top.remove(element)){
                iterator.remove()
            }
        }
        Fraction(top.product(),bottom.product())
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}
