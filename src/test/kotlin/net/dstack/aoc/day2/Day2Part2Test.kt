package net.dstack.aoc.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Part2Test {
    private val part2 = Day2Part2()

    @Test
    fun shouldValidatePasswordExample() {
        val valid = part2.validatePasswords(readFileLines("/day2/example.txt"))
        assertEquals(1, valid)
    }

    @Test
    fun shouldValidatePasswordInput() {
        val valid = part2.validatePasswords(readFileLines("/day2/input.txt"))
        assertEquals(346, valid)
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day2Part2Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }
}