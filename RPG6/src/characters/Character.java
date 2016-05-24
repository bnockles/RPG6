package characters;


import items.Equipment;
import items.Item;
import items.Stats;

import java.awt.image.BufferedImage;


public abstract class Character {
	public static final int CHAR_HEIGHT = 200;
	public String name;
	public int level;
	public double currHealth;
	public double currMana;
	public Stats stats;
	int x;
	int y;
	
	public Character(String name, int level, double currHealth, double currMana, Stats stats){
		this.level = level;
		this.name = name;
		this.currHealth = currHealth;
		this.currMana = currMana;
		this.stats = stats;
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

	public double getCurrHealth() {
		return currHealth;
	}

	public void setCurrHealth(double currHealth) {
		this.currHealth = currHealth;
	}

	public double getCurrMana() {
		return currMana;
	}
	
	public void setCurrMana(double currMana) {
		this.currMana = currMana;
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
	
	public Stats getStats(){
		return stats;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void addEquipStats(Item sword){
		Stats eStats = ((Equipment) sword).getStats();
		this.stats.setHealth(this.stats.getHealth() + eStats.getHealth());
		this.stats.setMana(this.stats.getMana() + eStats.getMana());
		this.stats.setAttack(this.stats.getAttack() + eStats.getAttack());
		this.stats.setDefense(this.stats.getDefense() + eStats.getDefense());
		this.stats.setSpeed(this.stats.getSpeed() + eStats.getSpeed());
		this.stats.setStrength(this.stats.getStrength() + eStats.getStrength());
		this.stats.setDexterity(this.stats.getDexterity() + eStats.getDexterity());
		this.stats.setIntelligence(this.stats.getIntelligence() + eStats.getIntelligence());
		this.stats.setWisdom(this.stats.getWisdom() + eStats.getWisdom());
		this.stats.setLuck(this.stats.getLuck() + eStats.getLuck());
		
	}
	
	public void removeEquipStats(Item sword){
		Stats eStats = ((Equipment) sword).getStats();
		this.stats.setHealth(this.stats.getHealth() - eStats.getHealth());
		this.stats.setMana(this.stats.getMana() - eStats.getMana());
		this.stats.setAttack(this.stats.getAttack() - eStats.getAttack());
		this.stats.setDefense(this.stats.getDefense() - eStats.getDefense());
		this.stats.setSpeed(this.stats.getSpeed() - eStats.getSpeed());
		this.stats.setStrength(this.stats.getStrength() - eStats.getStrength());
		this.stats.setDexterity(this.stats.getDexterity() - eStats.getDexterity());
		this.stats.setIntelligence(this.stats.getIntelligence() - eStats.getIntelligence());
		this.stats.setWisdom(this.stats.getWisdom() - eStats.getWisdom());
		this.stats.setLuck(this.stats.getLuck() - eStats.getLuck());
		
	}
	
}
