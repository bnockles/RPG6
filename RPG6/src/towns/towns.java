package towns;

import java.util.ArrayList;

/**
 * 
 * @author Khandaker Shayel & Jeffrey Lei
 *
 */

public class towns {
	public String getTownName() {  
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public ArrayList<AbstractNPC> getTownNpcs() {
		return townNpcs;
	}

	public void setTownNpcs(ArrayList<AbstractNPC> townNpcs) {
		this.townNpcs = townNpcs;
	}

	public ArrayList<AbstractNPC> townNpcs;
	public String townName;
	
	public towns(ArrayList<AbstractNPC> npcs, String name){
		this.townNpcs = npcs;
		this.townName = name;
	}
	
}
