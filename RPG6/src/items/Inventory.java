package items;

import java.util.HashMap;

/**
 * Manages the inventory of each PC.
 * Keeps track of stock via a hashmap of item ids and their stock count
 * @class Inventory
 */
public final class Inventory {
	private HashMap<String,Integer> stock;
	private int cursor;
	
	public Inventory(){
		this.stock = new HashMap<String,Integer>();
		this.cursor = 0;
	}
	
	
	
	public int getStock(String id){
		if(stock.get(id) != null){
			return stock.get(id);
		}
		else{
			return 0;
		}
	}
	
	public void addStock(String id){
		addStock(id, 1);
	}
	public void addStock(String id, int amt){
		if(stock.containsKey(id)){
			stock.put(id, stock.get(id)+amt);
		}
		else{
			stock.put(id, amt);
		}
	}
	
	public void removeStock(String id){
		this.removeStock(id, 1);
	}
	public void removeStock(String id, int amt){
		if(!stock.containsKey(id)){
			System.out.println("Warning: Attempting to remove a nonexistent id from the inventory.");
			return;
		}
		
		//if stock amt becomes 0, remove id from the hashmap
		if(stock.get(id)-amt <= 0){
			stock.remove(id);
		}
		//else, keep id and remove amt from stock
		else{
			stock.put(id, stock.get(id)-amt);
		}
	}

	
	
	
	public int getCursor(){ return this.cursor; }
	
	public void setCursor(int pos){
		//mod with stock size to prevent out of bounds
		this.cursor = pos % this.stock.size();
	}
	
	public void moveCursor(int steps){
		//mod with stock size to prevent out of bounds
		this.cursor = (this.cursor + steps) % this.stock.size();
	}

}
