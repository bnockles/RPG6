package towns;

import java.awt.event.KeyEvent;

/**
 * 
 * @author Harry Feng
 *
 */


public class Merchant extends AbstractNPC {

	public Merchant(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
	}

	String[] ItemShop = {"Healing Potion", "Mana Potion", "Attack Potion", "Speed Potion", "Defense Potion"};
	static boolean buyable;
	
	@Override
	public void npcMovement() {
		// TODO Auto-generated method stub
		
	}

}
