package items;

import java.util.ArrayList;

public class Craft {
	
	private boolean can;
	private ArrayList<Item> items;
	
	public Craft(boolean can, ArrayList<Item> items) {
		this.can = can;
		this.items = items;
	}

	public boolean isCan() {
		return can;
	}

	public void setCan(boolean can) {
		this.can = can;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
