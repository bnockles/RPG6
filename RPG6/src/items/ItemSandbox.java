package items;

public final class ItemSandbox {

	public static void main(String[] args) {
		
	}

}


class TestArmor extends Equipment {
	public TestArmor(){
		super("test armor", "armor for demo");
	}
	
	
	@Override
	public boolean canUse(Character user) {
		return user.getTrueStats().getStrength() >= 12;
	}
}


class Character {
	private Stats trueStats;
	private Stats buffStats;
	
	public Character(){
		this(1, 0, 0, 0, 0, 0, 0);
	}
	public Character(int level, int exp, int str, int dex, int iq, int wis, int luck){
		this.trueStats = new Stats(level, exp, str, dex, iq, wis, luck);
	}
	
	
	public Stats getTrueStats(){
		return this.trueStats;
	}
	public Stats getBuffStats(){
		return this.buffStats;
	}
}


class Stats {
	private int level;
	private int experience;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int wisdom;
	private int luck;
	
	
	public Stats(){
		this(0, 0, 0, 0, 0);
	}
	public Stats(int str, int dex, int iq, int wis, int luck){
		this(1, 0, str, dex, iq, wis, luck);
	}
	public Stats(int level, int exp, int str, int dex, int iq, int wis, int luck){
		this.level 			= level;
		this.experience 	= exp;
		this.strength		= str;
		this.dexterity 		= dex;
		this.intelligence 	= iq;
		this.wisdom 		= wis;
		this.luck 			= luck;
	}
	

	public int getLevel() {
		return level;
	}
	public int getExperience() {
		return experience;
	}
	public int getStrength() {
		return strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public int getLuck() {
		return luck;
	}
}