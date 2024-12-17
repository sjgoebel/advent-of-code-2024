import java.math.BigInteger
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        for (s in input) {
            val regex = "mul[(](\\d+),(\\d+)[)]".toRegex()
            val matches = regex.findAll(s).map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }.toList().sum()
            //matches.println()
        }
        return matches
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    part1(testInput).println()
    check(part1(testInput) == 2)
    part2(testInput).println()
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}