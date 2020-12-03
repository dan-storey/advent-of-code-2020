package net.dstack.aoc.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/**
 * @author dstorey
 */
internal class Day1Test {
    private val day1 = Day1()

    @Test
    @Throws(IOException::class)
    fun shouldCalculateProductOfTwo2020() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val result = day1.productTwo2020(expenseReport)
        assertEquals(982464, result)
    }

    @Test
    @Throws(IOException::class)
    fun shouldCalculateProductOfTwo2020Recursive() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val result = day1.productN2020(expenseReport, 2)
        assertEquals(982464, result)
    }

    @Test
    @Throws(IOException::class)
    fun shouldCalculateProductOfThree2020() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val result = day1.productThree2020(expenseReport)
        assertEquals(162292410, result)
    }

    @Test
    @Throws(IOException::class)
    fun shouldCalculateProductOfThree2020Recursive() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val result = day1.productN2020(expenseReport, 3)
        assertEquals(162292410, result)
    }

    @Test
    @Throws(IOException::class)
    fun shouldTestPerformanceProductOfThree2020() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val iterations = 10
        var elapsed: Long = 0
        repeat(iterations) {
            val result = timed { day1.productThree2020(expenseReport) }
            assertEquals(162292410, result.first)
            elapsed += result.second
        }

        println("shouldTestPerformanceProductOfThree2020 " + (elapsed / iterations) + " ms")
    }

    @Test
    @Throws(IOException::class)
    fun shouldTestPerformanceProductOfThree2020Recursive() {
        val expenseReport = readExpenseReport("/day1/input.txt")
        val iterations = 10
        var elapsed: Long = 0
        repeat(iterations) {
            val result = timed { day1.productN2020(expenseReport, 3) }
            assertEquals(162292410, result.first)
            elapsed += result.second
        }

        println("shouldTestPerformanceProductOfThree2020Recursive " + (elapsed / iterations) + " ms")
    }

    @Throws(IOException::class)
    private fun readExpenseReport(name: String): IntArray {
        val inputStream = javaClass.getResourceAsStream(name)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val expenseReport: MutableList<Int> = ArrayList()
        while (reader.ready()) {
            expenseReport.add(reader.readLine().toInt())
        }
        return expenseReport.toIntArray()
    }

    private fun <T> timed(f: () -> T): Pair<T, Long> {
        val start = System.currentTimeMillis()
        val result = f.invoke()
        return Pair(result, System.currentTimeMillis() - start)
    }
}
