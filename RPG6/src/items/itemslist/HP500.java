package items.itemslist;

import items.Character;
import items.Consumable;

public class HP500 extends Consumable {
	
	boolean user_hp_full = true;

	public HP500(String name, String description, int amount) {
		super("HP500", "HP 500", "Restores 500 HP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_hp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 500 HP!");
		
	}

}
