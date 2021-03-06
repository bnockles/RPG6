package items;

public final class ItemSandbox {
	//debug and testing
//	private static Item ca = new TestChestArmor().register();
//	private static Item tp = new TestPotion().register(); 
//	
//	public static Inventory inv = new Inventory();
//	
//	static {
//		inv.addStock(ca.getId());
//		inv.addStock(tp.getId(),2);
//	}
}
//s


class TestChestArmor extends Equipment {
	public TestChestArmor(){
		super("TestChestArmor", "test armor", "REQ: 12 STR.", CHEST, new Stats(0, 0, 0, 5), 100);
	}
	
	@Override
	public boolean canUse(Character user) {
		return user.getTrueStats().getStrength() >= 12;
	}
}

class TestPotion extends Item {
	public TestPotion() {
		super("TestChestArmor", "test potion", "HP+50");
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


//class Character {
//	private Stats trueStats;
//	private Stats buffStats;
//	
//	private Equipment helmet;
//	private Equipment chest;
//	private Equipment leg;
//	
//	public Character(){
//		this(1, 0, 0, 0, 0, 0, 0);
//	}
//	public Character(int level, int exp, int str, int dex, int iq, int wis, int luck){
//		this.trueStats = new Stats(str, dex, iq, wis, luck);
//		this.buffStats = new Stats(0, 0, 0, 0, 0);
//	}
//	
//	
//	public Stats getTrueStats(){
//		return this.trueStats;
//	}
//	public Stats getBuffStats(){
//		return this.buffStats;
//	}
//	public Equipment getHelmet(){ return this.helmet; }
//	public Equipment getChest(){ return this.chest; }
//	public Equipment getLeg(){ return this.leg; }
//	
//	public void equip(Equipment armor){
//		if(armor.getType() == Equipment.HELMET){
//			this.helmet = armor;
//		}
//		else if(armor.getType() == Equipment.CHEST){
//			this.chest = armor;
//		}
//		else if(armor.getType() == Equipment.LEG){
//			this.leg = armor;
//		}
//	}
//}
