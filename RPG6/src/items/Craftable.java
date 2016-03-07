package items;

import java.util.ArrayList;

public interface Craftable {
	
	//craftItem necessaryItem = new craftItem("Gem");

	public void craft(Item item, ArrayList<Item> inventory);
	// if (canCraft){ canCraft will decide: if an item can be crafted, if the player has the necessary items to craft it, if the player has enough gold
	//	inventory.add(item);
	//	playerCurrency -= item.getCraftPrice();
	//	inventory.remove(necessaryItem);
	// }
	
}
