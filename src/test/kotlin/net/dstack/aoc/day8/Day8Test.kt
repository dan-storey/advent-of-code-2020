package net.dstack.aoc.day8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author dstorey
 */
internal class Day8Test {
    private val day8 = Day8()

    @Test
    fun testPart1Example() {
        val lines = readFileLines("/day8/example.txt")
        val entries = buildEntries(lines)
        day8.load(entries)
        day8.run(0)
        assertEquals(5, day8.accumulator)
    }

    @Test
    fun testPart1Input() {
        val lines = readFileLines("/day8/input.txt")
        val entries = buildEntries(lines)
        day8.load(entries)
        day8.run(0)
        assertEquals(2025, day8.accumulator)
    }

    @Test
    fun testPart2Example() {
        val lines = readFileLines("/day8/example.txt")
        val entries = buildEntries(lines)
        bruteForcePart2(entries)
        assertEquals(8, day8.accumulator)
    }

    @Test
    fun testPart2Input() {
        val lines = readFileLines("/day8/input.txt")
        val entries = buildEntries(lines)
        bruteForcePart2(entries)
        assertEquals(2001, day8.accumulator)
    }

    private fun bruteForcePart2(originalInstructions: MutableList<Pair<String, Int>>) {
        val modifiedInstructions = originalInstructions.withIndex()
                .filter { "nop" == it.value.first || "jmp" == it.value.first }
                .map {
                    Pair(it.index, if ("nop" == it.value.first) Pair("jmp", it.value.second) else Pair("nop", it.value.second))
                }
                .toMutableList()
        var success = false
        while (!success) {
            val instructions = originalInstructions.toMutableList()
            val modifiedInstruction = modifiedInstructions.removeFirst()
            instructions[modifiedInstruction.first] = modifiedInstruction.second
            day8.load(instructions)
            success = day8.run(0)
        }
    }

    private fun buildEntries(input: List<String>): MutableList<Pair<String, Int>> {
        val entries = mutableListOf<Pair<String, Int>>()
        for (line in input) {
            val split = line.split(" ")
            entries.add(Pair(split[0], split[1].toInt()))
        }
        return entries
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day8Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}