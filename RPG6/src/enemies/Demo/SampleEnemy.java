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
	
	//by not making getters and setters and making these variables public,
	//they are automatically read AND write! You might choose not to do this
	public int level;
	public double strength;
	
	//examples of how to add variety
	public static final int LIZARD = 0;
	public static final int RAPTOR = 1;
	public static final int FLYING = 2;
	public static final int ZOMBIE = 3;
	
	
	
	/**
	 * 
	 */
	public SampleEnemy(int number, ArrayList<Target> targets) {
		name = "enemy"+number;
		this.targets=targets;
		
	}
	
	public SampleEnemy(int level, int type, ArrayList<Target> targets) {
		name = "bad guy";//default name in case type is undefined
		this.level = level;
		this.targets=targets;
		if(type==LIZARD){
			name = "lizard enemy";
			strength = level*.8;
		}
		else if(type==RAPTOR){
			name = "raptor enemy";
			strength = level*1.8;
		}
		else if(type==FLYING){
			name = "flying enemy";
			strength = level*1.2;
		}
		else if(type==ZOMBIE){
			name = "undead enemy";
			strength = level*1.55;
		}
	}
	
	//the following method will most likely be
	//something required by the Battles team. It is likely they will 
	//require a method for taking a turn in a battle
	public void takeTurn(){
		int targetSelection = (int) (Math.random()*targets.size());
		targets.get(targetSelection).hit(this);
	}

}
