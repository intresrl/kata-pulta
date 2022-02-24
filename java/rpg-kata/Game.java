import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Map<RpgCharacter, Integer> positions = new HashMap<>();

    public Game() {

    }

    public boolean isInRange(RpgCharacter attacker, RpgCharacter defender) {
        int distance = Math.abs(positions.get(attacker) - positions.get(defender));
        int firstRange = attacker.getRange();
        return distance <= firstRange;
    }

    public void spawnAt(RpgCharacter fighter, int position) {
        positions.put(fighter, position);
    }
}
