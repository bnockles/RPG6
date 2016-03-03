package items.itemslist;

import items.Character;
import items.Consumable;

public class HP100 extends Consumable {
	
	boolean user_hp_full = true;

	public HP100() {
		super("HP100", "HP 100", "Restores 100 HP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_hp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 100 HP!");
		
	}

}
