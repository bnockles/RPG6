
package characters;

import items.Equipment;
import items.Item;
import items.Stats;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.UtilityMethods;
	

public class Hero extends Character {
	int count;
	boolean walking = false;
	boolean front = true;
	boolean back = false;
	boolean right = false;
	boolean left = false;
	boolean hasWeapon = false;
	boolean hasArmor = false;
	ArrayList<Item> equipped;
	BufferedImage image;
	BufferedImage[] frames;
	String name;
	
	public Hero(String name, int level, double currHealth, double currMana, Stats stats){
		super(name, level, currHealth, currMana, stats);

			this.name = name;
			equipped = new ArrayList<Item>();
			
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
				image0=UtilityMethods.getScaledImage(origimage0,50,this.getCharHeight());
				image1=UtilityMethods.getScaledImage(origimage1,50,this.getCharHeight());
				image2=UtilityMethods.getScaledImage(origimage2,50,this.getCharHeight());
				image3=UtilityMethods.getScaledImage(origimage3,50,this.getCharHeight());
				image4=UtilityMethods.getScaledImage(origimage4,50,this.getCharHeight());
				image5=UtilityMethods.getScaledImage(origimage5,50,this.getCharHeight());
				image6=UtilityMethods.getScaledImage(origimage6,50,this.getCharHeight());
				image7=UtilityMethods.getScaledImage(origimage7,50,this.getCharHeight());
				image8=UtilityMethods.getScaledImage(origimage8,50,this.getCharHeight());
				image9=UtilityMethods.getScaledImage(origimage9,50,this.getCharHeight());
				image10=UtilityMethods.getScaledImage(origimage10,50,this.getCharHeight());
				image11=UtilityMethods.getScaledImage(origimage11,50,this.getCharHeight());
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

	public void setWalking(boolean walking) {
		this.walking = walking;
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


	public boolean isWalking() {
		return walking;
	}

	public boolean isFront() {
		return front;
	}

	public boolean isBack() {
		return back;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isLeft() {
		return left;
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
	public void interaction(Player player){
		if(!player.getParty().party.contains(this)){
			player.getParty().addMember(this);
		}
	}
	
	//Setters/getters for weapon and armor 
	public boolean isHasWeapon() {
		return hasWeapon;
	}

	public void setHasWeapon(boolean hasWeapon) {
		this.hasWeapon = hasWeapon;
	}

	public boolean isHasArmor() {
		return hasArmor;
	}

	public void setHasArmor(boolean hasArmor) {
		this.hasArmor = hasArmor;
	}
	
	public ArrayList<Item> getEquipped(){
		return equipped;
	}
	
	public void equip(Equipment equipment){
		equipped.add(equipment);
	}
	
	public void unequip(Equipment equipment){
		equipped.remove(equipment);
	}
}
