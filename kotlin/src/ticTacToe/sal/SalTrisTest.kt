package ticTacToe.sal

import org.junit.jupiter.api.Test
import ticTacToe.sal.Location.*


class SalTrisTest {
    @Test
    fun `play until tied`() {
        with(SalTris()) {
            play(NORTHWEST)
            play(NORTH)
            play(NORTHEAST)
            play(WEST)
            play(SOUTHWEST)
            play(CENTER)
            play(EAST)
            play(SOUTHEAST)
            play(SOUTH)
            println(this)
            assert(isGameOver())
        }
    }

    @Test
    fun `play until X wins on first row`() {
        with(SalTris()) {
            play(NORTHWEST)
            play(SOUTHWEST)
            play(NORTH)
            play(SOUTH)
            play(NORTHEAST)
            println(this)
            assert(isGameOver())
        }
    }

    @Test
    fun `play until O wins on diagonal`() {
        with(SalTris()) {
            play(NORTHWEST)
            play(CENTER)
            play(SOUTHEAST)
            play(NORTHEAST)
            play(NORTH)
            play(SOUTHWEST)
            println(this)
            assert(isGameOver())
        }
    }
}
