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

    @Test
    fun testPart2Performance() {
        val lines = readFileLines("/day5/input.txt")
        val iterations = 1000
        var elapsed: Long = 0
        repeat(iterations) {
            val result = timed { day5.calculateMissingSeatId(lines) }
            assertEquals(646, result.first)
            elapsed += result.second
        }

        println("testPart2Performance " + (elapsed / iterations) + " ns")
    }

    private fun readFileLines(filename: String): List<String> {
        val fileContent = Day5Test::class.java.getResource(filename).readText()
        return fileContent.split("\n")
    }

    private fun <T> timed(f: () -> T): Pair<T, Long> {
        val start = System.nanoTime()
        val result = f.invoke()
        return Pair(result, System.nanoTime() - start)
    }
}