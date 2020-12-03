package net.dstack.aoc.day2

class Day2Part1 {
    fun validatePasswords(input: List<String>): Int {
        var count = 0
        for (entry in input) {
            if (validatePassword(entry)) {
                count++
            }
        }
        return count
    }

    private fun validatePassword(input: String): Boolean {
        val (min, max, letter, password) = Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)").find(input)!!.destructured
        var count = 0
        for (c in password) {
            if (letter.single() == c) {
                if (++count > max.toInt()) return false
            }
        }
        return count >= min.toInt()
    }
}
