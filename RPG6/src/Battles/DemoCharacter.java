package Battles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DemoCharacter implements BattleCharacters {
	
	private String name;
	private int x;
	private int y;   
	private int totalHealth;
	private int currentHealth;
	private int totalMana;
	private int currentMana;
	private int armor;
	private int magicResist;
	private int attackPower;
	private int magicPower;
	private int exp = 10000;
	private ArrayList<Items> bag;
	private ArrayList<Move> physicalAttacks;
	private ArrayList<Move> magicalAttacks;
	private int speed;
	private String imagePath;
	
	public DemoCharacter(String name,int hp,int mp,int armor,int mr,int ad,int ap,int spd,String filePath){
		
		this.name = name;
		this.totalHealth = hp;
		this.currentHealth = hp;
		this.totalMana = mp;
		this.currentMana = mp;
		this.armor = armor;
		this.magicResist = mr;
		this.magicPower = ap;
		this.attackPower = ad;
		this.speed = spd;
		this.imagePath = filePath;
		
	}
	
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.totalHealth;
	}
	public int getCurrHp() {
		return this.currentHealth;
	}
	public int getMp() {
		return this.totalMana;
	}
	public int getCurrMp() {
		return this.currentMana;
	}
	public int getAttack() {
		return this.attackPower;
	}
	public int getDefense() {
		return this.armor;
	}
	public int getStrength() {
		return 0;
	}
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
	public int getDexterity() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getIntelligence() {
		// TODO Auto-generated method stub
		return this.magicPower;
	}
	public int getWisdom() {
		// TODO Auto-generated method stub
		return this.magicResist;
	}
	public int getLuck() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getCurrExp() {
		// TODO Auto-generated method stub
		return this.exp;
	}
	public int getExpNeededToLevel() {
		// TODO Auto-generated method stub
		return 10000;
	}
	public void flee() {
		// TODO Auto-generated method stub
		
	}
	public String getImageFilepath() {
		// TODO Auto-generated method stub
		return this.imagePath;
	}
	public void updateCharacterInfo(int currHp, int currMp) {
		this.currentHealth = currHp;
		this.currentMana = this.getCurrMp();
		
	}
	public void setStats(int ad,int def,int spd){
		this.attackPower = ad;
		this.armor = def;
		this.speed = spd;
	}
	public void setExp(int exp){
		this.exp = exp;
	}

	
	
//	public DemoCharacter(String img,int horizontal,int vertical,ArrayList<Integer>charInfo,ArrayList<String>giveMovesM,ArrayList<String>giveMovesS, String name){
//		this.title = name;
////		this.meleeMoves.addAll(giveMovesM);
////		this.spellMoves.addAll(giveMovesS);
////		this.stats.addAll(charInfo);
//		this.x = horizontal;
//		this.y = vertical;
//		image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
////		System.out.println("The image being printed is: "+img);
//		URL url = getClass().getResource(img);
////		System.out.println(url);
//		try {
//			BufferedImage original = ImageIO.read(url);
//			
//			
//			Graphics2D g = (Graphics2D) image.getGraphics();
//			int w = original.getWidth();
//			int h = original.getHeight();
//			
//			
//			g.drawImage(original,0,0,300,250,0,0,w,h,null);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	}
//	public BufferedImage getImage() {
//		return image;
//	}
//	public void setImage(BufferedImage image) {
//		this.image = image;
//	}
}
