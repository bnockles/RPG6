package characters;

import java.util.ArrayList;

//Dennis Lin
public class Inventory {

	ArrayList<Equipable> armor;//declaration
	ArrayList<Wieldable> weapons;
	ArrayList<Wearable> accesories;
	ArrayList<Consumable> potions;
	
	
	public Inventory(){
		armor = new ArrayList<Equipable>();//initializer
		weapons = new ArrayList<Wieldable>();
		accesories = new ArrayList<Wearable>();
		potions = new ArrayList<Consumable>();
	}
	
	
}
