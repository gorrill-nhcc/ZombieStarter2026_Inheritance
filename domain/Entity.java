package domain;

import java.util.Objects;

public abstract class Entity {

    private String name;
    private int health;
    private final int MAX_HEALTH;

    public Entity(String name, int health) {
        this.name = name;
        this.health = health;
        MAX_HEALTH = health;
    }

    /**
     * Invoked at the top of each combat round.
     * Subclasses should override this to handle cooldown ticks
     * or any other per-round state updates.
     */
    public abstract void combatUpdate();

    public void takeDamage(int amt) {
        // have a strat to validate your inputs
        if (amt < 0) {
            throw new IllegalArgumentException("Damage values must be positive");
        } else {
            health -= amt;
        }
    }

    public void heal(int amt){
        if(amt < 0){
            throw new IllegalArgumentException("Heal values must be positive");
        } else if(health + amt <= MAX_HEALTH){
            health += amt;
        } else {
            health = MAX_HEALTH;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isLiving() {
        return getHealth() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entity other = (Entity) o;
        return health == other.health && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health);
    }
}
