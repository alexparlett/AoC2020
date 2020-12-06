import java.lang.Exception

/**
 * Copyright (c) 2015-2020 Homonoia Studios.
 *
 * @author alexparlett
 * @since 06/12/2020
 */

fun findRow(input: String): Int {
    return input.toCharArray()
        .scan(0..127, { range: IntRange, c: Char ->
            when(c) {
                'F' -> range.first until range.last - ((range.last - range.first) / 2)
                'B' -> (range.first + ((range.last - range.first) / 2) + 1)..range.last
                else -> throw Exception("Bad Input")
            }
        })
        .last()
        .first
}

fun findColumn(input: String): Int {
    return input.toCharArray()
        .scan(0..7, { range: IntRange, c: Char ->
            when(c) {
                'L' -> range.first until range.last - ((range.last - range.first) / 2)
                'R' -> (range.first + ((range.last - range.first) / 2) + 1)..range.last
                else -> throw Exception("Bad Input")
            }
        })
        .last()
        .first

}

fun findSeat(row: Int, column: Int): Int {
    return (row * 8) + column
}

fun splitParts(input: String): List<String> {
    return Regex("^(\\w{7})(\\w{3})$").find(input)!!.groupValues.drop(1)
}

fun findMySeat(seatNumbers: List<Int>): Int? {
    return seatNumbers.reduceIndexedOrNull { index, acc, i ->
        when {
            index == 0 -> acc
            index == seatNumbers.size -> acc
            seatNumbers[index - 1] != (i - 1) -> i - 1
            else -> acc
        }
    }
}


fun main(args: Array<String>) {
    val input = readLines("src/main/resources/Day5.txt")

    val seatNumbers = input.map { line ->
        val (rowInstructions, columnInstructions) = splitParts(line)
        val row = findRow(rowInstructions)
        val column = findColumn(columnInstructions)
        findSeat(row, column)
    }.sorted()

    println(seatNumbers.maxOrNull())
    println(findMySeat(seatNumbers))
}