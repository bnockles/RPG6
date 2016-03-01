/**
 * 
 */
package enemies.Demo;

import java.util.ArrayList;

/**
 * @author Mr. Nockles
 * I made this for my demo. This is bare bones!
 *
 */
public class SampleEnemy {

	ArrayList<Target> targets;
	public String name;
	public static String itemPosessed;
	public static int attack;
	/**
	 * 
	 */
	public SampleEnemy(int number, ArrayList<Target> targets) {
		name = "enemy"+number;
		this.targets=targets;
		this.itemPosessed=determineRandomItem();
		attack = 10;
	}
	public static String determineRandomItem(){
		String[]items = {"potion A","potion B","poison A","","","","sword","armor","shield","hemlock","more poisonous stuff"};
		int x = (int)Math.random()*items.length;
		return items[x];
	}
	public static String getItemPosessed(){
		return itemPosessed;
	}
	public static int getAttack(){
		return attack;
	}
	//the following method will most likely be
	//something required by the Battles team. It is likely they will 
	//require a method for taking a turn in a battle
	public void takeTurn(){

		int targetSelection = (int) (Math.random()*targets.size());
		targets.get(targetSelection).hit(this);

	}
	public void takeBossTurn(){
		int targetSelection = 0;
		for(int i = 0; i < targets.size() - 1; i++)
		{
			if(targets.get(i).getHP() < targets.get(targetSelection).getHP())
				targetSelection = i;
		}
		targets.get(targetSelection).hit(this); 
	}

}
