package net.dstack.aoc.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Part2Test {
    private val day4Part2 = Day4Part2()

    @Test
    fun testPart2Example() {
        val lines = readFileLines("/day4/example.txt")
        val entries = buildPassportEntries(lines)
        assertEquals(2, day4Part2.countValidPassports(entries))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day4/input.txt")
        val entries = buildPassportEntries(lines)
        assertEquals(179, day4Part2.countValidPassports(entries))
    }

    private fun buildPassportEntries(input: List<String>): List<String> {
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
        val fileContent = Day4Part2Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}