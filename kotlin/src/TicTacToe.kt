enum class State {
    X, O, EMPTY
}

class TicTacToe {
    val grid = MutableList(3) {
        MutableList(3) {
            State.EMPTY
        }
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
