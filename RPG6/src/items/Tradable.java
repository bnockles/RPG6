package items;

import java.util.ArrayList;

public interface Tradable {
	
	ArrayList<Item> invent = new ArrayList<Item>();

	public boolean sellItem(Item item);
	//if (item.getType() != "questItem"){
	//	invent.remove(item);
	//	playerCurrency += item.getpriceValue();
	//} NOTE: THESE TWO GET METHODS ARE NOT MADE. NOR THE VALUES CONSTRUCTED. ADD WHEN NECESSARY TO IMPLEMENT
	
	public boolean buyItem(Item item);
	// if (playerCurrency > item.getpriceValue() && invent < full){ //NOTE: A FULL VALUE IS NOT DECIDED YET.
	//	invent.add(item);
	//	playerCurrency -= item.getpriceValue();
	//} NOTE: SAME NOTE AS SELLITEM
	
}
