package characters;


public abstract class Character {
	public String name;
	public double health;
	public double currHealth;
	public double attack;
	public double defense;
	public double mana;
	public double speed;
	public double dropRate;
	public double critHitChance;
	public double currentExp;
	
	public Character(String name, double health, double currHealth, double attack, double defense, double mana, double speed, double dropRate, double critHitChance, double currentExp){
		this.name = name;
		this.health = health;
		this.currHealth = currHealth;
		this.attack = attack;
		this.defense = defense;
		this.mana = mana;
		this.speed = speed;
		this.dropRate = dropRate;
		this.critHitChance = critHitChance;
		this.currentExp = currentExp;
	}

	public abstract void displayCharacter();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public double getCurrHealth() {
		return currHealth;
	}

	public void setCurrHealth(double currHealth) {
		this.currHealth = currHealth;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDropRate() {
		return dropRate;
	}

	public void setDropRate(double dropRate) {
		this.dropRate = dropRate;
	}

	public double getCritHitChance() {
		return critHitChance;
	}

	public void setCritHitChance(double critHitChance) {
		this.critHitChance = critHitChance;
	}

	public double getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(double currentExp) {
		this.currentExp = currentExp;
	}

	
	public double[] getAllStats(){
		double[] stats = {currHealth, attack, defense, mana, speed, dropRate, critHitChance, currentExp};
		return stats;		
	}
}
