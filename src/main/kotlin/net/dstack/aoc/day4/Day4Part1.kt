package net.dstack.aoc.day4

class Day4Part1 {

    private val requiredFields = setOf("byr","iyr","eyr","hgt","hcl","ecl","pid")

    fun countValidPassports(entries: List<String>): Int {
        var validCount = 0
        for (entry in entries) {
            val fields = entry.split(' ')
                    .map { it.split(':') }
                    .map { it[0] to it[1] }
                    .toMap()
            if (fields.keys.containsAll(requiredFields)) validCount++
        }
        return validCount
    }
}