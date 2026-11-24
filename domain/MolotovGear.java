package domain;
import java.util.List;

/**
 * Molotov - Throws an incendiary device that spreads fire to nearby enemies.
 */
public class MolotovGear implements CombatGear {
    private static final int SPLASH_RADIUS = 2;
    private static final int PRIMARY_DAMAGE = 3;
    private static final int SPLASH_DAMAGE = 1;

    @Override
    public void applyDamage(CombatContext context, Entity primaryTarget, boolean crit) {
        // Always deal critical damage with Molotov
        if (crit || true) { // Molotov always crits
            primaryTarget.setHealth(0);
        } else {
            primaryTarget.takeDamage(PRIMARY_DAMAGE);
        }

        // Apply splash damage to nearby targets
        List<Entity> allTargets = context.getAllTargets();
        for (Entity target : allTargets) {
            if (target != primaryTarget && target.isLiving()) {
                target.takeDamage(SPLASH_DAMAGE);
            }
        }
    }

    @Override
    public String getGearName() {
        return "Molotov Cocktail";
    }
}
