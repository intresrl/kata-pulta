import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        character.dealDamage(character, 42);

        character.heal(character, 1005);

        assertTrue(character.isAlive());
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void aCharacterCannotDamageItself() {
        final RpgCharacter character = new RpgCharacter();
        int startHealth = character.getHealth();

        character.dealDamage(character, 100);

        int finalHealth = character.getHealth();
        assertEquals(startHealth, finalHealth);
    }

    @Test
    public void aCharacterCanOnlyHealItself() {
        final RpgCharacter character = new RpgCharacter();
        final RpgCharacter target = new RpgCharacter();
        character.dealDamage(target, 42);

        int startHealth = target.getHealth();
        character.heal(target, 10);
        int finalHealth = target.getHealth();

        assertEquals(startHealth, finalHealth);
    }

    @Test
    void charactersCanChangeLevel() {
        RpgCharacter john = new RpgCharacter();

        john.setLevel(42);

        assertEquals(42, john.getLevel());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            100  |  950
            800  |  600
            """)
    void ifTargetIs5LevelsOverAttackerItGetsHalfDamage(int damage,
                                                       int finalHealth) {
        final RpgCharacter strongDefender = new RpgCharacter();
        strongDefender.setLevel(42);
        final RpgCharacter weakAttacker = new RpgCharacter();
        weakAttacker.setLevel(37);

        weakAttacker.dealDamage(strongDefender, damage);

        assertEquals(finalHealth, strongDefender.getHealth());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
               100  |  850
               200  |  700
            """)
    void ifTargetIs5LevelsUnderAttackerItGetsHalfMoreDamage(int damage,
                                                            int finalHealth) {
        final RpgCharacter strongDefender = new RpgCharacter();
        strongDefender.setLevel(32);
        final RpgCharacter weakAttacker = new RpgCharacter();
        weakAttacker.setLevel(37);

        weakAttacker.dealDamage(strongDefender, damage);

        assertEquals(finalHealth, strongDefender.getHealth());
    }

    @Test
    void charactersMeleeFighterHasRange() {
        RpgCharacter meleeCharacter = new MeleeFighter();

        assertEquals(2, meleeCharacter.getRange());
    }

    @Test
    void rangedFighterHasRange() {
        RpgCharacter rangedFighter = new RangedFighter();

        assertEquals(20, rangedFighter.getRange());
    }

    @Test
    void isInRange() {
        RpgCharacter fighter1 = new MeleeFighter();
        Game game = new Game();
        game.spawnAt(fighter1, 0);
        assertTrue(game.isInRange(fighter1, fighter1));
    }

    @Test
    void isNotInRange() {
        RpgCharacter fighter1 = new MeleeFighter();
        RpgCharacter fighter2 = new MeleeFighter();
        Game game = new Game();
        game.spawnAt(fighter1, 0);
        game.spawnAt(fighter2, 1000);
        assertFalse(game.isInRange(fighter1, fighter2));
    }

    @Test
    void newlyBelongToNoFaction() {
        RpgCharacter fighter1 = new MeleeFighter();

        assertNull(fighter1.getFaction());
    }

    @Test
    void belongToFaction() {
        RpgCharacter fighter1 = new MeleeFighter();
        Faction faction = new Faction();

        fighter1.joinFaction(faction);

        assertEquals(faction, fighter1.getFaction());
    }
}
