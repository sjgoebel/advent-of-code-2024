import java.math.BigInteger
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        for (s in input) {
            val regex = "mul[(](\\d+),(\\d+)[)]".toRegex()
            val matches = regex.findAll(s).map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }.toList().sum()
            //matches.println()
            total += matches
        }
        return total

    }

    fun part2(input: List<String>): Int {
        var total = 0
        //input.size.println()
        for (s in input) {
            val regexMul = "mul[(](\\d+),(\\d+)[)]".toRegex()
            val regexDontDo = "don't[(][)].*?do[(][)]".toRegex()
            val regexDont = "don't[(][)]".toRegex()
            val removeDont = s.split(regexDontDo).joinToString(separator = "") { it }
            val finalString = removeDont.split(regexDont)[0]
            //finalString.println()
            val matches = regexMul.findAll(finalString).map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }.toList().sum()
            total += matches
            //removeDont.split(regexDont).getOrNull(0)?.println() ?: 0
        }
        return total
    }

    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    part1(testInput).println()
    check(part1(testInput) == 161)


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()

    val test2Input = readInput("Day03_2_test")
    //part2(test2Input).println()
    check(part2(test2Input) == 48)
    part2(input).println()
}