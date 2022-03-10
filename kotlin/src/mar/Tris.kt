package mar

class Tris {
    private var next = 'O'
    private val game: MutableList<Char> = MutableList(9) { '_' }

    fun size() = game.size

    fun play(x: Int, y: Int) {
        val position = x + (y * 3)

        if (game[position] != '_') {
            throw java.lang.Error()
        }
        game[position] = next

        setNext()
    }

    fun print() = game
        .chunked(3).map { it.joinToString(" ") }
        .joinToString("\n")

    private fun setNext() {
        next = if (next == 'O') 'X' else 'O'
    }

    fun isOver(): Boolean =
        allFieldsAreTake() || diagonalWin() || verticalWin() || horizontalWin()

    private fun allFieldsAreTake() = true
    private fun diagonalWin(): Boolean {
        val diagonals = listOf(listOf(0,4,8), listOf(2,4,6))
        return someMatch(diagonals)
    }

    private fun someMatch(groupsByIndex: List<List<Int>>) = groupsByIndex.any { x ->
        val first = game[x[0]]
        return first != '-' && x.all { game[it] == first }
    }

    private fun verticalWin(): Boolean {
        val verticals = listOf(listOf(0,3,6), listOf(1,4,7), listOf(2,5,8))
        return someMatch(verticals)
    }

    private fun horizontalWin(): Boolean {
        val horizontals = listOf(listOf(0,1,2), listOf(3,4,5), listOf(6,7,8))
        return someMatch(horizontals)
    }
}
