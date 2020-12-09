package net.dstack.aoc.day9

/**
 * @author dstorey
 */
class Day9 {
    fun part1(nums: MutableList<Long>, preamble: Int): Long {
        for (i in nums.indices) {
            val target = nums[preamble + i]
            if (!sums(nums.subList(i, preamble + i), target)) return target
        }
        return -1
    }

    private fun sums(nums: List<Long>, target: Long): Boolean {
        val visited = mutableSetOf<Long>()
        for (num in nums) {
            val required = target - num
            if (visited.contains(required)) return true
            visited.add(num)
        }
        return false
    }

    fun part2(data: MutableList<Long>, target: Long): Long {
        for (i in data.indices) {
            val nums = mutableListOf<Long>()
            var sum = 0L
            for (j in i until data.size) {
                sum += data[j]
                if (sum > target) break

                nums.add(data[j])
                if (sum == target) {
                    nums.sort()
                    return nums.first() + nums.last()
                }
            }
        }
        return -1
    }
}