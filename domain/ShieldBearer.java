package domain;

public class ShieldBearer extends Person{
    private final int DEFAULT_SHIELD_ABILITY_COOLDOWN = 3;
    private int shieldStrength;
    private int shieldTimer;
    private int shieldAbilityCooldown;
    private boolean shieldInUse = false;


    public ShieldBearer(String name, int health, int food, int ammo, int shieldStrength){
        super(name, health, food, ammo);
        this.shieldStrength = shieldStrength;
    }

    public void combatUpdate(){
        if(shieldInUse){
            heal(1);
            shieldTimer--;
            if(shieldTimer < 1){
                shieldInUse = false;
                shieldAbilityCooldown = DEFAULT_SHIELD_ABILITY_COOLDOWN;
            }
        } else if(shieldAbilityCooldown > 0){
            shieldAbilityCooldown--;
        } else {
            // TODO: handle this later
        }

    }

    public void useShieldAbility(){
        // 1. set the shield timer
        shieldTimer = shieldStrength;
        // 2. set cooldown
        shieldAbilityCooldown = DEFAULT_SHIELD_ABILITY_COOLDOWN;
        // 3. shieldInUse -> true
        shieldInUse = true;
    }

}
