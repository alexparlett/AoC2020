import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Copyright (c) 2015-2020 Homonoia Studios.
 *
 * @author alexparlett
 * @since 03/12/2020
 */
internal class Day3KtTest {

    @Test
    fun countTreesInPath() {

        val world = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        assertEquals(7, countTreesInPath(world, 3, 1))

    }
}