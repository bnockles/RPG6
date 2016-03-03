package items.itemslist;

import items.Character;
import items.Equipment;
import items.Stats;

public class BronzeSword extends Equipment {

	public BronzeSword() {
		super("BronzeSword", "Bronze Sword", "REQ: 5 STR", WEAPON, new Stats(5, 5, 1, 0, 0, 1), 100);
		
	}
	@Override
	public boolean canUse(Character user){
		if (user.getTrueStats().getStrength() >= 5){
			return true;
		}
		return false;
	}
}
