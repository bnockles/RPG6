package items;

public class Character {

		private Stats trueStats;
		private Stats buffStats;
		
		private Equipment helmet;
		private Equipment chest;
		private Equipment leg;
		
		public Character(){
			this(1, 0, 0, 0, 0, 0, 0);
		}
		public Character(int level, int exp, int str, int dex, int iq, int wis, int luck){
			this.trueStats = new Stats(str, dex, iq, wis, luck);
			this.buffStats = new Stats(0, 0, 0, 0, 0);
		}
		//s
		
		public Stats getTrueStats(){
			return this.trueStats;
		}
		public Stats getBuffStats(){
			return this.buffStats;
		}
		public Equipment getHelmet(){ return this.helmet; }
		public Equipment getChest(){ return this.chest; }
		public Equipment getLeg(){ return this.leg; }
		
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
		}

}
