package Battles.WilsonDemo;

import java.util.ArrayList;


public class DemoCharacter implements BattleCharacters {
	
	private String name;   
	private int hp;
	private int currHp;
	private int mp;
	private int currMp;
	private int attack;
	private int defense;
	private int strength;
	private int speed;
	private int dexterity;
	private int wisdom;
	private int intelligence;
	private int luck;
	private int currExp;
	private int expNeededToLevel;
	private ArrayList<Item> inventory;
	private ArrayList<Skill> skills;
	private String imageFilepath;
	
	
	
	public DemoCharacter(String name, int hp, int mp, int attack, int defense, int strength, int speed, int dexterity,
			int wisdom, int intelligence, int luck, String imageFilepath) {
		this.name = name;
		this.hp = hp;
		this.currHp = hp;
		this.mp = mp;
		this.currMp = mp;
		this.attack = attack;
		this.defense = defense;
		this.strength = strength;
		this.speed = speed;
		this.dexterity = dexterity;
		this.wisdom = wisdom;
		this.intelligence = intelligence;
		this.luck = luck;
		this.currExp = 0;
		this.expNeededToLevel = 1000;
		this.imageFilepath = imageFilepath;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getCurrHp() {
		return currHp;
	}

	public int getMp() {
		return mp;
	}

	public int getCurrMp() {
		return currMp;
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

	public int getSpeed() {
		return speed;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getLuck() {
		return luck;
	}

	public int getCurrExp() {
		return currExp;
	}

	public int getExpNeededToLevel() {
		return expNeededToLevel;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public String getImageFilepath() {
		return imageFilepath;
	}
	
	public void flee() {
		
	}

	public void updateCharacterInfo(int currHp, int currMp, int exp) {
		this.currHp = currHp;
		this.currMp = currMp;
		this.currExp += exp;
		if(currExp > expNeededToLevel){
			levelUp();
		}
	}
	
	public void levelUp(){
		
	}
	
}
