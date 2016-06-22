package towns;

/**
 * 
 * @author Khandaker Shayel
 *
 */

public interface Repairable 
{
	//durabilities 
	public static final int fullDurability = 3;
	public static final int mediumDurability = 2;
	public static final int noDurability = 1;
	public static final int broken = 0;
	
	//rarities
	public static final int bronze = 1;
	public static final int silver = 2;
	public static final int gold = 3;
	public static final int diamond = 4;
	public static final int mithril = 6;
	
	//checks to see if item can be repaired or not
	boolean reparable(Equipment item);
	
	//returns the value of how much durability the current item has left
	//if durability is 0 the item is not reparable	
	int getDurability();
	
	//sees how rare a certain item is in order to calculate a repair cost
	int getRarity(Equipment item);
}
