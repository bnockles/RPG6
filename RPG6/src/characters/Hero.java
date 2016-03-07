package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.UtilityMethods;
	

public class Hero extends Character {

	private static final int CHAR_HEIGHT = 200;
	int count;
	boolean walking = false;
	boolean front = false;
	boolean back = false;
	boolean right = false;
	boolean left = false;
	ArrayList<SampleItem> inventory;
	ArrayList<SampleItem> equiped;
	int x;
	int y;
	BufferedImage image;
	BufferedImage[] frames;
	String name;
	
	public Hero(String name,
			double health, double currHealth, double attack, double defense, double mana,
			double currMana,double speed, double dropRate, double critHitChance,
			double currentExp) {
		super(name, health, currHealth, attack, defense, mana, currMana,
				speed, dropRate, critHitChance, currentExp);
		
			inventory = new ArrayList<SampleItem>();
			equiped = new ArrayList<SampleItem>();
			x = 200;
			y = 200;
			this.name = name;
			
			BufferedImage image0=null;
			BufferedImage image1=null;
			BufferedImage image2=null;
			BufferedImage image3=null;
			BufferedImage image4=null;
			BufferedImage image5=null;
			BufferedImage image6=null;
			BufferedImage image7=null;
			BufferedImage image8=null;
			BufferedImage image9=null;
			BufferedImage image10=null;
			BufferedImage image11=null;
			try {
				BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/character/sample/hero1" + name.toLowerCase() + ".png");
				BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/character/sample/hero2" + name.toLowerCase() + ".png");
				BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/character/sample/hero3" + name.toLowerCase() + ".png");
				BufferedImage origimage3 = UtilityMethods.getImageFromFile(this, "/character/sample/hero4" + name.toLowerCase() + ".png");
				BufferedImage origimage4 = UtilityMethods.getImageFromFile(this, "/character/sample/hero5" + name.toLowerCase() + ".png");
				BufferedImage origimage5 = UtilityMethods.getImageFromFile(this, "/character/sample/hero6" + name.toLowerCase() + ".png");
				BufferedImage origimage6 = UtilityMethods.getImageFromFile(this, "/character/sample/hero7" + name.toLowerCase() + ".png");
				BufferedImage origimage7 = UtilityMethods.getImageFromFile(this, "/character/sample/hero8" + name.toLowerCase() + ".png");
				BufferedImage origimage8 = UtilityMethods.getImageFromFile(this, "/character/sample/hero9" + name.toLowerCase() + ".png");
				BufferedImage origimage9 = UtilityMethods.getImageFromFile(this, "/character/sample/hero10" + name.toLowerCase() + ".png");
				BufferedImage origimage10 = UtilityMethods.getImageFromFile(this, "/character/sample/hero11" + name.toLowerCase() + ".png");
				BufferedImage origimage11 = UtilityMethods.getImageFromFile(this, "/character/sample/hero12" + name.toLowerCase() + ".png");
				//scale each image
				image0=UtilityMethods.getScaledImage(origimage0,50,CHAR_HEIGHT/3);
				image1=UtilityMethods.getScaledImage(origimage1,50,CHAR_HEIGHT/3);
				image2=UtilityMethods.getScaledImage(origimage2,50,CHAR_HEIGHT/3);
				image3=UtilityMethods.getScaledImage(origimage3,50,CHAR_HEIGHT/3);
				image4=UtilityMethods.getScaledImage(origimage4,50,CHAR_HEIGHT/3);
				image5=UtilityMethods.getScaledImage(origimage5,50,CHAR_HEIGHT/3);
				image6=UtilityMethods.getScaledImage(origimage6,50,CHAR_HEIGHT/3);
				image7=UtilityMethods.getScaledImage(origimage7,50,CHAR_HEIGHT/3);
				image8=UtilityMethods.getScaledImage(origimage8,50,CHAR_HEIGHT/3);
				image9=UtilityMethods.getScaledImage(origimage9,50,CHAR_HEIGHT/3);
				image10=UtilityMethods.getScaledImage(origimage10,50,CHAR_HEIGHT/3);
				image11=UtilityMethods.getScaledImage(origimage11,50,CHAR_HEIGHT/3);
			} catch (IOException e) {
				//will throw Exception when files cannot be found
				e.printStackTrace();
			}
			frames = new BufferedImage[12];
			frames[0] = image0;
			frames[1] = image1;
			frames[2] = image2;
			frames[3] = image3;
			frames[4] = image4;
			frames[5] = image5;
			frames[6] = image6;
			frames[7] = image7;
			frames[8] = image8;
			frames[9] = image9;
			frames[10] = image10;
			frames[11] = image11;
			//the following "count" variable is to keep track of which image is shown at any given time
			count = 0;
			
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

	public ArrayList getInvList(){
		return inventory;
	}
	
	
	public String[] getInventory(){
		String[] inv;
		try{
			inv = new String[inventory.size()];
			for(int i = 0; i < inventory.size(); i++){
				inv[i] = inventory.get(i).getName();
			}
		}catch(Exception e){
			String[] inv1 = {" "};
			return inv1; 
		}
		return inv;
	}
	
	public String[] getEquiped(){
		String[] eq;
		try{
			eq = new String[equiped.size()];
			for(int i = 0; i < equiped.size(); i++){
				eq[i] = equiped.get(i).getName();
			}
		}catch(Exception e){
			String[] eq1 = {" "};
			return eq1; 
		}
		return eq;
	}
	
	public void addItem(SampleItem item){		
			inventory.add(item);

	}
	
	public void removeItem(SampleItem item){
		try{
			inventory.remove(item);
		}catch(Exception e){
			return;
		}
	}
	
	public void equipItem(SampleItem item){
		try{
			equiped.add(item);
		}catch(Exception e){
			return;
		}
	}
	
	public void setWalking(boolean walking) {
		this.walking = walking;
	}

	public void dequipItem(SampleItem item){
		try{
			equiped.remove(item);
		}catch(Exception e){
			return;
		}
	}

	public BufferedImage getImage(){
		BufferedImage sprite = frames[0];
		if(back){
			sprite = frames[4];
		}else if(right){
			sprite = frames[5];
		}else if(left){
			sprite = frames[3];
		}

		//front
		if(front && walking && count < 5){
			sprite = frames[1];
		}else if (front && walking){
			sprite = frames[2];
		}
		
		//back
		if(back && walking && count < 5){
			sprite = frames[6];
		}else if (back && walking){
			sprite = frames[7];
		}
		
		//right
		if(right && walking && count < 5){
			sprite = frames[10];
		}else if (right && walking){
			sprite = frames[11];
		}
		
		//left
		if(left && walking && count < 5){
			sprite = frames[8];
		}else if (left && walking){
			sprite = frames[9];
		}
		
		return sprite; 
	}


	public void setFront(boolean front) {
		this.front = front;
	}

	public void setBack(boolean back) {
		this.back = back;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void increaseCount(){
		count++;
		if(count>10)count=0;
	}

	@Override
	public void displayCharacter() {
		// TODO Auto-generated method stub
		
	}
	
}
