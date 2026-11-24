package domain;

import java.util.Objects;

public class Zombie extends Entity {

    private String zombieType;

    public Zombie(String zombieType) {
        super(zombieType, 2);
        this.zombieType = zombieType;
    }

    public Zombie(String zombieType, int health) {
        super(zombieType, health);
        this.zombieType = zombieType;
    }

    public String getZombieType() {
        return zombieType;
    }

    public void setZombieType(String zombieType) {
        this.zombieType = zombieType;
    }

    @Override
    public String toString() {
        return "Zombie{zombieType='" + zombieType + "', health=" + getHealth() + ", isLiving=" + isLiving() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Zombie other = (Zombie) o;
        return super.equals(o) && Objects.equals(zombieType, other.zombieType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zombieType);
    }
}
