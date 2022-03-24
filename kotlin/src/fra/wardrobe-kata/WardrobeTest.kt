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
}
