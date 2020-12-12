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
        for (i in sortedAdapters.indices.reversed()) {
            branches[i] = (i + 2..min(i + 3, sortedAdapters.size - 1))
                    .filter { sortedAdapters[it] - sortedAdapters[i] <= 3 }
                    .map { branches[it]!! }
                    .sum()
                    .plus(branches.getOrDefault(i + 1, 1L))
        }
        return branches[0]!!
    }
}