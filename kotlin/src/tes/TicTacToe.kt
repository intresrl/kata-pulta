package tes

import tes.State.EMPTY
import tes.State.X
import tes.State.O

class TicTacToe {
    val grid = MutableList(3) {
        MutableList(3) {
            EMPTY
        }
    }

    private var lastPlayer = EMPTY

    fun take(player: State, x: Int, y: Int) {
        check(player != EMPTY)
        check(grid[y][x] == EMPTY)
        check(!over())
        check(lastPlayer != player)
        grid[y][x] = player
        lastPlayer = player
    }

    fun over(): Boolean {
        return someoneWin() || tie()
    }

    fun tie(): Boolean {
        return !someoneWin() && gridIsFull()
    }

    fun someoneWin(): Boolean {
        return winInRows(X) ||
                winInRows(O) ||
                winInCols(X) ||
                winInCols(O) ||
                winInDiags(X) ||
                winInDiags(O)
    }

    private fun winInDiags(x: State) =
        (0..2).all { grid[it][it] == x } ||
        (0..2).all { grid[it][2 - it] == x }

    private fun winInCols(s: State) =
        grid.all { it[0] == s } ||
        grid.all { it[1] == s } ||
        grid.all { it[2] == s }

    private fun winInRows(s: State) = grid.any { row -> row.all { it == s } }

    private fun gridIsFull() = grid.flatten().all { it != EMPTY }

    override fun toString(): String =
        grid.joinToString("\n", postfix = "\n") {
            it.joinToString(" ") { state ->
                when (state) {
                    EMPTY -> "."
                    else -> state.toString()
                }
            }
        }
}

fun main() {
    println(TicTacToe().toString())
}
