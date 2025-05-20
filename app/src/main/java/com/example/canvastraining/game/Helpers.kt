package com.example.canvastraining.game

import androidx.compose.runtime.MutableState

fun generateRandomFood(
    x: MutableState<Int>,
    y: MutableState<Int>,
    tail: MutableList<Pair<Int, Int>>,
    rows:Int): Pair<Int, Int>{

    var point = Pair((0..rows-1).random(), (0..rows-1).random())

    tail.forEach {
        if ( point == it || (point.first == x.value && point.second == y.value) ) {
            point = generateRandomFood(x, y, tail, rows)
        }
    }

    return point
}

