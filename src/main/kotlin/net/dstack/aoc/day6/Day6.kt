package net.dstack.aoc.day6

class Day6 {

    fun countYesPart1(answers: List<String>): Int {
        return answers.map { it.replace(" ", "").toCharArray().distinct().size }.sum()
    }

    fun countYesPart2(answers: List<String>): Int {
        var yesCount = 0
        for (answer in answers) {
            for (question in 'a'..'z') {
                val groupAnswers = answer.split(' ')
                if (groupAnswers.filter { it.contains(question) }.size == groupAnswers.size) yesCount++
            }
        }
        return yesCount
    }
}