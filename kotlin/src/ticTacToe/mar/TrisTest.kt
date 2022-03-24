package ticTacToe.mar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class TrisTest {

    @Test
    fun `game has nine fields`() {
        val game = Tris()

        assertEquals(9, game.size())
    }

    @Test
    fun `a player can take a field if not already taken`() {
        val game = Tris()

        game.play(1, 1)
    }

    @Test
    fun `a player cannot take a field if already taken`() {
        assertThrows<java.lang.Error> {
            val game = Tris()

            game.play(1, 1)
            game.play(1, 1)
        }
    }

    @Test
    fun `players take turn`() {
        val game = Tris()

        game.play(1, 1)
        game.play(2, 1)

        assertEquals("""
            _ _ _
            _ O X
            _ _ _
            """.stripIndent().strip(), game.print())
    }

    @Test
    fun `a game is over when all fields are taken`() {
        val game = Tris()

        game.play(0, 0)
        game.play(0, 1)
        game.play(0, 2)
        game.play(1, 0)
        game.play(1, 1)
        game.play(1, 2)
        game.play(2, 0)
        game.play(2, 1)
        game.play(2, 2)

        assertEquals("""
            O X O
            X O X
            O X O
            """.stripIndent().strip(), game.print())
        assertTrue(game.isOver())
    }

    @Test
    fun `a game is over when all fields in a diagonal are taken by a player`() {
        val game = Tris()
        val expected = """
        O X O
        X O X
        O _ _
        """.stripIndent().strip()

        game.play(0, 0)
        game.play(1, 0)
        game.play(2, 0)
        game.play(0, 1)
        game.play(1, 1)
        game.play(2, 1)
        game.play(0, 2)

        assertTrue(game.isOver())
        assertEquals(expected, game.print())
    }

    @Test
    fun `a game is over when all fields in a column are taken by a player`() {
        val game = Tris()
        val expected = """
        O X X
        O _ _
        O _ _
        """.stripIndent().strip()

        game.play(0, 0)
        game.play(1, 0)
        game.play(0, 1)
        game.play(2, 0)
        game.play(0, 2)

        assertTrue(game.isOver())
        assertEquals(expected, game.print())
    }

    @Test
    fun `a game is over when all fields in a row are taken by a player`() {
        val game = Tris()
        val expected = """
        O O O
        X X _
        _ _ _
        """.stripIndent().strip()

        game.play(0, 0)
        game.play(0, 1)
        game.play(1, 0)
        game.play(1, 1)
        game.play(2, 0)

        assertTrue(game.isOver())
        assertEquals(expected, game.print())
    }
}
