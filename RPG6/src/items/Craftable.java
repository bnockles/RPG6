package items;

import java.util.ArrayList;

public interface Craftable {

	public boolean canCraft(Character hero, ArrayList<Item> items);
	
}
