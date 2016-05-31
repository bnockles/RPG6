package items;

//From Battle's Team Howard

import java.util.ArrayList;

public interface ItemsForEnemies {
	public ArrayList<Item> getItemSet();//returns the set of items for a certain region.
	public Item getItemToDrop();//chooses one item to drop from set above
		
}
