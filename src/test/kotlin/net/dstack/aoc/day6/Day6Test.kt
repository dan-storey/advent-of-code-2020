package net.dstack.aoc.day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day6Test {
    private val day6 = Day6()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day6/example.txt")
        val entries = buildEntries(lines)
        Assertions.assertEquals(11, day6.countYesPart1(entries))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day6/input.txt")
        val entries = buildEntries(lines)
        Assertions.assertEquals(6930, day6.countYesPart1(entries))
    }

    @Test
    fun testPart2Example() {
        val lines = readFileLines("/day6/example.txt")
        val entries = buildEntries(lines)
        Assertions.assertEquals(6, day6.countYesPart2(entries))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day6/input.txt")
        val entries = buildEntries(lines)
        Assertions.assertEquals(3585, day6.countYesPart2(entries))
    }

    private fun buildEntries(input: List<String>): List<String> {
        val entries = mutableListOf<String>()
        var currentEntry = ""
        for (line in input) {
            if (line.isBlank()) {
                entries.add(currentEntry.trim())
                currentEntry = ""
            } else {
                currentEntry += line.replace('\r', ' ')
            }
        }
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day6Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}