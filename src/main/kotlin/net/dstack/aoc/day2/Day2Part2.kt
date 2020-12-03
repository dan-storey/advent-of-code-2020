package net.dstack.aoc.day2

class Day2Part2 {
    fun validatePasswords(input: List<String>): Int {
        var count = 0
        for (entry in input) {
            if (validatePassword(entry)) {
                count++;
            }
        }
        return count
    }

    private fun validatePassword(input: String): Boolean {
        val (idx1, idx2, letter, password) = Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)").find(input)!!.destructured

        return (password[idx1.toInt() - 1] == letter.single()) != (password[idx2.toInt() - 1] == letter.single())
    }
}
