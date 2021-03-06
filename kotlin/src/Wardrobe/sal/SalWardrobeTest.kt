package wardrobe.sal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SalWardrobeTest {

    @Test
    fun `no matches = no combinations`() {
        val actual = combinations(43, listOf(95, 10))
        assertTrue(actual.isEmpty())
    }

    @Test
    fun `no width = one empty combination`() {
        val actual = combinations(0)
        assertEquals(setOf(emptyList<Width>()), actual)
    }

    @Test
    fun `width is exact size`() {
        val actual = combinations(23, listOf(13, 23, 8))
        assertEquals(setOf(listOf(23)), actual)
    }

    @Test
    fun `width is exact size or multiples`() {
        val actual = combinations(42, listOf(7, 6, 42))
        assertEquals(setOf(listOf(42), List(6) { 7 }, List(7) { 6 }), actual)
    }

    @Test
    fun `width is unique sum`() {
        val actual = combinations(116, listOf(40, 39, 37))
        val expected = setOf(listOf(37, 39, 40))
        assertEquals(expected, actual)
    }

    @Test
    internal fun `so many combinations`() {
        val goal = 18
        val sizes = listOf(4, 5, 6, 8)
        val actual = combinations(goal, sizes)
        val expected = setOf(
            listOf(5, 5, 8),
            listOf(4, 6, 8),
            listOf(6, 6, 6),
            listOf(4, 4, 4, 6),
            listOf(4, 4, 5, 5),
        )
        assertEquals(expected, actual)
    }
}
