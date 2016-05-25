package towns;

import java.util.ArrayList;

public class Storage extends AbstractNPC{
	private static Equipment[] storage;

	public Storage(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		storage = new Equipment[3];
	}

	/**
	 * Moves item(s) from player inventory to storage
	 * 
	 * @param toBeStored 	Item that is going to be stored
	 * @param storage		New location of item
	 */
	public static void storeItem(int index, Equipment toBeStored){
		int count = 0;
		for(int r = 0; r < storage.length; r++){
				if(storage[index] != null){
					count++;
					if(count >= (storage.length))
						System.out.println("Your storage is full!!!");
				}else{
					storage[index] = toBeStored;
					System.out.println("Item has been stored!");
				}
		}
	}
	
	public static ArrayList<Equipment> convertToList(Equipment[] array){
		ArrayList<Equipment> list = new ArrayList<Equipment>();
			for(Equipment e : array){
				list.add(e);
		}
		return list;
	}

	/**
	 * Calculates how much player will pay upon withdrawal of item(s)
	 * 
	 * @param storage
	 */
	public static int storageFee(Item[][] storage, Storable j){
		int fee = 0;
		for(Item[] r : storage){
			for(Item i : r)
				fee += j.getRarity(i);
		}
		return fee/(storage.length);
	}

	/**
	 * Moves item(s) from storage to player inventory
	 * 
	 * @param storage
	 * @param playerInventory
	 */
	public static void retrieveItem(Item[][] storage, Item[][] playerInventory, int r, int c){
		if(r < 0 || r > 3){
			if(c < 0 || c > 3){
			}
		}else{
			for(int i = 0; i < playerInventory.length; i++){
				for(int j = 0; j < playerInventory[0].length; j++){
					if(playerInventory[i][j] != null){
					}else{
						playerInventory[i][j] = storage[r][c];
					}
				}
			}
		}
	}

	public static Equipment[] getStorage(){
		return storage;
	}

	@Override
	public void npcMovement() {  
		// TODO Auto-generated method stub
	}
}
