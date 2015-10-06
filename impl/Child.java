/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * A child is the weakest survivor against zombies
 * 
 */
public class Child extends Character implements ISurvivor{

	/**
	 * A child starts with 10 points of health
	 */
	public Child() {
		super(10);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(2);
	}
	
	
}
