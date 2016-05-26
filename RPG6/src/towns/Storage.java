package towns;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Storage extends AbstractNPC {

	public Storage(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		// TODO Auto-generated constructor stub
	}
	
	static ArrayList<String> storedItems = new ArrayList<String>();
	static boolean storable;
	
	@Override
	public void npcMovement() {  
		// TODO Auto-generated method stub
		
	}
}
