package items;

import java.util.ArrayList;

public class Character implements CharacterInterface{

		private Stats trueStats;
//		private int currentHP;
//		private int currentMP; //for further implementations later on
		public String name;
		public String type;
		private ArrayList<Item> inventory;
		private int money;
		
		private Equipment helmet;
		private Equipment chest;
		private Equipment leg;
		public Equipment shoes;
		public Equipment weapon;
		
		public Character(int level, int exp, Stats stats, String name, String type, ArrayList<Item> inventory, int money){
			this.trueStats = stats;
			this.name = name;
			this.type = type;
			this.inventory = inventory;
			this.money = money;
		}
		
		public ArrayList<Item> getInventory(){
			return this.inventory;
		}
		public Stats getTrueStats(){
			return this.trueStats;
		}
		public Equipment getHelmet(){ return this.helmet; }
		public Equipment getChest(){ return this.chest; }
		public Equipment getLeg(){ return this.leg; }
		public Equipment getWeapon() { return weapon; }
		public Equipment getShoes() { return shoes; }
		public String getName() { return this.name; }
		public String getType() { return this.type; }
		public void equip(Equipment armor){
			if(armor.getTypeOf() == Equipment.HELMET){
				this.helmet = armor;
			}
			else if(armor.getTypeOf() == Equipment.CHEST){
				this.chest = armor;
			}
			else if(armor.getTypeOf() == Equipment.LEG){
				this.leg = armor;
			}
			else if(armor.getTypeOf() == Equipment.SHOE){
				shoes = armor;
			}
			else if (armor.getTypeOf() == Equipment.WEAPON){
				weapon = armor;
			}
		}


		public int getPlayerCurrency() {
			return this.money;
		}

}
