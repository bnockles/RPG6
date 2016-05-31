package towns;

import java.util.ArrayList;

public abstract class AbstractStore {
	
	public String name;
	public String description; 
	public ArrayList<Item> storeInventory = new ArrayList<Item>();
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public ArrayList<Item> getStoreInventory(){
		return storeInventory;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStoreInventory(ArrayList<Item> storeInventory){
		this.storeInventory = storeInventory;
	}
	
	public AbstractStore(String name, String description, ArrayList<Item> storeInventory) {
		this.name = name;
		this.description = description;
		this.storeInventory = storeInventory;
	}
	
	public void buyItem(ArrayList<Item> playerInventory, ArrayList<Item> storeInventory, int itemNumber){
	}
	
	public void sellItem(ArrayList<Item> playerInventory, ArrayList<Item> storeInventory, int itemNumber){
	}

}
