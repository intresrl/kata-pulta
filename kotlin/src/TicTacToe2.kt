import State.*

class Board {
    private val grid = MutableList(3) {
        MutableList(3) {
            EMPTY
        }
    }

    fun get(x: Int, y: Int): State{
        return grid[y][x]
    }

    fun set(state: State, x: Int, y: Int){
        grid[y][x] = state
    }

    fun isOver(): Boolean{
        return true
    }
}

class Game(var player : State = getPlayer()){
    val grid : Board = Board()
    fun play(x: Int, y: Int){
        grid.set(player, x, y)
        player = player.nextPlayer();
    }
}

fun main() {
    println(TicTacToe().toString())
}
