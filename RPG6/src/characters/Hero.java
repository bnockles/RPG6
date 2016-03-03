package characters;

import java.util.ArrayList;
	

public class Hero extends Character {

	ArrayList<SampleItem> inventory;
	ArrayList<SampleItem> equiped;
	int x;
	int y;
	
	public Hero(String name,
			double health, double attack, double defense, double mana,
			double speed, double dropRate, double critHitChance,
			double currentExp) {
		super(name, health, attack, defense, mana,
				speed, dropRate, critHitChance, currentExp);
		// TODO Auto-generated constructor stub
			inventory = new ArrayList<SampleItem>();
			equiped = new ArrayList<SampleItem>();
			x = 200;
			y = 200;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList getInvList(){
		return inventory;
	}
	
	
	public String[] getInventory(){
		String[] inv;
		try{
			inv = new String[inventory.size()];
			for(int i = 0; i < inventory.size(); i++){
				inv[i] = inventory.get(i).getName();
			}
		}catch(Exception e){
			String[] inv1 = {" "};
			return inv1; 
		}
		return inv;
	}
	
	public String[] getEquiped(){
		String[] eq;
		try{
			eq = new String[equiped.size()];
			for(int i = 0; i < equiped.size(); i++){
				eq[i] = equiped.get(i).getName();
			}
		}catch(Exception e){
			String[] eq1 = {" "};
			return eq1; 
		}
		return eq;
	}
	
	public void addItem(SampleItem item){		
			inventory.add(item);

	}
	
	public void removeItem(SampleItem item){
		try{
			inventory.remove(item);
		}catch(Exception e){
			return;
		}
	}
	
	public void equipItem(SampleItem item){
		try{
			equiped.add(item);
		}catch(Exception e){
			return;
		}
	}
	
	public void dequipItem(SampleItem item){
		try{
			equiped.remove(item);
		}catch(Exception e){
			return;
		}
	}

	@Override
	public void displayCharacter() {
		// TODO Auto-generated method stub
		
	}
	
}
