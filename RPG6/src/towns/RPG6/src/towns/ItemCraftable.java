package towns;

import java.util.ArrayList;

/**
 * 
 * @author Willson Tan
 *
 */

public interface ItemCraftable 
{
	public String craftedName(Equipment[][] list, int itemRecipe);
	public boolean isDurable(Equipment item);
	public ArrayList<String> matchesRecipe(ArrayList<Equipment> playerInventory, Equipment[][] Recipe);

}

