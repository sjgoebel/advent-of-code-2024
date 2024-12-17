import java.math.BigInteger
import kotlin.math.abs

fun main() {
    fun isSafe(nums: MutableList<Int>): Boolean {
        val increasing = nums[nums.size - 1] - nums[0] > 0
        var valid = true
        for (num in 0 until nums.size - 1) {
            if (increasing && (nums[num + 1] <= nums[num] || nums[num + 1] - nums[num] > 3)) {
                valid = false
            }
            if (!increasing && (nums[num + 1] >= nums[num] || nums[num] - nums[num + 1] > 3)) {
                valid = false
            }
        }
        return valid
    }

    fun part1(input: List<String>): Int {
        var numValid = 0
        for (s in input) {
            val regex = "\\s+".toRegex()
            var nums = s.split(regex).map(String::toInt)
            val increasing = nums[nums.size - 1] - nums[0] > 0
            var valid = true
            for (num in 0 until nums.size - 1) {
                if (increasing && (nums[num + 1] <= nums[num] || nums[num + 1] - nums[num] > 3)) {
                    valid = false
                }
                if (!increasing && (nums[num + 1] >= nums[num] || nums[num] - nums[num + 1] > 3)) {
                    valid = false
                }
            }
            if (valid) {
                numValid++
            }


        }



        return numValid
    }

    fun part2(input: List<String>): Int {
        var numValid = 0
        for (s in input) {
            val regex = "\\s+".toRegex()
            var nums = s.split(regex).map(String::toInt).toMutableList()


            if (isSafe(nums)) {
                numValid++
            } else {
                for (i in 0..nums.size - 1) {
                    if (isSafe((nums.take(i) + nums.takeLast(nums.size - 1 - i)).toMutableList())) {
                        numValid++
                        break
                    }
                }
            }

        }

        return numValid
    }



    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    part1(testInput).println()
    check(part1(testInput) == 2)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()

    val test2Input = readInput("Day02_test")
    part2(test2Input).println()
    check(part2(test2Input) == 4)
    part2(input).println()
}
