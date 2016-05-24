package items;

import java.util.ArrayList;

public class CraftHelper {
	
	private boolean craft;
	ArrayList<Item> recipe;
	
	public CraftHelper(boolean craft, ArrayList<Item> recipe) {
		this.craft = craft;
		recipe.add(potionStock.consumableStock(1));
		this.recipe = recipe;
	}
	public boolean getCraft(){
		return craft;
	}
	public ArrayList<Item> getRecipe(){
		return recipe;
	}
}
