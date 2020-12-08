package net.dstack.aoc.day8

/**
 * @author dstorey
 */
class Day8 {
    private val instructions = mutableListOf<Pair<String, Int>>()
    private val history = mutableSetOf<Int>()
    var accumulator = 0
        private set

    fun load(newInstructions: MutableList<Pair<String, Int>>, reset: Boolean = true) {
        if (reset) {
            instructions.clear()
            history.clear()
            accumulator = 0
        }
        instructions.addAll(newInstructions)
    }

    fun run(startIdx: Int): Boolean {
        var next = startIdx
        while (next < instructions.size && !history.contains(next)) {
            next = runInstruction(next)
        }
        return next >= instructions.size
    }

    private fun runInstruction(index: Int): Int {
        val instruction = instructions[index]
        val next = when (instruction.first) {
            "nop" -> index + 1
            "acc" -> {
                accumulator += instruction.second
                index + 1
            }
            "jmp" -> index + instruction.second
            else -> throw IllegalArgumentException("Unsupported instruction: ${instruction.first}")
        }
        history.add(index)
        return next
    }
}