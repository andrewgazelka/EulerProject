package com.github.andrewgazelka.eulerproject.problems

import java.nio.file.Files
import java.nio.file.Paths

sealed class Card {
    object Disregard : Card()
    data class GoTo(val index: Int?) : Card()
}

// two 6-sided
//val basicImpl = fun(board: Map<String, Int>) {
//    val communityChest = (1..16).shuffled().map {
//
//
//
//        when (it) {
//            1 -> Card.GoTo(board["GO"])
//            2 -> Card.GoTo(board["JAIL"])
//            else -> Card.Disregard
//        }
//    }
//}
//
//
//private fun chanceTo(position: Int){
//    val chance = (1..16).shuffled().map {
//        when (it) {
//            1 -> Card.GoTo(board["GO"])
//            2 -> Card.GoTo(board["JAIL"])
//            3 -> Card.GoTo(board["C1"])
//            4 -> Card.GoTo(board["E3"])
//            5 -> Card.GoTo(board["H2"])
//            6 -> Card.GoTo(board["R1"])
//            7->
//        }
//    }
//}

fun defaultBoard(): Map<String, Int> {
    val file = Paths.get("input", "p84", "board.txt")
    val map = HashMap<String, Int>()
    Files.readAllLines(file).forEachIndexed { index, s ->
        map[s] = index
    }
    return map
}
