package items;

public final class ItemSandbox {
	public static TestChestArmor testChest = new TestChestArmor();
	public static TestPotion testPotion = new TestPotion(); 
}
//s


class TestChestArmor extends Equipment {
	public TestChestArmor(){
		super("test armor", "REQ: 12 STR.", CHEST, new Stats(0, 0, 0, 5));
	}
	
	@Override
	public boolean canUse(Character user) {
		return user.getTrueStats().getStrength() >= 12;
	}
}

class TestPotion extends Item {
	public TestPotion() {
		super("test potion", "HP+50");
	}

	@Override
	public boolean canUse(Character user) {
		return user.getBuffStats().getHealth() < user.getTrueStats().getHealth();
	}

	@Override
	public void use(Character user) {
		/*add health to stats*/
	}
	
}


class Character {
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
