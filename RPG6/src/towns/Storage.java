package towns;

import java.awt.event.KeyEvent;

public class Storage extends AbstractNPC {
	private Item[][] storage;

	public Storage(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		storage = new Item[3][3];
	}
	//test

	/**
	 * Moves item(s) from player inventory to storage
	 * 
	 * @param playerInventory 	Where item is being taken out of
	 * @param storage			New location of item
	 */
	public static void storeItem(Item[][] playerInventory, Item[][] storage, 
			Item toBeStored, Storable s){
		if(s.isStorable()){
			int count = 0;
			for(int r = 0; r < storage.length; r++){
				for(int c = 0; c < storage[0].length; c++){
					if(storage[r][c] != null){
						count++;
						if(count >= (storage.length*storage[0].length))
							System.out.println("Your storage is full!!!");
					}else{
						storage[r][c] = toBeStored;
					}
				}
			}
		}
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

	public Item[][] getStorage(){
		return storage;
	}

	@Override
	public void npcMovement() {  
		// TODO Auto-generated method stub
	}
}
