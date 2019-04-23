package com.github.andrewgazelka.eulerproject.problems

import com.github.andrewgazelka.eulerproject.util.isSpecialSubset
import java.nio.file.Files
import java.nio.file.Paths

fun solve() {
    val path = Paths.get("input","p105","sets.txt")
    val lines = Files.readAllLines(path)
    val lists = lines.map {
        it.split(",").map(String::toInt)
    }

    for (list in lists) {
        println("processing: $list")
        if(list.isSpecialSubset()){
            println("special")
            continue
        }
        println("not special")
    }
}
