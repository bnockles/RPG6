package towns;
/**
 * 
 * @author Yash Patel
 *
 */
public interface ItemToGiveAsReward {
	 //Checks durability of the item
	int getDurability();
	
	//Checks for how rare the item is
	int getRarity();
	
	//Gives worth of the item
	int priceOfItem();
	
	//Checks whether the player has the item already or not
	boolean playerHasItem();
	
	//Gives an ArrayList of items the player already has
	arrayList<Item> getPlayerInventory();
}
