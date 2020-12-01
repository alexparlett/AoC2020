fun main(args: Array<String>) {
    val lines = readLines("src/main/resources/Day1.txt")
        .map { line -> line.toInt() }

    val cominations2 = CombinationGenerator(lines, 2)
    println(cominations2.find { item -> item.sum() == 2020}?.reduce{ a,b -> a * b})

    val cominations3 = CombinationGenerator(lines, 3)
    println(cominations3.find { item -> item.sum() == 2020}?.reduce{ a,b -> a * b})
}