package domain;

import java.util.Objects;

public class Person extends Entity {

    private int food;
    private int ammo;

    public Person(String name) {
        super(name, 5);
        this.food = 8;
        this.ammo = 25;
    }

    public Person(String name, int health, int food, int ammo) {
        super(name, health);
        this.food = food;
        this.ammo = ammo;
    }

    public void eat() {
        if (food > 0) {
            food--;
        } else {
            takeDamage(1);
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "Person{name='" + getName() + "', health=" + getHealth() + ", food=" + food + ", ammo=" + ammo + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person other = (Person) o;
        return super.equals(o) && food == other.food && ammo == other.ammo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), food, ammo);
    }
}
