package net.dstack.aoc.day7

import java.util.concurrent.atomic.AtomicInteger

class Day7 {

    /**
     * Part 1
     */
    fun countBagsContainingShinyGold(input: Map<String, List<String>>): Int {
        return input.keys.filter { containsShinyGold(input, it, it) }.size
    }

    private fun containsShinyGold(input: Map<String, List<String>>, parentBag: String, bag: String): Boolean {
        val containedBags = input[bag]!!.toSet()
        if (containedBags.contains("shiny_gold")) return true
        return containedBags.any { containsShinyGold(input, parentBag, it) }
    }

    /**
     * Part 2
     */
    fun countBagsInsideShinyGold(input: Map<String, List<String>>): Int {
        val count = AtomicInteger()
        countContainedBags(input, "shiny_gold", count)
        return count.get()
    }

    private fun countContainedBags(input: Map<String, List<String>>, key: String, count: AtomicInteger) {
        input[key]!!.forEach { countContainedBags(input, it, count.apply { incrementAndGet() }) }
    }
}
