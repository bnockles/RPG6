package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

import directors.Game;
import directors.Screen;


public class CharacterScreen extends Screen implements KeyListener{

	private static final int MOVE_UNIT = 10;
	String[] statNames = {"Health", "Attack", "Defense", "Mana", "Speed", "Drop Rate", "Crit Hit Chance", "CurrentExp"};
	String name;
	double[] stats;
	Hero hero;
	double maxHeath;
	boolean on = false;
	boolean wepOn = false;
	boolean armorOn = false;
	SampleWeapon sword;
	SampleArmor armor;
	SamplePotion potion;
	BufferedImage heroImg;
	BufferedImage icon;
	ArrayList<Integer> pressedKeys;
	
	public CharacterScreen(Game game) {
		super(game);
		hero = new Hero("The Hero", 100.0, 10.0, 10.0, 100.0, 5.0, 0, 5.0, 0);
		name = hero.getName();
		stats = hero.getAllStats();
		sword = new SampleWeapon("Sword", 10);
		armor = new SampleArmor("Armor", 50);
		potion = new SamplePotion("Potion", 10);
		maxHeath = hero.getHealth();
		pressedKeys = new ArrayList<Integer>();
		
		hero.addItem(sword);
		hero.addItem(armor);
		hero.addItem(potion);
		
		
		heroImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		try{
			java.net.URL url = getClass().getResource("/character/sample/hero.jpg"); 
			icon = ImageIO.read(url);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public synchronized void keyPressed(KeyEvent e) {
		//toggle menu
		if(on){
			if(e.getKeyCode()==KeyEvent.VK_Q){	
				System.out.println("Q2 was pressed");
				on = false;
				update();
				game.repaint();
			}
		}else{
			if(e.getKeyCode()==KeyEvent.VK_Q){	
				System.out.println("Q1 was pressed");
				on = true;
				update();
				game.repaint();
			}
		}
		
		//equip/dequip wep
		if(!wepOn){
			if(e.getKeyCode()==KeyEvent.VK_1){	
				wepOn = true;
				hero.removeItem(sword);
				hero.equipItem(sword);
				hero.setAttack(hero.getAttack() + sword.statBoost());
				stats = hero.getAllStats();
				update();
				game.repaint();
			}
		}else{
			if(e.getKeyCode()==KeyEvent.VK_1){	
				wepOn = false;
				hero.addItem(sword);
				hero.dequipItem(sword);
				hero.setAttack(hero.getAttack() - sword.statBoost());
				stats = hero.getAllStats();
				update();
				game.repaint();
			}
		}
		
		//equip/dequip armor
		if(!armorOn){
			if(e.getKeyCode()==KeyEvent.VK_2){	
				armorOn = true;
				hero.removeItem(armor);
				hero.equipItem(armor);
				hero.setDefense(hero.getDefense() + armor.statBoost());
				stats = hero.getAllStats();
				update();
				game.repaint();
			}
		}else{
			if(e.getKeyCode()==KeyEvent.VK_2){	
				armorOn = false;
				hero.addItem(armor);
				hero.dequipItem(armor);
				hero.setDefense(hero.getDefense() - armor.statBoost());
				stats = hero.getAllStats();
				update();
				game.repaint();
			}
		}

		//drink potion
		if(e.getKeyCode()==KeyEvent.VK_3){
			if(hero.getInvList().contains(potion)){
				hero.removeItem(potion);
				if(hero.getHealth() < maxHeath){
					hero.setHealth(hero.getHealth() + potion.heal());
					if(hero.getHealth() > maxHeath){
						hero.setHealth(maxHeath);
					}
				}
				stats = hero.getAllStats();
				update();
				game.repaint();
			}
		}
		
		//get potion
		if(e.getKeyCode()==KeyEvent.VK_4){	
			hero.addItem(potion);
			update();
			game.repaint();
		}
		
		//receive damage
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			hero.setHealth(hero.getHealth() - 10);
			if(hero.getHealth() <= 0){
				hero.setHealth(0);
			}
			stats = hero.getAllStats();
			update();
			game.repaint();
		}
		
		//movement
//        if(e.getKeyCode() == KeyEvent.VK_UP && e.getKeyCode() == KeyEvent.VK_LEFT){
//            hero.setY(hero.getY()+10);
//            hero.setX(hero.getX()+10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_UP && e.getKeyCode() == KeyEvent.VK_RIGHT){
//            hero.setY(hero.getY()+10);
//            hero.setX(hero.getX()-10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_DOWN && e.getKeyCode() == KeyEvent.VK_LEFT){
//            hero.setY(hero.getY()-10);
//            hero.setX(hero.getX()+10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_DOWN && e.getKeyCode() == KeyEvent.VK_RIGHT){
//            hero.setY(hero.getY()-10);
//            hero.setX(hero.getX()-10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_UP){
//            hero.setY(hero.getY()-10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
//            hero.setY(hero.getY()+10);
//            update();
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
//            hero.setX(hero.getX()-10);
//            update();
//            game.repaint();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//            hero.setX(hero.getX()+10);
//            update();
//            game.repaint();
//        }
		
		 int keyCode = e.getKeyCode();
		 if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			 if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		 }
		 if(!pressedKeys.isEmpty()){
			 hero.setWalking(true);
		 }
		 respondToKeyInput();
	}

	public void keyReleased(KeyEvent e) {
		 int keyCode = e.getKeyCode();
		 if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			 pressedKeys.remove(pressedKeys.indexOf(keyCode));
		 }
		 if(pressedKeys.isEmpty())hero.setWalking(false);
		 respondToKeyInput();
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) hero.setY(hero.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) hero.setY(hero.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) hero.setX(hero.getX() + MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) hero.setX(hero.getX() - MOVE_UNIT); 
	}
	
	public void paintScreen(Graphics2D g2){
		g2.setColor(Color.black);
		g2.drawString("This is the hero", 30, 75);
		g2.drawString("Press 'Q' to toggle stat menu", 30, 90);
		g2.drawString("Press '1' to equip/dequip weapon", 30, 105);
		g2.drawString("Press '2' to equip/dequip armor", 30, 120);
		g2.drawString("Press '3' to use potion", 30, 135);
//			g2.setColor(Cr.white)
//			g2.fillRect(0, 0, width, height);
//			g2.setColor(Color.black);
		
		//Stat menu
		if(on){
			int x = 50;
			int y = 150;
			g2.setColor(Color.black);	
			g2.drawString(name, x, y);

			for(int i = 0; i < stats.length; i++){
				y += 15;
				g2.drawString(statNames[i] + ": "+ stats[i], x, y);
			}
		}
		
		//Inventory
		int invX = 530;
		int invY = 75;
		g2.drawString("Inventory", invX, invY);
		for(int j = 0; j < hero.getInventory().length; j++){
			invY += 15;
			g2.drawString(hero.getInventory()[j] + "", invX, invY);
		}
		
		
		
		//Equiped
		int eqX = 730;
		int eqY = 75;
		g2.drawString("Equiped", eqX, eqY);
		for(int l = 0; l < hero.getEquiped().length; l++){
			eqY
			+= 15;
			g2.drawString(hero.getEquiped()[l] + "", eqX, eqY);
		}
		
		
		//display character
		//g2.drawImage(icon, hero.getX(), hero.getY(), null);
		
		hero.increaseCount();
		g2.drawImage(hero.getImage(),hero.getX(),hero.getY(),null);
	}
	
}
