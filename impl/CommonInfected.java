package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * The Common Infected is the basic "foot soldier" of the Zombies.
 * They have pretty mediocore health and attack.
 *
 * @author thaoc
 */
public class CommonInfected extends Character implements IZombie{

    /**
     * A Common Infected starts with 50 points of health
     */
    public CommonInfected() {
        super(50);
    }

    /**
     * An attack from a Common Infected decrease a survivor's health by 5 points.
     * @param survivor
     */
    @Override
    public void attack(ISurvivor survivor) {
        survivor.decreaseHealth(5);
    }

}
