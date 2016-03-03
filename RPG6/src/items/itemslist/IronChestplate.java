package items.itemslist;

import items.Character;
import items.Equipment;
import items.Stats;

public class IronChestplate extends Equipment {

	public IronChestplate(String name, String description, int type, Stats stats, int durability) {
		super("IronChestplate", "Iron Chestplate", "REQ: 20 STR, 5 DEX", CHEST, new Stats(15, 8, 1, 1, 5), 100);
		
	}

	@Override
	public boolean canUse(Character user){
		if (user.getTrueStats().getStrength() >= 20 && user.getTrueStats().getDexterity() >= 5){
			return true;
		}
		return false;
	}
	
}
