package net.dstack.aoc.day6

class Day6 {

    fun countYesPart1(answers: List<String>): Int {
        return answers.map { it.replace(" ", "").toCharArray().distinct().size }.sum()
    }

    fun countYesPart2(answers: List<String>): Int {
        return answers.map { it.split(' ') }
                .map { group -> ('a'..'z').filter { question -> group.all { it.contains(question) } }.size }
                .sum()
    }
}