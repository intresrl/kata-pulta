import State

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

}

class Game(var player = getPlayer()){

}
fun main() {
    println(TicTacToe().toString())
}
