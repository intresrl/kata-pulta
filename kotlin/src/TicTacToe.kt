enum class State {
    X, O, EMPTY
}

class TicTacToe {
    val grid = MutableList(3) {
        MutableList(3) {
            State.EMPTY
        }
    }

    fun take(player: State, x: Int, y: Int): Unit {
        check(player != State.EMPTY)
        check(grid[y][x] == State.EMPTY)
        grid[y][x] = player
    }

    fun over(): Boolean {
        return grid.flatten().all { it != State.EMPTY } ||
                grid.any { row -> row.all { it == State.X }} ||
                grid.any { row -> row.all { it == State.O }} ||
                grid.all { it[0] == State.X } ||
                grid.all { it[1] == State.X } ||
                grid.all { it[2] == State.X } ||
                grid.all { it[0] == State.O } ||
                grid.all { it[1] == State.O } ||
                grid.all { it[2] == State.O } ||
                (0..2).all {grid[it][it] == State.X } ||
                (0..2).all {grid[it][it] == State.O } ||
                (0..2).all {grid[it][2-it] == State.X } ||
                (0..2).all {grid[it][2-it] == State.O }
    }

    override fun toString(): String {
        return grid.joinToString("\n") {
            it.joinToString( " ") { state -> when(state){
                State.EMPTY -> "."
                else -> state.toString()
            } }
        }
    }
}

fun main() {
    println(TicTacToe().toString())
}
