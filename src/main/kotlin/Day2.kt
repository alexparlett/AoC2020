fun validateSledPassword(passwordWithValidation: String) : Boolean {
    val parts = passwordWithValidation.split(' ')
    val range = parts[0].split('-').map { int -> int.toInt() }
    val pattern = parts[1].first()
    val password = parts[2]

    val occurances = password.groupingBy { char -> char }.eachCount()

    if (!occurances.containsKey(pattern)) {
        return false
    }

    return occurances[pattern]!! >= range[0] && occurances[pattern]!! <= range[1]
}

fun validateTobogganPassword(passwordWithValidation: String) : Boolean {
    val parts = passwordWithValidation.split(' ')
    val range = parts[0].split('-').map { int -> int.toInt() }
    val pattern = parts[1].first()
    val password = parts[2]

    return (password[range[0] - 1] == pattern && password[range[1] - 1] != pattern) ||
            password[range[0] - 1] != pattern && password[range[1] - 1] == pattern
}

fun main(args: Array<String>) {
    val lines = readLines("src/main/resources/Day2.txt")

    println(lines.filter { line -> validateSledPassword(line) }.count())
    println(lines.filter { line -> validateTobogganPassword(line) }.count())
}