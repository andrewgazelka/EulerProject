package eulerproject

import kotlin.system.measureTimeMillis

val set = HashSet<Long>()

fun main() {
    measureTimeMillis {
        (1_000_000L downTo 1L).maxBy {
            if(set.contains(it)) return@maxBy 0
            else return@maxBy it.chainLength()
        }.also { println(it) }
    }.also { println("millis: $it") }
}

tailrec fun Long.chainLength(length: Int = 0): Int {
//    println(this)
    set.add(this)
    if(this == 1L) return length
    if(this % 2L == 0L) return (this/2L).chainLength(length+1)
    return (3L*this+1).chainLength(length+1)
}
