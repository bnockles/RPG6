package items.itemslist;

import items.Character;
import items.Consumable;

public class MP1000 extends Consumable {
	
	boolean user_mp_full = true;

	public MP1000(String name, String description, int amount) {
		super("MP 1000", "Restores 1000 MP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_mp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 1000 MP!");
		
	}

}
