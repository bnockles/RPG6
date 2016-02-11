package enemies;

import java.util.ArrayList;

public abstract class NeutralMob extends Enemy{
//
	
public abstract void haveItem(String geographicRegion, ArrayList<Item>);

public Character determineTarget(ArrayList<Character> character){
	
	/*
	 * Logic behind this for neutral mob:
	 * at the beginning of the game, the enemy will be placed randomly in a location.
	 * if the character walks on the spot the enemy was spawned out before, that is the target
	 * they do not really affect the plot of the game
	 * 
	 * */
	return null;
	
	
}


}
