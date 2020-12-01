fun twoSum(nums: List<Int>, target: Int): IntArray {
    var found = nums.find { num -> nums.contains(target - num) }
    if (found != null)
        return intArrayOf(found, target - found)
    throw IllegalArgumentException("No twoSum solution")
}

fun threeSum(nums: List<Int>, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return intArrayOf(nums[i], nums[j], nums[k])
                }
            }
        }
    }
    throw IllegalArgumentException("No threeSum solution")
}


fun part1(lines: List<Int>, target: Int): Int? {
    var found = twoSum(lines, target)

    if (found != null) {
        return found.reduce { a,b -> a * b}
    }

    return null
}

fun part2(lines: List<Int>, target: Int): Int? {
    var found = threeSum(lines, target)

    if (found != null) {
        return found.reduce { a,b -> a * b}
    }

    return null
}

fun main(args: Array<String>) {
    var lines = readLines("src/main/resources/Day1.txt")
        .map { line -> line.toInt() }

    var part1Result = part1(lines, 2020)
    println(part1Result)

    var part2Result = part2(lines, 2020)
    println(part2Result)
}