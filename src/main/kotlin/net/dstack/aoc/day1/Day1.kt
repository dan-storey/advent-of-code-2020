package net.dstack.aoc.day1

import kotlin.collections.ArrayList

/**
 * @author dstorey
 */
class Day1 {
    fun productTwo2020(expenseReport: IntArray): Int {
        for (expense in expenseReport) {
            val required = 2020 - expense
            if (expenseReport.contains(required)) {
                return expense * required
            }
        }
        return -1
    }

    fun productThree2020(expenseReport: IntArray): Int {
        expenseReport.sort()
        for (iFirst in expenseReport.indices) {
            val first = expenseReport[iFirst]
            for (iSecond in expenseReport.indices) {
                if (iSecond == iFirst) continue
                val second = expenseReport[iSecond]
                if (second > 2020 - first) break
                for (iThird in expenseReport.indices) {
                    if (iThird == iFirst || iThird == iSecond) continue
                    val third = expenseReport[iThird]
                    if (third > 2020 - first - second) break
                    if (2020 == first + second + third) {
                        return first * second * third
                    }
                }
            }
        }
        return -1
    }

    fun productN2020(expenseReport: IntArray, nums: Int): Int {
        expenseReport.sort()
        return productN2020(expenseReport, nums, ArrayList())
    }

    private fun productN2020(expenseReport: IntArray, nums: Int, indices: List<Int>): Int {
        if (indices.size < nums) {
            for (i in expenseReport.indices) {
                if (i in indices) continue
                val result = productN2020(expenseReport, nums, indices + i)
                if (result != -1) return result
            }
        }
        val sum = indices.sumBy { expenseReport[it] }
        if (indices.size == nums && 2020 == sum) {
            return indices.fold(1) { acc, i -> acc * expenseReport[i] }
        } else if (sum > 2020) {
            return -1
        }
        return -1
    }
}