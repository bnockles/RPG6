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
		armor.add(new SampleArmor("1", "NOOB ARMOR"));
		weapons.add((Wieldable) new SampleWeapon("1", "NOOB SWORD"));
		accesories.add(new SampleAccesory("1", "NOOB RING"));
		potions.add(new SamplePotion("1", "RED POTION"));
		
	}
	
	
}
