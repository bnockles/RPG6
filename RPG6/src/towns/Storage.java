package towns;

import java.util.ArrayList;

public class Storage extends AbstractNPC{
	private static Item[] storage;

	public Storage(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		storage = new Item[3];
	}

	//stores items
	public static ArrayList<Item> storeItem(int index, Item item, ArrayList<Item> inventory){
		if(storage[index] != null){
			inventory.add(storage[index]);
		}
		storage[index] = item;
		inventory.remove(item);
		System.out.println("Item has been stored!");
		return inventory;
	}

	//retrieves items
	public static ArrayList<Item> retrieveItem(int index, Item item, ArrayList<Item> inventory){
		if(storage[index] != null){
			inventory.add(storage[index]);
			storage[index] = null;
		}
		System.out.println("Item has been retrieved");
		return inventory;
	}

	//calculates fee
	public static int storageFee(Item[] storage){
		int fee = 0;
		int rarity = 0;
		for(Item i : storage){
			rarity += 0;
		}
		fee = rarity * 200;
		return fee;
	}



	public static Item[] getStorage(){
		return storage;
	}

	@Override
	public void npcMovement() {  
		// TODO Auto-generated method stub
	}
}
