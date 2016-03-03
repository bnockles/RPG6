package items.itemslist;

import items.Character;
import items.Consumable;

public class MP500 extends Consumable {
	
	boolean user_mp_full = true;

	public MP500() {
		super("MP500", "MP 500", "Restores 500 MP to the target.", 1);
		
	}


	public boolean canUse(Character user) {
		if (user_mp_full){
			return false;
		}
		return true;
	}


	public void use(Character user) {
		System.out.println("You restored 500 MP!");
		
	}

}
