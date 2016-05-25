package items;

import java.util.ArrayList;

public interface ItemCraftable {
	//s
	public boolean canCraft(Equipment item, ArrayList<Item> items);
	//if (item.upgrade.getCan() && this.hasAllItems(inventory, items))
	// return true;
	// return false;

}
