package items.itemslist;

import items.Character;
import items.Consumable;

public class HP1000 extends Consumable {
	
	boolean user_hp_full = true;

	public HP1000() {
		super("HP1000", "HP 1000", "Restores 1000 HP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_hp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 1000 HP!");
		
	}

}
