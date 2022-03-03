import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TicTacToeTest {

    @Test
    fun `game has nine fields` () {
        val game = TicTacToe()

        assertEquals(9, game.grid.flatten().size)
    }
}