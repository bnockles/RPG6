package characters;

import java.util.ArrayList;

public class Player extends Hero implements CharacterInterface {
	ArrayList<Item> inventory;
	Party party;
	int gold;
	
	public Player(String name, double health, double currHealth, double attack,
			double defense, double mana, double currMana, double speed,
			double dropRate, double critHitChance, double currentExp) {
		super(name, health, currHealth, attack, defense, mana, currMana, speed,
				dropRate, critHitChance, currentExp);
		gold = 1000;
		party = new Party(this);
		inventory = new ArrayList<Item>();
		
	}
	
	public ArrayList getInvList(){
		return inventory;
	}
	
	
//	public String[] getInventory(){
//		String[] inv;
//		try{
//			inv = new String[inventory.size()];
//			for(int i = 0; i < inventory.size(); i++){
//				inv[i] = inventory.get(i).getName();
//			}
//		}catch(Exception e){
//			String[] inv1 = {" "};
//			return inv1; 
//		}
//		return inv;
//	}

	public void addItem(Item item){		
			inventory.add(item);

	}
	
	public void removeItem(Item item){
		try{
			inventory.remove(item);
		}catch(Exception e){
			return;
		}
	}
	
	public Party getParty(){
		return party;
	}

	public int getPlayerCurrency() {
		return gold;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
