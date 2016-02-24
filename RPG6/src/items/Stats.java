package items;

public final class Stats {
	//direct statss
	private int health;
	private int mana;
	private int attack;
	private int defense;
	//indirect stats
	private int strength;
	private int dexterity;
	private int intelligence;
	private int wisdom;
	private int luck;
	
	
	public Stats(){
		this(0, 0, 0, 0, 0);
	}
	public Stats(int hp, int mp, int atk, int def){
		this(hp, mp, atk, def, 0, 0, 0, 0, 0);
	}
	public Stats(int str, int dex, int iq, int wis, int luck){
		this(0, 0, 0, 0, str, dex, iq, wis, luck);
	}
	public Stats(int hp, int mp, int atk, int def, int str, int dex, int iq, int wis, int luck){
		this.health 		= hp;
		this.mana 			= mp;
		this.attack 		= atk;
		this.defense 		= def;
		
		this.strength		= str;
		this.dexterity 		= dex;
		this.intelligence 	= iq;
		this.wisdom 		= wis;
		this.luck 			= luck;
	}

	public String toString(){
		return 	"HP+" + this.health +
				" MP+" + this.mana +
				" ATK+" + this.attack +
				" DEF+" + this.defense +
				" STR+" + this.strength +
				" DEX+" + this.dexterity +
				" INT+" + this.intelligence +
				" WIS+" + this.wisdom +
				" LCK+" + this.luck;
	}

	public int getHealth() {
		return health;
	}
	public int getMana() {
		return mana;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
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

