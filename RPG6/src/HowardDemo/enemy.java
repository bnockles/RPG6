package HowardDemo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
//import items.Stats;
import HowardDemo.Stats;
//import characters.Character;
import HowardDemo.Character;

public class enemy extends Character{//implements EnemyTeam{
//	private String name;
//	private int level;
//	private double currHealth;
//	private double currMana;
//	private Stats stats;
    
	private int dropRate;
	private int exp;
	private int gold;
	static ArrayList<enemy> enemyList;

	public enemy(String name, int level, double currHealth, double currMana, Stats stats, int dropRate, int exp, int gold){
    	super(name, level, currHealth, 0, stats);
    	this.dropRate=dropRate;
    	this.exp = exp;
    	this.gold  = gold;
	}
    
	public static void allEnemies(){
		ArrayList<enemy> enemyList = new ArrayList<enemy>();
		
    	enemy rat = new enemy("Rat", 1, 30, 0, new Stats(30, 8, 3, 1), 30, 3, 1);
    	enemy cat = new enemy("Cat", 6, 55, 0, new Stats(55, 15, 5, 2), 29, 5, 3);
    	enemy slime = new enemy("Slime", 11, 105, 0, new Stats(105, 32, 10, 3), 27, 7, 5);    
    	enemy wraith = new enemy("Wraith", 16, 177, 0, new Stats(177, 58, 18, 5), 25, 11, 8);
    	enemy zombie = new enemy("Zombie", 21, 270, 0, new Stats(270, 95, 24, 7), 24, 13, 11);
    	enemy berserkStump = new enemy("Berserk Stump", 26, 382, 0, new Stats(382, 143, 36, 10), 20, 18, 15);
    	enemy fireBoar = new enemy("Fire Boar", 31, 513, 0, new Stats(513, 205, 69, 20), 19, 22, 19);
    	enemy golem = new enemy("Golem", 36, 663, 0, new Stats(663, 282, 84, 25), 17, 28, 24);
    	enemy werewolf = new enemy("Werewolf", 41, 830, 0, new Stats(830, 374, 100, 30), 15, 30, 29);
    	enemy centaur = new enemy("Centaur", 46, 1014, 0, new Stats(1014, 482, 127, 38), 13, 35, 35);
    	enemy griffin = new enemy("Griffin", 51, 1215, 0, new Stats(1215, 608, 160, 48), 11, 39, 41);
    	enemy gargoyle = new enemy("Gargoyle", 56, 1432, 0, new Stats(1432, 752, 200, 60), 10, 45, 48);
    	enemy rogue = new enemy("Rogue", 61, 1665, 0, new Stats(1665, 916, 297, 83), 9, 50, 55);
    	enemy mage = new enemy("Mage", 66, 1914, 0, new Stats(1914, 1101, 357, 107), 7, 60, 63);
    	enemy spartan = new enemy("Spartan", 71, 2179, 0, new Stats(2179,1307, 420, 126), 5, 70, 71);
    	enemy spearman = new enemy("Spearman", 76, 2459, 0, new Stats(2459, 1532, 524, 157), 5, 80, 80);
    	enemy wyvern = new enemy("Wyvern", 81, 2754, 0, new Stats(2754, 1790, 637, 191), 5, 80, 80);
    	enemy reaper = new enemy("Reaper", 86, 3065, 0, new Stats(3065, 2069, 720, 216), 5, 90, 99);
    	enemy homunculus = new enemy("Homunculus", 91, 3390, 0, new Stats(3390, 2373, 836, 250), 5, 95, 109);
    	enemy spider = new enemy("Spider", 100, 4011, 0, new Stats(4011, 3008, 1000, 300), 5, 100, 110);
   	 
    	enemyList.add(rat);
    	enemyList.add(cat);
    	enemyList.add(slime);
    	enemyList.add(wraith);
    	enemyList.add(zombie);
    	enemyList.add(berserkStump);
    	enemyList.add(fireBoar);
    	enemyList.add(golem);
    	enemyList.add(werewolf);
    	enemyList.add(centaur);
    	enemyList.add(griffin);
    	enemyList.add(gargoyle);
    	enemyList.add(rogue);
    	enemyList.add(mage);
    	enemyList.add(spartan);
    	enemyList.add(spearman);
    	enemyList.add(wyvern);
    	enemyList.add(reaper);
    	enemyList.add(homunculus);
    	enemyList.add(spider);
	}

	public static ArrayList<enemy> getEnemyList(){
		allEnemies();
    	return enemyList;
	}

	public enemy getEnemy(int index){
		return enemyList.get(index);
	}

	public Stats getStats(){
    	return this.getStats();
	}

	public int getDropRate(){
    	return this.dropRate;
	}

	public int getExp(){
    	return this.exp;
	}

	public int getGold(){
    	return this.gold;
	}

	public void updateEnemyInfo(double health, double attack, double defense, double speed){
    	this.setHealth(health);
    	this.setAttack(attack);
    	this.setDefense(defense);
    	this.setSpeed(speed);
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
