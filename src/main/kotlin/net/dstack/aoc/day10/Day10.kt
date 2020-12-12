package net.dstack.aoc.day10

import kotlin.math.min

/**
 * @author dstorey
 */
class Day10 {
    fun part1(adapters: List<Int>): Int {
        val sortedAdapters = adapters.sorted()
        val diffs = mutableMapOf<Int, Int>()
        for (i in 1 until sortedAdapters.size) {
            diffs.compute(sortedAdapters[i] - sortedAdapters[i - 1]) { _, count -> count?.inc() ?: 1 }
        }
        return diffs[1]!! * (diffs[3]!! + 1)
    }

    fun part2(adapters: List<Int>): Long {
        val sortedAdapters = adapters.sorted()
        val branches = mutableMapOf<Int, Long>()
        var branchCount = 1L
        for (i in sortedAdapters.indices.reversed()) {
            val adapter = sortedAdapters[i]
            branchCount += (i + 2..min(i + 3, sortedAdapters.size - 1))
                    .filter { sortedAdapters[it] - adapter <= 3 }
                    .map { branches[sortedAdapters[it]]!!.toLong() }
                    .sum()
            branches[adapter] = branchCount
        }
        return branchCount
    }
}