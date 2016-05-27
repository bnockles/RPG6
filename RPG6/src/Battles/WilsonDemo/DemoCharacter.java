package Battles.WilsonDemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;


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
	private BufferedImage portrait;
	
	
	
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
		
		this.portrait = new BufferedImage(96, 96, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageFilepath);
		try {
			BufferedImage original = ImageIO.read(url);
			
			Graphics2D g = (Graphics2D) portrait.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original,0,0,96,96,0,0,w,h,null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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

	public BufferedImage getImageFilepath() {
		return portrait;
	}

	
	public void levelUp(){
		
	}

	public void updateCharacterHPandMP(int currHp, int currMp) {
		this.currHp = currHp;
		this.currMp = currMp;
	}
	
}
