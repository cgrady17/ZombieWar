package zombiewar;

import java.util.ArrayList;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
   we made changes.*
 * @author thaoc
 */
public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  private static ArrayList<String> killList = new ArrayList<String>();
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10);
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      int zombieType = (int) (Math.random() * 2);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make("common"); break;
        case 1: zombies[i] = (IZombie) factory.make("tank"); break;
        case 2: zombies[i] = (IZombie) factory.make("predator"); break;
      }
    }
    return zombies;
  }

  public static ISurvivor[] randomSurvivors() {
    int numZombies = (int) (Math.random() * 20);
    ISurvivor[] survivors = new ISurvivor[numZombies];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() * 3);
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make("soldier"); break;
        case 1: survivors[i] = (ISurvivor) factory.make("teacher"); break;
        case 2: survivors[i] = (ISurvivor) factory.make("student"); break;
        case 3: survivors[i] = (ISurvivor) factory.make("child"); break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }
  
  /**
   * keep track of who killed who
   */
  public static void addKill(ICharacter dead, ICharacter killer){
	  String killPair = killer.getID()+" killed "+dead.getID();
	  killList.add(killPair);
  }  
  
  public static void printKills(){
	  for(String killPair: killList){
		  System.out.println(killPair);		  
	  }
  }  

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    IZombie[] zombies = randomZombies();
    ISurvivor[] survivors = randomSurvivors();

    System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
    System.out.println("But there are " + zombies.length + " zombies waiting for them.");
    
    //TODO: the survivors attack first.  One characte attack each zombie.
    //      When all the survivors have done attacking, it's the zombies' 
    //      turn to attack.  For each zombie that is still alive, attack
    //      each suvivor that is still alive.  Repeat this cycle until
    //      all the zombies are all dead or all the survivors are all dead.

		while (!allDead(survivors) && !allDead(zombies)) {
			// survivors attack first
			for (int s = 0; s < survivors.length; s++) {
				// only living survivors can attack
				ISurvivor thisSurvivor = survivors[s];
				if (thisSurvivor.isAlive())
					for (int z = 0; z < zombies.length; z++) {
						IZombie thisZombie = zombies[z];
						// only living zombies need be attacked
						if (thisZombie.isAlive()){
							thisSurvivor.attack(thisZombie);
							// tallie the dead!
							if(!thisZombie.isAlive()){
								addKill(thisZombie, thisSurvivor);
							}
						}
					}
			}

			// zombies turn to attack
			for (int z = 0; z < zombies.length; z++){
				// only living zombies can attack
				IZombie thisZombie = zombies[z];
				if (thisZombie.isAlive())
					for (int s = 0; s < survivors.length; s++) {
						ISurvivor thisSurvivor = survivors[s];
						// only living survivors need be attacked
						if (thisSurvivor.isAlive()){
							thisZombie.attack(thisSurvivor);
							// tallie the dead!
							if(!thisSurvivor.isAlive()){
								addKill(thisSurvivor, thisZombie);
							}
						}
					}
			}

		}
		
		printKills();
    

    if (allDead(survivors)) {
      System.out.println("None of the survivors made it.");
    } else {
      int count = 0;
      for(int i=0; i<survivors.length; i++) {
        if (survivors[i].isAlive()) count++;
      }
      System.out.println("It seems " + count + " have made it to safety.");
    }
  }

}
