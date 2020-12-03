import java.lang.Integer.min

fun countTreesInPath(world: List<String>, right: Int, down: Int, x: Int = 0, y: Int = 0, trees: Long = 0): Long {
    val newX: Int = if (x + right < world[y].length) {
       x + right
    } else {
        (x + right) - (world[y].length)
    }
    val newY: Int = min(y + down, world.size)
    val newTrees = if (newY < world.size && world[newY][newX] == '#') trees + 1 else trees

    if(newY < world.size)
        return countTreesInPath(world, right, down, newX, newY, newTrees)

    return newTrees
}

fun main(args: Array<String>) {
    val world = readLines("src/main/resources/Day3.txt")

    val threeOne = countTreesInPath(world, 3, 1)
    val oneOne = countTreesInPath(world, 1, 1)
    val fiveOne = countTreesInPath(world, 5, 1)
    val sevenOne = countTreesInPath(world, 7, 1)
    val oneTwo = countTreesInPath(world, 1, 2)

    println(threeOne)
    println(oneOne)
    println(fiveOne)
    println(sevenOne)
    println(oneTwo)
    println(threeOne * oneOne * fiveOne * sevenOne * oneTwo)
}