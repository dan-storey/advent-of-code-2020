package net.dstack.aoc.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Part1Test {
    private val day4Part1 = Day4Part1()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day4/example.txt")
        val entries = buildPassportEntries(lines)
        assertEquals(2, day4Part1.countValidPassports(entries))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day4/input.txt")
        val entries = buildPassportEntries(lines)
        assertEquals(204, day4Part1.countValidPassports(entries))
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
        entries.add(currentEntry)
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day4Part1Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}