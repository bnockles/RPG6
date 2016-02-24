package characters;


public abstract class Character {
	public String name;
	public String race;
	public String jobClass;
	public String gender;
	public double health;
	public double attack;
	public double defense;
	public double mana;
	public double speed;
	public double dropRate;
	public double critHitChance;
	public double currentExp;
	public double expNeededToLevel;
	
	public Character(String name, String race, String jobClass, String gender, double health, double attack, double defense, double mana, double speed, double dropRate, double critHitChance, double currentExp, double expNeededToLevel){
		this.name = name;
		this.race = race;
		this.jobClass = jobClass;
		this.gender = gender;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.mana = mana;
		this.speed = speed;
		this.dropRate = dropRate;
		this.critHitChance = critHitChance;
		this.currentExp = currentExp;
		this.expNeededToLevel = expNeededToLevel;	
	}

	public abstract void displayCharacter();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHealth() {
		return health;
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

	public double getExpNeededToLevel() {
		return expNeededToLevel;
	}

	public void setExpNeededToLevel(double expNeededToLevel) {
		this.expNeededToLevel = expNeededToLevel;
	}
}
