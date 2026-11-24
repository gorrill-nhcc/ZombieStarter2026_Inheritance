package domain;
/**
 * CombatGear defines how an entity applies damage.
 * Different gear implementations can provide single-target, AoE, or specialized
 * effects.
 */
public interface CombatGear {
    /**
     * Apply this gear's damage effect.
     * 
     * @param context       The battle context containing all combatants
     * @param primaryTarget The primary target (for single-target gear)
     * @param crit          Whether this is a critical hit
     */
    void applyDamage(CombatContext context, Entity primaryTarget, boolean crit);

    String getGearName();
}
