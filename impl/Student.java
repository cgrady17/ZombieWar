package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Students are weak vs zombies
 * 
 * @author Christopher Witt
 */
public class Student extends Character implements ISurvivor{

	/**
	 * A soldier starts with 100 points of health
	 */
	public Student() {
		super(35);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(5);
	}
	
}
