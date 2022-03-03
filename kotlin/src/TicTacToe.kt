import State.EMPTY

class TicTacToe {
    val grid = MutableList(3) {
        MutableList(3) {
            EMPTY
        }
    }

    var lastPlayer = EMPTY

    fun take(player: State, x: Int, y: Int) {
        check(player != EMPTY)
        check(grid[y][x] == EMPTY)
        check(!over())
        check(lastPlayer != player)
        grid[y][x] = player
        lastPlayer = player
    }

    fun over(): Boolean {
        return grid.flatten().all { it != EMPTY } ||
                grid.any { row -> row.all { it == State.X } } ||
                grid.any { row -> row.all { it == State.O } } ||
                grid.all { it[0] == State.X } ||
                grid.all { it[1] == State.X } ||
                grid.all { it[2] == State.X } ||
                grid.all { it[0] == State.O } ||
                grid.all { it[1] == State.O } ||
                grid.all { it[2] == State.O } ||
                (0..2).all { grid[it][it] == State.X } ||
                (0..2).all { grid[it][it] == State.O } ||
                (0..2).all { grid[it][2 - it] == State.X } ||
                (0..2).all { grid[it][2 - it] == State.O }
    }

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
