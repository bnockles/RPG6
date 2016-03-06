package items;

public class Character {

		private Stats trueStats;
		public String name;
		public String type;
		
		private Equipment helmet;
		private Equipment chest;
		private Equipment leg;
		public Equipment shoes;
		public Equipment weapon;
		
		public Character(int level, int exp, Stats stats, String name, String type){
			this.trueStats = stats;
			this.name = name;
			this.type = type;
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
			if(armor.getType() == Equipment.HELMET){
				this.helmet = armor;
			}
			else if(armor.getType() == Equipment.CHEST){
				this.chest = armor;
			}
			else if(armor.getType() == Equipment.LEG){
				this.leg = armor;
			}
			else if(armor.getType() == Equipment.SHOE){
				shoes = armor;
			}
			else if (armor.getType() == Equipment.WEAPON){
				weapon = armor;
			}
		}

}
