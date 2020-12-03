package net.dstack.aoc.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day3Test {

    private val day3 = Day3()

    @Test
    fun testPart1() {
        val map = createMap(readFileLines("/day3/input.txt"))
        assertEquals(286, day3.countTrees(map, Pair(3, 1)))
    }

    @Test
    fun testPart2() {
        val map = createMap(readFileLines("/day3/input.txt"))
        val s1 = day3.countTrees(map, Pair(1, 1))
        val s2 = day3.countTrees(map, Pair(3, 1))
        val s3 = day3.countTrees(map, Pair(5, 1))
        val s4 = day3.countTrees(map, Pair(7, 1))
        val s5 = day3.countTrees(map, Pair(1, 2))

        println((s1.toLong() * s2 * s3 * s4 * s5))
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day3Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }

    private fun createMap(input: List<String>): Array<CharArray> {
        return Array(input.size) { input[it].trim().toCharArray() }
    }
}