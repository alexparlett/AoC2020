fun twoSum(nums: List<Int>, target: Int): Pair<Int,Int> {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return Pair(nums[i], nums[j])
            }
        }
    }

    throw IllegalArgumentException("No twoSum solution")
}


fun threeSum(nums: List<Int>, target: Int): Triple<Int,Int,Int>? {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return Triple(nums[i], nums[j], nums[k])
                }
            }
        }
    }

    throw IllegalArgumentException("No threeSum solution")
}


fun part1(lines: List<Int>, target: Int): Int? {
    var found = twoSum(lines, target)

    if (found != null) {
        return found.first * found.second
    }

    return null
}

fun part2(lines: List<Int>, target: Int): Int? {
    var found = threeSum(lines, target)

    if (found != null) {
        return found.first * found.second * found.third
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