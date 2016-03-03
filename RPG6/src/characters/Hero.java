package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.UtilityMethods;
	

public class Hero extends Character {

	private static final int CHAR_HEIGHT = 200;
	int count;
	boolean walking = false;
	ArrayList<SampleItem> inventory;
	ArrayList<SampleItem> equiped;
	int x;
	int y;
	BufferedImage image;
	BufferedImage[] frames;
	
	public Hero(String name,
			double health, double attack, double defense, double mana,
			double speed, double dropRate, double critHitChance,
			double currentExp) {
		super(name, health, attack, defense, mana,
				speed, dropRate, critHitChance, currentExp);
		
			inventory = new ArrayList<SampleItem>();
			equiped = new ArrayList<SampleItem>();
			x = 200;
			y = 200;
			
			BufferedImage image0=null;
			BufferedImage image1=null;
			BufferedImage image2=null;
			try {
				BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/character/sample/hero1.png");
				BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/character/sample/hero2.png");
				BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/character/sample/hero3.png");
				//scale each image
				image0=UtilityMethods.getScaledImage(origimage0,100,CHAR_HEIGHT);
				image1=UtilityMethods.getScaledImage(origimage1,90,CHAR_HEIGHT);
				image2=UtilityMethods.getScaledImage(origimage2,90,CHAR_HEIGHT);
			} catch (IOException e) {
				//will throw Exception when files cannot be found
				e.printStackTrace();
			}
			frames = new BufferedImage[3];
			frames[0] = image0;
			frames[1] = image1;
			frames[2] = image2;
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
		if(walking && count < 5){
			sprite = frames[1];
		}else if (walking){
			sprite = frames[2];
		}
		return sprite; 
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
