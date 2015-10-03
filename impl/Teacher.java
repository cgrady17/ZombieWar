/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * A Teacher is stronger than a child or student, but still much weaker than a Soldier.
 *
 * @author thaoc
 */
public class Teacher extends Character implements ISurvivor{
	private static int charcterCount = 0;
	
    /**
     * A teacher starts with 60 points of health
     */
    public Teacher() {
        super(60);
        this.id = ++charcterCount;
    }

    @Override
    public void attack(IZombie zombie) {
        zombie.decreaseHealth(7);
    }


}

