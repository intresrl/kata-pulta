public class RpgCharacter {

    public static final int MAX_HEALTH = 1000;
    private int health = MAX_HEALTH;
    private int level = 1;
    private Faction faction;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return health > 0;
    }

    private boolean isDead() {
        return !isAlive();
    }

    public void dealDamage(RpgCharacter target, int damage) {
        if (target != this) {
            int actualDamage = getActualDamage(target, damage);

            target.receiveDamage(actualDamage);
        }
    }

    private int getActualDamage(RpgCharacter target, int damage) {
        var gapLevel = target.getLevel()-getLevel();
        return computeDamage(damage, gapLevel);
    }

    private int computeDamage(int damage, int gapLevel) {
        int actualDamage;
        if (gapLevel >=5) actualDamage = damage / 2;
        else if (gapLevel <=-5) actualDamage = damage + damage /2;
        else actualDamage = damage;
        return actualDamage;
    }

    private void receiveDamage(int damage) {
        health -= Math.min(damage, health);
    }

    public void heal(RpgCharacter target, int cure) {
        if (target == this && target.isAlive()) {
            target.receiveCure(cure);
        }
    }

    private void receiveCure(int cure) {
        health = Math.min(MAX_HEALTH, cure + health);
    }

    public int getRange(){
        throw(new UnsupportedOperationException());
    }

    public Faction getFaction() {
        return this.faction;
    }

    public void joinFaction(Faction faction) {
        this.faction = faction;
    }
}

class MeleeFighter  extends RpgCharacter{
    public int getRange(){
        return 2;
    }
}

class RangedFighter  extends RpgCharacter{
    public int getRange(){
        return 20;
    }
}




