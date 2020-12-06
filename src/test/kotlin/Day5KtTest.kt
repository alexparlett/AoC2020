import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * Copyright (c) 2015-2020 Homonoia Studios.
 *
 * @author alexparlett
 * @since 06/12/2020
 */
internal class Day5KtTest {
    @Test
    fun findRow() {
        assertEquals(44, findRow("FBFBBFF"))
    }

    @Test
    fun findColumn() {
        assertEquals(5, findColumn("RLR"))
    }

    @Test
    fun findSeat() {
        assertEquals(357, findSeat(44, 5))
    }

    @Test
    fun splitParts() {
        val (aisle, seat) = splitParts("BFFFBBFRRR")

        assertEquals("BFFFBBF", aisle)
        assertEquals("RRR", seat)
    }
}