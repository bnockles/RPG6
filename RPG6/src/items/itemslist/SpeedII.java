package items.itemslist;

import items.Character;
import items.Consumable;

public class SpeedII extends Consumable {

	public SpeedII(String name, String description, int amount) {
		super("Speed II", "Increases the target's speed by 15.", 1);
		
	}

	public boolean canUse(Character user) {
		return true;
	}

	public void use(Character user) {
		System.out.println("Your target's speed has increased by 15!");

	}

}
