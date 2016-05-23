package items;

public class Stats {
	//direct statss
	private int health;
	private int mana;
	private int attack;
	private int defense;
	private int speed;
	//indirect stats
	private int strength;
	private int dexterity;
	private int intelligence;
	private int wisdom;
	private int luck;
	
	
	public Stats(){
		this(0, 0, 0, 0, 0);
	}
	public Stats(int hp, int atk){//minions
		this(hp, 0, atk, 0, 0, 0, 0, 0, 0, 0);
	}
	public Stats(int hp, int mp, int atk, int def){
		this(hp, mp, atk, def, 0, 0, 0, 0, 0, 0); //stats for enemies
	}
	public Stats(int str, int dex, int iq, int wis, int luck){
		this(0, 0, 0, 0, 0, str, dex, iq, wis, luck); //stats for armor
	}
	public Stats(int atk, int str, int dex, int iq, int wis, int luck){
		this(0, 0, atk, 0, 0, str, dex, iq, wis ,luck); //stats for weapons
	}
	public Stats(int def, int hp, int str, int dex, int iq, int wis, int luck){
		this(hp, 0, 0, def, 0, str, dex, iq, wis, luck); //stats for shields
	}
	public Stats(int hp, int mp, int atk, int def, int spd, int str, int dex, int iq, int wis, int luck){ //characters + bosses
		this.health 		= hp;
		this.mana 			= mp;
		this.attack 		= atk;
		this.defense 		= def;
		this.speed          = spd;
		
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
				" SPD+" + this.speed +
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
	public int getSpeed() {
		return speed;
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
	public void setAttack(int attack){
		this.attack = attack;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public void Wisdom(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
}