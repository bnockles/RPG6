package towns;

import java.util.ArrayList;

public class Equipment extends Item{
	

	public static final int NONE 	= 0;
	public static final int HELMET 	= 1;
	public static final int CHEST 	= 2;
	public static final int LEG 	= 3;
	public static final int SHOE    = 4;
	public static final int WEAPON  = 5;
	//s
	public String req;
	private int durability;
	private int typeOf;//what kind of armor is it.
	private Stats stats;
	private int jobClass;//0 is Warrior, 1 is Bowman, 2 is Mage, 3 is Rogue, 4 is All
	
	public Equipment(String name, String description, String req, String type, int tag, int enemyTag, int typeOf, Stats stats, int durability){
		super(name, description, req, type, tag, enemyTag);//req and descriptions are switched up when writing. will fix.
		this.durability = durability;
		this.typeOf = typeOf;
		this.stats = stats;
		
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	public static int getHelmet() {
		return HELMET;
	}

	public static int getChest() {
		return CHEST;
	}

	public static int getLeg() {
		return LEG;
	}

	public static int getShoe() {
		return SHOE;
	}

	public static int getWeapon() {
		return WEAPON;
	}

	public int getDurability() {
		return durability;
	}

	public int getTypeOf(){ return this.typeOf; }
	public Stats getStats(){ return this.stats; }

	public boolean canUse(Character user){ return true; }
	//public void using(Character user){ user.equip(this); }




	public String getItemInfo() {
		String returnd = "Name: " + this.getName() + " Description: " + this.getDescription();
		return returnd;
	}




	public String getItemType() {
		return this.getType();
	}




	public boolean getIsUsableForBattle() {
		return false;
	}




	public int getChangeValue() {
		return 0;
	}

	public void use(Character user, Consumable consume) {
		
	}

	public boolean canCraft(Equipment item, ArrayList<Item> items) {
		
		return false;
	}

	public boolean reparable(Equipment item) {
		if(item.getDurability() == 100){
			return false;
		}
		return true;
	}

	public int getRarity(Equipment item) {
		if(item.getName() == "Bronze Sword")
		{
			return 1;
		}
		if(item.getName() == "Wooden Bow")
		{
			return 2;
		}
		if(item.getName() == "Mithril Wand")
		{
			return 3;
		}
		if(item.getName() == "Poppy's Hammer")
		{
			return 4;
		}
		return 5;
		
	}

	public boolean isStorable() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getRarity(Item i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
