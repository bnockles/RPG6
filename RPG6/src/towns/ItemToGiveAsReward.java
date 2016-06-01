package towns;
/**
 * 
 * @author Yash Patel
 *
 */
public interface ItemToGiveAsReward {
	 //Checks durability of the item to make sure item is not too durability
	int getDurability();
	
	//Checks for how rare the item is so player does not get too rare of an item
	int getRarity();
	
	//Gives worth of the item so player does not get too expensive of an item
	int priceOfItem();
	
	//Checks whether the player has the item already or not so player does not get the same item again
	boolean playerHasItem();
}
