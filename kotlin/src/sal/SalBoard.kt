package sal

import sal.Location.*
import java.util.*

enum class Location {
    NORTHWEST, NORTH, NORTHEAST,
    WEST, CENTER, EAST,
    SOUTHWEST, SOUTH, SOUTHEAST,
}

enum class Player {
    X, O;

    operator fun inc() = if (this == X) O else X
}

fun <T> List<T>.allEquals() = distinct().size == 1 && none { it == null }

class SalBoard(initial: Map<Location, Player?> = emptyMap()) {
    private val state = EnumMap<Location, Player?>(
        Location.values().associateWith { null } + initial
    )

    operator fun get(pos: Location) = state[pos]

    operator fun set(where: Location, value: Player) {
        state[where] = value
    }

    fun isGameOver() = allTaken() || winOnARow() || winOnAColumn() || winOnADiag()

    private fun allTaken() = state.none { (_, e) -> e == null }

    private fun winOnARow() = values().toList().windowed(3).anyWins()

    private fun winOnAColumn() =
        listOf(
            listOf(NORTHWEST, WEST, SOUTHWEST),
            listOf(NORTH, CENTER, SOUTH),
            listOf(NORTHEAST, EAST, SOUTHEAST)
        ).anyWins()

    private fun winOnADiag() =
        listOf(
            listOf(NORTHWEST, CENTER, SOUTHEAST),
            listOf(NORTHEAST, CENTER, SOUTHWEST)
        ).anyWins()

    private fun List<List<Location>>.anyWins() = any { locations ->
        locations.map { state[it] }.allEquals()
    }

    private fun Location.print() = state[this]?.toString() ?: "."

    override fun toString() = """
         ${NORTHWEST.print()}${NORTH.print()}${NORTHEAST.print()}
         ${WEST.print()}${CENTER.print()}${EAST.print()}
         ${SOUTHWEST.print()}${SOUTH.print()}${SOUTHEAST.print()}
    """.trimIndent()


}

class SalTris(startingPlayer: Player = Player.X) {
    private var currentPlayer: Player = startingPlayer
    private val board = SalBoard()

    fun play(where: Location) {
        check(board[where] == null)
        check(!board.isGameOver()) { toString() }
        board[where] = currentPlayer
        currentPlayer++
    }

    fun isGameOver() = board.isGameOver()

    override fun toString() = "\n$board\n"


}

