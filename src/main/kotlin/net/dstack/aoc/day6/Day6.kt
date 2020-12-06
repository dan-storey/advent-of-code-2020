package net.dstack.aoc.day6

class Day6 {

    fun countYesPart1(answers: List<String>): Int {
        return answers.map { it.replace(" ", "").toCharArray().distinct().size }.sum()
    }

    fun countYesPart2(answers: List<String>): Int {
        var count = 0
        for (groupAnswers in answers) {
            val questions = groupAnswers.replace(" ", "").toCharArray().distinct()
            count += questions.filter { question -> groupAnswers.split(' ').all { it.contains(question) } }.size
        }
        return count
    }
}