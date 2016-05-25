package items;

import java.util.ArrayList;

public class Equipment extends Item implements EquipInterface, getItemStats, Craftable, Repairable {
	public ArrayList<Item> yo = new ArrayList<Item>();
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
	private CraftHelper help;
	private int jobClass;//0 is Warrior, 1 is Bowman, 2 is Mage, 3 is Rogue, 4 is All
	
	public Equipment(String name, String description, String req, String type, int tag, int enemyTag, int typeOf, Stats stats, int durability, CraftHelper help){
		super(name, description, req, type, tag, enemyTag);//req and descriptions are switched up when writing. will fix.
		this.durability = durability;
		this.typeOf = typeOf;
		this.stats = stats;
		this.help = help;
		
	}
	
	public CraftHelper getHelper(){
		return help;
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
	public void using(Character user){ user.equip(this); }




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
	
	public String getItemName(){
		return this.getName();
	}
	
	public Stats getAllStats() {
		return this.getStats();
	}

	public int getArmorType() {
		return this.typeOf;
	}

	public int getHealth() {
		return this.getStats().getHealth();
	}

	public int getMana() {
		return this.getStats().getMana();
	}

	public int getAttack() {
		return this.getStats().getAttack();
	}

	public int getDefense() {
		return this.getStats().getDefense();
	}

	public int getSpeed() {
		return this.getStats().getSpeed();
	}

	public int getStrength() {
		return this.getStats().getStrength();
	}

	public int getDexterity() {
		return this.getStats().getDexterity();
	}

	public int getIntelligence() {
		return this.getStats().getIntelligence();
	}

	public int getWisdom() {
		return this.getStats().getWisdom();
	}

	public int getLuck() {
		return this.getStats().getLuck();
	}

	public boolean isStorable(Item i) {
		return true;
	}

	public int getRarity(Item i) {
		return this.typeOf;
	}

	public boolean canCraft(Character hero, ArrayList<Item> items) {
		int count = 0;
		boolean isItTrue = false;
		for (int i = 0; i< items.size(); i++){
			for (int j = 0; j < hero.getInventory().size(); j++){
				if (hero.getInventory().get(i).equals(items.get(j))){
					count++;
					break;
				}
			}
		}
		if(count == items.size()){
			isItTrue = true;
		}
		return isItTrue;
	}

	public boolean reparable(Equipment item) {
		
		return true;
	}

	public int getRarity(Equipment item) {		
		return typeOf;
	}
}




