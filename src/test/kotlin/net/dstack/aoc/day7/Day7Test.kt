package net.dstack.aoc.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day7Test {
    private val day7 = Day7()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day7/example.txt")
        val entries = buildEntries(lines)
        assertEquals(4, day7.countBagsContainingShinyGold(entries))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day7/input.txt")
        val entries = buildEntries(lines)
        assertEquals(370, day7.countBagsContainingShinyGold(entries))
    }

    @Test
    fun testPart2Example() {
        val lines = readFileLines("/day7/example2.txt")
        val entries = buildEntries(lines)
        assertEquals(126, day7.countBagsInsideShinyGold(entries))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day7/input.txt")
        val entries = buildEntries(lines)
        assertEquals(29547, day7.countBagsInsideShinyGold(entries))
    }

    private fun buildEntries(input: List<String>): Map<String, List<String>> {
        val entries = mutableMapOf<String, MutableList<String>>()
        val bagNameRegex = Regex("^([a-z ]+?) bags")
        val bagContentsRegex = Regex("(?: (\\d) ([a-z ]+?) bags?,?\\.?)+?")

        for (line in input) {
            val parentBag = bagNameRegex.find(line)!!.groupValues[1].replace(' ', '_')
            entries.putIfAbsent(parentBag, mutableListOf())
            for (match in bagContentsRegex.findAll(line)) {
                val (number, childBag) = match.destructured
                repeat(number.toInt()) {
                    entries[parentBag]!!.add(childBag.replace(' ', '_'))
                }
            }
        }
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day7Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}