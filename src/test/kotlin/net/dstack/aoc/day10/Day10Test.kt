package net.dstack.aoc.day10

import net.dstack.aoc.day9.Day9Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day10Test {
    private val day10 = Day10()

    @Test
    fun testPart1Example1() {
        val lines = readFileLines("/day10/example1.txt")
        val entries = buildEntries(lines)
        assertEquals(35, day10.part1(listOf(0) + entries))
    }

    @Test
    fun testPart1Example2() {
        val lines = readFileLines("/day10/example2.txt")
        val entries = buildEntries(lines)
        assertEquals(220, day10.part1(listOf(0) + entries))
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day10/input.txt")
        val entries = buildEntries(lines)
        assertEquals(2312, day10.part1(listOf(0) + entries))
    }

    @Test
    fun testPart2Example1() {
        val lines = readFileLines("/day10/example1.txt")
        val entries = buildEntries(lines)
        assertEquals(8, day10.part2(listOf(0) + entries))
    }

    @Test
    fun testPart2Example2() {
        val lines = readFileLines("/day10/example2.txt")
        val entries = buildEntries(lines)
        assertEquals(19208, day10.part2(listOf(0) + entries))
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day10/input.txt")
        val entries = buildEntries(lines)
        assertEquals(12089663946752, day10.part2(listOf(0) + entries))
    }

    private fun buildEntries(input: List<String>): MutableList<Int> {
        val entries = mutableListOf<Int>()
        for (line in input) {
            entries.add(line.trim().toInt())
        }
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day9Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}