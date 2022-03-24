package fra.wardrobe

import fra.wardrobe.WardrobeFactory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class WardrobeFactoryTest {

    @Test
    fun `all combinations`() {
        val sizes = arrayListOf(50, 75, 100, 120)
        val wardrobes = WardrobeFactory.getPossibleCombos(sizes, 250)
        assertNull( wardrobes)
    }
}
