package towns;

import java.util.ArrayList;

public interface Storable {
	
	/**
	 * 
	 * @author Jeffrey Lei
	 *
	 */
	
	public ArrayList<String> storedItems = new ArrayList<String>();
	
	public void storeItem(String item);//{
//		if(item != questItem){
//			playerInventory.remove(item);
//			storedItems.add(item);
//		}
//	}
	
	public void storageFee(ArrayList<String> list, int days);//{
//		int fee = days*days*(list.size());
//		playerCurrency = playerInventory.getMoney()-fee;
//	}
	
	public void retrieveItem(String item);
}
