package items.itemslist;

import items.Character;
import items.Consumable;

public class SpeedI extends Consumable {

	public SpeedI() {
		super("SpeedI", "Speed I", "Increases the target's speed by 5.", 1);
		
	}

	public boolean canUse(Character user) {
		return true;
	}

	public void use(Character user) {
		System.out.println("Your target's speed has increased by 5!");

	}

}
