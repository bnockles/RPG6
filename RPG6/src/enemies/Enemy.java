package enemies;

import java.util.ArrayList;

public abstract class Enemy {

	public Enemy(){
		//TODO
	}
	
	public abstract Character determineTarget(ArrayList<Character> character);
	
}
