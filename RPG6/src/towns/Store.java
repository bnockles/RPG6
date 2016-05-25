package towns;

import java.util.ArrayList;

public class Store extends AbstractStore{

	public Store(String name, String description, ArrayList<Item> storeInventory) {
		super(name, description, storeInventory);
		// TODO Auto-generated constructor stub
	}

	public void buyItem(ArrayList<Item> playerInventory, ArrayList<Item> storeInventory, int itemNumber, int playerWealth){
		playerInventory.add(storeInventory.get(itemNumber));
		storeInventory.remove(itemNumber);
	}
	
	public void sellItem(ArrayList<Item> playerInventory, ArrayList<Item> storeInventory, int itemNumber, int playerWealth){
		storeInventory.add(playerInventory.get(itemNumber));
		playerInventory.remove(itemNumber);
	}
	
}
