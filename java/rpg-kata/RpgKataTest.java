import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RpgKataTest {

    @Test
    public void newlyCreatedCharacterHas1000HpAndLvl1() {
        final RpgCharacter character = new RpgCharacter();

        int characterHealth = character.getHealth();

        assertEquals(1000, characterHealth);
        assertEquals(1, character.getLevel());
        assertTrue(character.isAlive());
    }

    @Test
    public void aCharacterCanDealDamage() {
        final RpgCharacter character = new RpgCharacter();
        final RpgCharacter target = new RpgCharacter();

        character.dealDamage(target, 100);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void aCharacterDiesWhenDamageExceedsHealth() {
        final RpgCharacter character = new RpgCharacter();
        final RpgCharacter target = new RpgCharacter();

        character.dealDamage(target, 1001);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void aCharacterCanHealAnotherCharacter() {
        final RpgCharacter character = new RpgCharacter();
        final RpgCharacter target = new RpgCharacter();
        character.dealDamage(target, 1001);

        character.heal(target, 1001);

        assertFalse(target.isAlive());
    }

    @Test
    public void aCharacterCannotHealAbove1000() {
        final RpgCharacter character = new RpgCharacter();
        final RpgCharacter target = new RpgCharacter();
        character.dealDamage(target, 42);

        character.heal(target, 1005);

        assertTrue(target.isAlive());
        assertEquals(1000, target.getHealth());
    }

}