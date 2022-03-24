package ticTacToe.orn

class TicTacToe {
    private val grid = MutableList(3) {
        MutableList(3) {
            State.EMPTY
        }
    }
    var currentStatus = Status.PLAYING

    fun move(player: State) {
        var validInput = false
        var row: Int
        var col: Int
        do {
            println("Enter move for player $player (row[0-2] column[0-2]): ")
            row = Integer.valueOf(readLine())
            col = Integer.valueOf(readLine())
            if (row in 0..2 && col in 0..2 && grid[row][col] === State.EMPTY) {
                grid[row][col] = player
                validInput = true
            } else {
                println("The chosen move ($row, $col) is not valid. Try again...")
            }
        } while (!validInput)
    }

    fun updateStatus(player: State) {
        if (hasWon(player)) {
            currentStatus = if (player === State.X) Status.X_WON else Status.O_WON
        } else if (isDraw()) {
            currentStatus = Status.DRAW
        }
    }

    fun isDraw(): Boolean {
        return grid.flatten().all { it != State.EMPTY }
    }

    fun hasWon(player: State): Boolean {
        return (grid.any { row -> row.all { it == player } } ||
            grid.all { it[0] == player } ||
            grid.all { it[1] == player } ||
            grid.all { it[2] == player } ||
            (0..2).all { grid[it][it] == player } ||
            (0..2).all { grid[it][2 - it] == player })
    }

    fun printBoard(): String =
        grid.joinToString("\n", postfix = "\n") {
            it.joinToString(" ") { state ->
                when (state) {
                    State.EMPTY -> "."
                    else -> state.toString()
                }
            }
        }
}

fun main() {
    var currentPlayer = if (Math.random()>0.5) State.X else State.O
    val board = TicTacToe()
    do {
        board.move(currentPlayer)
        board.updateStatus(currentPlayer)
        board.printBoard()
        when {
            board.currentStatus === Status.X_WON -> Status.X_WON.message()
            board.currentStatus === Status.O_WON -> Status.O_WON.message()
            board.currentStatus === Status.DRAW -> Status.DRAW.message()
        }
        currentPlayer = if (currentPlayer === State.X) State.O else State.X
    } while (board.currentStatus === Status.PLAYING)
}
