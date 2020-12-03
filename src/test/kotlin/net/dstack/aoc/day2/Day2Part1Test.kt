package net.dstack.aoc.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2Part1Test {
    private val part1 = Day2Part1()

    @Test
    fun shouldValidatePasswordExample() {
        val valid = part1.validatePasswords(readFileLines("/day2/example.txt"))
        assertEquals(2, valid)
    }

    @Test
    fun shouldValidatePasswordInput() {
        val valid = part1.validatePasswords(readFileLines("/day2/input.txt"))
        assertEquals(569, valid)
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day2Part1Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}