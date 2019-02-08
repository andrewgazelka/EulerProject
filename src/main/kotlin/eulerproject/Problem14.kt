package eulerproject

import kotlin.system.measureTimeMillis

val map = HashMap<Long, Int>()

val to = 1_000_000L


fun test1() {
    measureTimeMillis {
        (to downTo 1L).maxBy {
            if (map.containsKey(it)) {
                return@maxBy 0
            } else return@maxBy it.chainLength()
        }.also { println("max: $it") }
    }.also {
        println("millis: $it")
        println(map)
    }
}

fun main() {
    test1()
}

fun Long.chainLength(length: Int = 1): Int {
    if (this == 1L) {
        return length
    }

    val mapVal = map[this]

    if (this % 2L == 0L) {
        return if (mapVal == null) {
            val res = (this / 2L).chainLength()
            map[this] = res
            res + length
        } else {
            mapVal + length
        }
    }
    return if (mapVal == null) {
        val res = (3L * this + 1).chainLength()
        map[this] = res
        res + length
    } else {
        mapVal + length
    }
}
