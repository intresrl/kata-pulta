package ticTacToe.tes

import ticTacToe.tes.State.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class TicTacToeTest {

    @Test
    fun `game has nine fields`() {
        val game = TicTacToe()

        assertEquals(9, game.grid.flatten().size)
    }

    @Test
    fun `game can end in a tie`() {
        val game = TicTacToe()
        game.take(X, 1, 1)
        game.take(O, 1, 0)
        game.take(X, 2, 0)
        game.take(O, 0, 2)
        game.take(X, 1, 2)
        println(game.toString())
        game.take(O, 2, 1)
        game.take(X, 2, 2)
        game.take(O, 0, 0)
        assertFalse(game.over())
        game.take(X, 0, 1)

        println(game.toString())
        assertTrue(game.over())
        assertTrue(game.tie())
    }

    @Test
    fun `game can end in a win by X`() {
        val game = TicTacToe()
        game.take(X, 0, 0)
        game.take(O, 2, 0)
        game.take(X, 1, 1)
        game.take(O, 1, 2)
        game.take(X, 2, 2)

        println(game.toString())
        assertTrue(game.over())
        assertTrue(game.someoneWin())
    }
}
