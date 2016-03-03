package items.itemslist;

import items.Character;
import items.Consumable;

public class MP100 extends Consumable {
	
	boolean user_mp_full = true;

	public MP100(String name, String description, int amount) {
		super("MP100", "MP 100", "Restores 100 MP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_mp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 100 MP!");
		
	}

}
