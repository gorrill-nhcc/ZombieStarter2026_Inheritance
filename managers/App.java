package managers;

import java.util.random.RandomGenerator;
import domain.Person;
import domain.Zombie;
import services.Utilities;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        RandomGenerator rand = RandomGenerator.getDefault();

        String[] names = {"Hank", "Gwen", "Pete", "Michone", 
        "Glen", "Adrienne", "Isabella", "Drew", "Peanut"};

        ArrayList<Person> colony = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            int health = Utilities.DEFAULT_PERSON_HEALTH;
            int food = Utilities.randomInRange(5, 10);
            int ammo = Utilities.randomInRange(20, 30);
            Person p = new Person(names[i], health, food, ammo);
            colony.add(p);
        }
        
        ApocalypseManager manager = new ApocalypseManager(colony);
        boolean survivors = manager.runSimulation();

    }
}
