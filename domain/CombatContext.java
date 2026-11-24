package domain;
import java.util.List;
public class CombatContext {
    private Entity attacker;
    private List<Entity> allTargets;

    public CombatContext(Entity attacker, List<Entity> allTargets) {
        this.attacker = attacker;
        this.allTargets = allTargets;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public List<Entity> getAllTargets() {
        return allTargets;
    }

    public List<Entity> getTargetsInRadius(Entity center, int radius) {
        // Could expand with spatial logic; for now returns all
        return allTargets;
    }


    
}
