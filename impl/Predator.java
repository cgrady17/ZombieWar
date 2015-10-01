package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * The Predator is stronger than a Common Infected, but not as strong as a Tank.
 * He has good health and good attack.
 *
 * @author thaoc
 */
public class Predator extends Character implements IZombie{

    /**
     * A tank starts with 100 points of health
     */
    public Tank() {
        super(100);
    }

    /**
     * An attack from the tank decrease a survivor's health by 10 points.
     * @param survivor
     */
    @Override
    public void attack(ISurvivor survivor) {
        survivor.decreaseHealth(10);
    }

}