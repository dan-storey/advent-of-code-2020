package net.dstack.aoc.day9

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author dstorey
 */
internal class Day9Test {
    private val day9 = Day9()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day9/example.txt")
        val entries = buildEntries(lines)
        assertEquals(127, day9.part1(entries, 5))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day9/input.txt")
        val entries = buildEntries(lines)
        assertEquals(217430975, day9.part1(entries, 25))
    }

    @Test
    fun testPart2Example() {
        val lines = readFileLines("/day9/example.txt")
        val entries = buildEntries(lines)
        assertEquals(62, day9.part2(entries, 127))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day9/input.txt")
        val entries = buildEntries(lines)
        assertEquals(28509180, day9.part2(entries, 217430975))
    }

    private fun buildEntries(input: List<String>): MutableList<Long> {
        val entries = mutableListOf<Long>()
        for (line in input) {
            entries.add(line.toLong())
        }
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day9Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}