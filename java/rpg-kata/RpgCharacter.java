public class RpgCharacter {

    private int health = 1000;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return 1;
    }

    public boolean isAlive() {
        return health > 0;
    }

    private boolean isDead() {
        return !isAlive();
    }

    public void dealDamage(RpgCharacter target, int damage) {
        target.receiveDamage(damage);
    }

    private void receiveDamage(int damage) {
        health -= Math.min(damage, health);
    }

    public void heal(RpgCharacter target, int cure) {
        if (target.isAlive()) {
            target.receiveCure(cure);
        }
    }

    private void receiveCure(int cure) {
        health = Math.min(1000, cure + health);
    }
}
