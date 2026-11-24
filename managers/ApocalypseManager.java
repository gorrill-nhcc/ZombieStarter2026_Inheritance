package managers;
import services.Utilities;
import services.BattleService;
import domain.Person;
import domain.Zombie;
import java.util.ArrayList;

public class ApocalypseManager {
    private ArrayList<Person> survivors;
    private int daysLeft = services.Utilities.DEFAULT_DAYS_LEFT;
    private int zombiesKilled = 0;
    private int totalZombiesKilled = 0;

    public ApocalypseManager(ArrayList<Person> survivors) {
        this.survivors = survivors;
    }

    public boolean runSimulation(){
        while(survivors.size() > 1 && daysLeft > 0){
            runDaySequence();
            runNightSequence();
        }

        return survivorsLiving();
    }

    public boolean runNightSequence(){
        ArrayList<Zombie> zombies = spawnZombies();
        printBattleIntro(zombies.size());
        printIntro();
        while(survivorsLiving() && zombies.size() > 0){
            if(survivors.get(survivors.size() - 1).getAmmo() > 0){
                Person survivor = survivors.get(survivors.size() - 1);
                Zombie zombie = zombies.get(zombies.size() - 1);
                boolean survivorWins = BattleService.gunBattle(survivor, zombie);
                if(survivorWins){
                    zombies.remove(zombies.size() - 1);
                    zombiesKilled++;
                    System.out.println(survivor.getName() + " killed a zombie!");
                } else {
                    survivors.remove(survivors.size() - 1);
                    System.out.println(survivor.getName() + " was killed by a zombie!");
                }

            }
            totalZombiesKilled += zombiesKilled;
            zombiesKilled = 0;
        }
        printSimulationSummary();
        return survivorsLiving();
    }

    public void runDaySequence(){
        feedSurvivors();
        removeDeadSurvivors();
        daysLeft--;
    }

    public void feedSurvivors(){
        for(Person survivor : survivors){
            survivor.eat();
        }
    }

    public void removeDeadSurvivors(){
        survivors.removeIf(survivor -> !survivor.isLiving());
    }

    public ArrayList<Zombie> spawnZombies(){
        ArrayList<Zombie> zombies = new ArrayList<>();
        int zombieCount = Utilities.randomInRange(Utilities.MIN_ZOMBIE_COUNT, Utilities.MAX_ZOMBIE_COUNT);
        for(int i = 0; i < zombieCount; i++){
            zombies.add(new Zombie("base zombie"));
        }
        return zombies;
    }

    public boolean survivorsLiving(){
        return survivors.size() > 0;
    }

    public void printIntro(){
        System.out.println("Welcome to the Zombie Apocalypse Simulation!");
        System.out.println("You have " + daysLeft + " days to survive.");
        System.out.println("There are " + survivors.size() + " survivors in your group.");
    }

    public void printBattleIntro(int numZombies){
        System.out.println("As the sun sets, you see shabmling horde approaching. . .");
        System.out.printf("You see %d zombies at the perimiter. To battle positions!", numZombies);;
    }

    public void printDaySummary(){
        System.out.println("Day " + (services.Utilities.DEFAULT_DAYS_LEFT - daysLeft) + " Summary:");
        System.out.println("Survivors remaining: " + survivors.size());
        System.out.println("Days left: " + daysLeft);
        System.out.println("Zombies Killed this night: " + zombiesKilled);
        System.out.println("Total Zombies Killed: " + totalZombiesKilled);
    }

    public void printSimulationSummary(){
        System.out.println("Simulation Summary:");
        if(survivorsLiving()){
            System.out.println("Survivors made it through the apocalypse!");
            System.out.println("Survivors remaining: " + survivors.size());
        } else {
            System.out.println("All survivors have perished.");
        }
        System.out.println("Days left: " + daysLeft);
        System.out.println("Total Zombies Killed: " + totalZombiesKilled);
    }
}
