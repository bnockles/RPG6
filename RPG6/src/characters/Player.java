package characters;

import items.CharacterInterface;
import items.Equipment;
import items.Item;
import items.Stats;

import java.util.ArrayList;

public class Player extends Hero implements CharacterInterface {
	ArrayList<Item> inventory;
	Party party;
	int gold;
	
	public Player(String name, int level, double currHealth, double currMana, Stats stats){
		super(name, level, currHealth, currMana, stats);
		gold = 1000;
		party = new Party(this);
		inventory = new ArrayList<Item>();
	}
	
	public ArrayList getInvList(){
		return inventory;
	}
	
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
