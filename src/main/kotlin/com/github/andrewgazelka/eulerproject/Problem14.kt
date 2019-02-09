package com.github.andrewgazelka.eulerproject

import com.github.andrewgazelka.eulerproject.util.Problem

class Problem14(private val to: Long = 1_000_000) : Problem<Long> {

    private val map = HashMap<Long, Int>()

    override fun solve() = (to downTo 1L).maxBy {
        return@maxBy if (map.containsKey(it)) 0 else it.chainLength(map)
    } ?: throw IllegalArgumentException("cannot find max")

}

fun Long.chainLength(cache: HashMap<Long, Int> = HashMap(), length: Int = 1): Int {
    if (this == 1L) return length

    return cache.computeIfAbsent(this) {
        if (this % 2 == 0L) {
            (this / 2L).chainLength(cache)
        } else {
            (3L * this + 1).chainLength(cache)
        }
    } + length
}

