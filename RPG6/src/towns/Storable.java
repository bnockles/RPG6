package towns;

import java.util.ArrayList;

public interface Storable {
	
	public ArrayList<String> storedItems = new ArrayList<String>();
	
	public void storeItem(Item item)//{
//		if(item != questItem){
//			playerInventory.remove(item);
//			storedItems.add(item);
//		}
//	}
	
	public void storageFee(ArrayList<String> list, int days);
}
