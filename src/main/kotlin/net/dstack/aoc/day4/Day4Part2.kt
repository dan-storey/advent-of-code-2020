package net.dstack.aoc.day4

class Day4Part2 {

    private val requiredFields = mapOf(
            Pair("byr", "19[2-9][0-9]|200[0-2]"),
            Pair("iyr", "201[0-9]|2020"),
            Pair("eyr", "202[0-9]|2030"),
            Pair("hgt", "((1[5-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)"),
            Pair("hcl", "#[0-9a-f]{6}"),
            Pair("ecl", "amb|blu|brn|gry|grn|hzl|oth"),
            Pair("pid", "[0-9]{9}"))

    fun countValidPassports(entries: List<String>): Int {
        var validCount = 0
        for (entry in entries) {
            val fields = entry.split(' ')
                    .map { it.split(':') }
                    .map { it[0] to it[1] }
                    .toMap()
            if (!fields.keys.containsAll(requiredFields.keys)) continue

            var validated = true
            for (required in requiredFields.entries) {
                if (!Regex(required.value).matches(fields[required.key]!!)) {
                    validated = false
                    break
                }
            }
            if (validated) validCount++
        }
        return validCount
    }
}