package mar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class TrisTest {

    @Test
    fun `game has nine fields`() {
        val game = Tris()

        assertEquals(9, game.size())
    }

    @Test
    fun `a player can take a field if not already taken`() {
        val game = Tris()

        game.play(1,1)
    }

    @Test
    fun `a player cannot take a field if already taken`() {
        assertThrows<java.lang.Error> {
            val game = Tris()

            game.play(1,1)
            game.play(1,1)
        }
    }

    @Test
    fun `players take turn`() {
            val game = Tris()

            game.play(1,1)
            game.play(2,1)

            assertEquals("    OX   ", game.print())
    }
}
