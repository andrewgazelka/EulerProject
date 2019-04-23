package com.github.andrewgazelka.eulerproject.util

import kotlin.system.measureTimeMillis

private object Defaults {
    const val times = 1
}

fun <T> Problem<T>.time(times: Int = Defaults.times): Double {
    return (1..times).map {
        measureTimeMillis {
            this.solve()
        }
    }.average()
}

fun <T> Problem<T>.printTime(times: Int = Defaults.times){
    println("time (ms): ${this.time(times)}")
}
