import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2KtTest {

    @Test
    fun validateSledPassword() {
        val password1 = "1-3 a: abcde"
        assertTrue(validateSledPassword(password1))

        val password2 = "1-3 b: cdefg"
        assertFalse(validateSledPassword(password2))

        val password3 = "2-9 c: ccccccccc"
        assertTrue(validateSledPassword(password3))
    }

    @Test
    fun validateTobogganPassword() {
        val password1 = "1-3 a: abcde"
        assertTrue(validateTobogganPassword(password1))

        val password2 = "1-3 b: cdefg"
        assertFalse(validateTobogganPassword(password2))

        val password3 = "2-9 c: ccccccccc"
        assertFalse(validateTobogganPassword(password3))
    }
}