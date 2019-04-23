package com.github.andrewgazelka.eulerproject.problem002

import com.github.andrewgazelka.eulerproject.utils.fib
import com.github.andrewgazelka.eulerproject.utils.isEven

const val DEFAULT_TO = 4_000_000L

fun solve(to: Long) = fib()
    .filter { it.isEven }
    .takeWhile { it <= to }
    .sum()
