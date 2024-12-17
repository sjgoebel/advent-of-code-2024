import java.math.BigInteger
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = ArrayList<Int>()
        val list2 = ArrayList<Int>()
        for (s in input) {
            val regex = "\\s+".toRegex()
            val nums = s.split(regex)
            list1.add(nums[0].toInt())
            list2.add(nums[1].toInt())
        }
        list1.sort()
        list2.sort()
        var sumDiff = 0
        for (i in 0 until list1.size) {
            sumDiff += abs(list1[i] - list2[i])
        }

        return sumDiff
    }

    fun part2(input: List<String>): Int {
        val map = HashMap<Int, Int>()

        val list1 = ArrayList<Int>()
        val list2 = ArrayList<Int>()
        for (s in input) {
            val regex = "\\s+".toRegex()
            val nums = s.split(regex)
            list1.add(nums[0].toInt())
            list2.add(nums[1].toInt())
        }
        for (num in list1) {
            map.put(num, 0)
        }
        for (num in list2) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }


        var similarity = 0
        for (i in list1) {
            similarity += i * map.get(i)!!
        }
        return similarity
    }

    // Test if implementation meets criteria from the description, like:
   // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    part1(testInput).println()
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()

    val test2Input = readInput("Day01_test")
    part2(test2Input).println()
    check(part2(test2Input) == 31)
    part2(input).println()
}
