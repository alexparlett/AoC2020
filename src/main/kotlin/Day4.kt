/**
 * Copyright (c) 2015-2020 Homonoia Studios.
 *
 * @author alexparlett
 * @since 04/12/2020
 */

fun hasRequiredKeys(passport: MutableMap<String, String>, requiredKeys: List<String>): Boolean {
    return passport.keys.containsAll(requiredKeys)
}

fun hasValidAttributes(passport: MutableMap<String, String>, requiredKeys: List<String>): Boolean {
    val allKeys = hasRequiredKeys(passport, requiredKeys)
    val valid = passport.all { (key, value) ->
        when (key) {
            "byr" -> yearInRange(value, 1920, 2002)
            "iyr" -> yearInRange(value, 2010, 2020)
            "eyr" -> yearInRange(value, 2020, 2030)
            "hgt" -> {
                val found = Regex("^([\\d]+)(in|cm)$").find(value)?.groupValues
                when (found?.get(2)) {
                    "in" -> found[1].toInt() in 59..76
                    "cm" -> found[1].toInt() in 150..193
                    else -> false
                }
            }
            "hcl" -> value.matches(Regex("^#([a-f0-9]{6})$"))
            "ecl" -> arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value)
            "pid" -> value.matches(Regex("^([0-9]{9})$"))
            "cid" -> true
            else -> false
        }
    }
    return valid && allKeys
}

fun yearInRange(value: String, min: Int, max: Int) =
    value.matches(Regex("^([0-9]{4})$")) && value.toInt() in min..max

fun lineToPairs(line: String): MutableMap<String, String> {
    return line.split(" ").associate {
        val (left, right) = it.split(":")
        left to right
    }.toMutableMap()
}

fun getPassports(input: String): List<MutableMap<String, String>> {
    val lines = input.lines()
    val passports = mutableListOf<MutableMap<String, String>>()

    for (line in lines) {
        when {
            line.isBlank() -> passports.add(mutableMapOf<String, String>())
            passports.isEmpty() -> passports.add(lineToPairs(line))
            else -> passports.last().putAll(lineToPairs(line))
        }
    }

    return passports
}

fun main(args: Array<String>) {
    val input = readText("src/main/resources/Day4.txt")

    val requiredKeys = listOf(
        "byr",
        "iyr",
        "eyr",
        "hgt",
        "hcl",
        "ecl",
        "pid"
    )

    val passports = getPassports(input)

    println(passports.size)

    println(passports.count { passport -> hasRequiredKeys(passport, requiredKeys) })

    println(passports.count { passport -> hasValidAttributes(passport, requiredKeys) })
}