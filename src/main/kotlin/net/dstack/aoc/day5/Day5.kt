package net.dstack.aoc.day5

import kotlin.math.pow

class Day5 {

    fun calculateHighestSeatId(passes: List<String>): Int {
        return calculateSeatIds(passes).last()
    }

    fun calculateMissingSeatId(passes: List<String>): Int {
        val seatIds = calculateSeatIds(passes)
        for (idx in seatIds.indices) {
            if (seatIds[idx + 1] - seatIds[idx] > 1) {
                return seatIds[idx] + 1
            }
        }
        return -1
    }

    private fun calculateSeatIds(passes: List<String>): List<Int> {
        val seatIds = mutableListOf<Int>()
        for (pass in passes) {
            val row = decode(pass.substring(0, 7), 'B')
            val seat = decode(pass.substring(7, 10), 'R')
            seatIds.add(row * 8 + seat)
        }
        seatIds.sort()
        return seatIds
    }

    private fun decode(input: String, hi: Char): Int {
        var min = 0
        var range = (2.0).pow(input.length).toInt()
        for (c in input) {
            range /= 2
            if (hi == c) min += range
        }
        return min
    }
}