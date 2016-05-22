package characters;

import static characters.Character.CHAR_HEIGHT;

import java.awt.image.BufferedImage;


public abstract class Character {
	public static final int CHAR_HEIGHT = 200;
	public String name;
	public double health;
	public double currHealth;
	public double mana;
	public double currMana;
	public double attack;
	public double defense;
	public double speed;
	public double dropRate;
	public double critHitChance;
	public double currentExp;
	int x;
	int y;
	
	public Character(String name, double health, double currHealth,  double attack, double defense, double mana, double currMana,double speed, double dropRate, double critHitChance, double currentExp){
		this.name = name;
		this.health = health;
		this.currHealth = currHealth;
		this.mana = mana;
		this.currMana = currMana;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.dropRate = dropRate;
		this.critHitChance = critHitChance;
		this.currentExp = currentExp;
		x = 200;
		y = 200;
	}

	public abstract void interaction(Player player);
	
	public abstract BufferedImage getImage();
	
	public int getCharHeight(){
		return CHAR_HEIGHT/3;
	}
	
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
	
	public double getCurrMana() {
		return currMana;
	}
	
	public void setCurrMana(double currMana) {
		this.currMana = currMana;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double[] getAllStats(){
		double[] stats = {currHealth, attack, defense, currMana, speed, dropRate, critHitChance, currentExp};
		return stats;		
	}
}
