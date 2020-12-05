package net.dstack.aoc.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day5Test {
    private val day5 = Day5()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day5/example.txt")
        assertEquals(820, day5.calculateHighestSeatId(lines))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day5/input.txt")
        assertEquals(974, day5.calculateHighestSeatId(lines))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day5/input.txt")
        assertEquals(646, day5.calculateMissingSeatId(lines))
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day5Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}