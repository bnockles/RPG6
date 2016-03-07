/**
 * 
 */
package enemies.Demo;

import java.util.ArrayList;

/**
 * @author bnockles
 *
 */
public class SampleTarget implements Target {

	static int targetNumber=0;
	String name;
	boolean hit;
	private int health;
	/**
	 * 
	 */
	public SampleTarget() {
		targetNumber++;
		health = 100;
		name = "Target "+targetNumber+ " (has not been hit yet)"; 
		//+this.getHP()+ "HP currently";
		hit = false;
	}

	/* (non-Javadoc)
	 * @see enemies.Demo.Target#hit()
	 */
	public void hit(SampleEnemy e) {
		int newHealth = health - e.attack;
		//System.out.println(e.attack);
		name = name.replace(" not", "").replace(" yet", "");
		this.health = newHealth;

		if(e.itemPosessed==""){
			System.out.println(e.name + " has no items");
		}
		else{
			System.out.println(e.name + " has " + SampleEnemy.getItemPosessed(e));
		}
		
		EnemyBattleScreen.battleMessage=name+ " was hit by "+e.name + " and has taken " + e.attack + " damage and has "  + health + "health";
	}
	
	public static String getItemPosessed(SampleEnemy e){
		return e.itemPosessed;
	}

	public String getName() {
		return name;
	}

	public int getHP() {
		// TODO Auto-generated method stub
		return health;
	}

}
