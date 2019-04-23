package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.Problem

class Problem17 : Problem<Double> {
    override fun solve(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

val numberTwoDigits by lazy {

}

fun main() {
    val oneToHundredSum = sequence {

        val from1To5 = (1..5).map { it.getLength() }.sum()
        yield(from1To5)

        val first6To9 = (6..9).map { it.getLength() }.sum()
        yield(2*first6To9) // used again in teen

        val first1To9 = from1To5 + first6To9

        val from10To15 = (1..15).map { it.getLength() }.sum()
        yield(from10To15)

        yield(4* teen) // 16 though 19

        yield(8 * first1To9) // 20 .. 100
        yield((twenty + thirty + fourty + fifty + sixty + seventy + eighty + ninety)*10)
    }.sum()

    val hunderdCount = 1000-100
    val result = oneToHundredSum*10 + (1..9).sum()*hunderdCount+hunderdCount* hunderd
    println(result)
}

fun Int.getLength(): Int {
    return when (this) {
        1 -> 3 // one
        2 -> 3 // two
        3 -> 5 // three
        4 -> 4 // four
        5 -> 4 // five
        6 -> 3 // six
        7 -> 5 // seven
        8 -> 5 // eight
        9 -> 5 // nine
        10 -> 3 // tem
        11 -> 6 // eleven
        12 -> 6 // twelve
        13 -> 8 // thirteen
        14 -> 8 // fourteen
        15 -> 7 // fifteen
        16 -> 7 // sixteen
        17 -> 7.getLength() + teen
        18 -> 8.getLength() + teen
        19 -> 9.getLength() + teen
        20 -> twenty
        21 -> 1.getLength() + twenty

        else -> throw IllegalArgumentException()
    }
}

val teen = 4
val twenty = 6
val thirty = 6
val fourty = 4.getLength() + 2
val fifty = 6
val sixty = 6.getLength() + 2
val seventy = 7.getLength() + 2
val eighty = 6
val ninety = 9.getLength() +2

val hunderd = 6
