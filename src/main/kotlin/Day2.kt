fun validateSledPassword(passwordWithValidation: String) : Boolean {
    val (range, target, password) = passwordWithValidation.split(' ')
    val (min,max) = range.split('-').map { int -> int.toInt() }
    val pattern = target.first()

    val occurrences = password.groupingBy { char -> char }.eachCount()

    if (!occurrences.containsKey(pattern)) {
        return false
    }

    return occurrences[pattern]!! in min..max
}

fun validateTobogganPassword(passwordWithValidation: String) : Boolean {
    val (range, target, password) = passwordWithValidation.split(' ')
    val (pos1,pos2) = range.split('-').map { int -> int.toInt() }
    val pattern = target.first()

    return (password[pos1 - 1] == pattern && password[pos2 - 1] != pattern) ||
            password[pos1 - 1] != pattern && password[pos2 - 1] == pattern
}

fun main(args: Array<String>) {
    val lines = readLines("src/main/resources/Day2.txt")

    println(lines.filter { line -> validateSledPassword(line) }.count())
    println(lines.filter { line -> validateTobogganPassword(line) }.count())
}