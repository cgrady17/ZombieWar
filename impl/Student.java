package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Students are weak vs zombies
 * 
 * @author Christopher Witt
 */
public class Student extends Character implements ISurvivor{
	private static int charcterCount = 0;
	
	/**
	 * A student starts with 35 points of health
	 */
	public Student() {
		super(35);
		this.id = ++charcterCount;
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(5);
	}
	
}
