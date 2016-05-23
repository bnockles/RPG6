package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;


public class CharacterScreen extends Screen implements KeyListener{
	private static final int MOVE_UNIT = 5;
	String[] statNames = {"Health", "Attack", "Defense", "Mana", "Speed", "Drop Rate", "Crit Hit Chance", "CurrentExp"};
	String name;
	boolean npcDialogue;
	double[] stats;
	Player player;
	/*Hero player = new Hero(); <-- player
	 * 	declared type = player
	 * 	actual type = player
	 *	can use Character.getStats(); since is a player and player is a character
	 *	can use Hero.getInventory(); since is a player
	*Character player = new Hero(); <-- character
	*	declared type = character
	*	actual type player
	*	can use Character.getStats(); since is a character
	*	cannot use Hero.getInventory(); since is a character but not a player
	*	
	*(Hero)player 
	*	declared type = player
	*	actual type = player
	*/
	BufferedImage bg;
	CharacterList list;
	Npc npc;
	Enemy enemy;
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	Hero hero2;
	Hero hero3;
	Hero selectedHero;
	double maxHeath;
	double maxMana;
	boolean on = false;
	boolean wepOn = false;
	boolean wepOn2 = false;
	boolean armorOn = false;
	boolean armorOn2 = false;
	SampleWeapon sword;
	SampleWeapon sword2;
	SampleArmor armor;
	SampleArmor armor2;
	SamplePotion potion;
	SamplePotion potion2;
	BufferedImage heroImg;
	BufferedImage icon;
	ArrayList<Integer> pressedKeys;
	int heroNum = 1;
	String dialogue;
	
	public CharacterScreen(Game game) {
		super(game);
		try {
			bg = UtilityMethods.getImageFromFile(this, "/character/sample/bg.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		player = new Player("Link", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		hero2 = HeroTeam.getHero(HeroTeam.KNIGHT);
		hero3 = HeroTeam.getHero(HeroTeam.ADVENTURER);
		enemy = new Enemy("Reaper", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		enemy1 = new Enemy("Reaper", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		enemy2 = new Enemy("Reaper", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		enemy3 = new Enemy("Reaper", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		npc = new Npc("Billy", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		list = new CharacterList();
		npc.setX(600);
		npc.setY(450);
		hero2.setX(200);
		hero3.setY(500);
		enemy.setX(600);
		enemy.setY(100);
		enemy1.setX(400);
		enemy1.setY(400);
		enemy2.setX(800);
		enemy2.setY(500);
		enemy3.setX(500);
		enemy3.setY(200);
		npcDialogue = false;
		list.addCharacter(player);
		list.addCharacter(hero2);
		list.addCharacter(hero3);
		list.addCharacter(enemy);
		list.addCharacter(enemy1);
		list.addCharacter(enemy2);
		list.addCharacter(enemy3);
		list.addCharacter(npc);
		selectedHero = player;
		name = selectedHero.getName();
		stats = selectedHero.getAllStats();
		sword = new SampleWeapon("Sword", 10);
		sword2 = new SampleWeapon("Better Sword", 50);
		armor = new SampleArmor("Armor", 50);
		armor2 = new SampleArmor("Better Armor", 100);
		potion = new SamplePotion("HP Potion", 10);
		potion2 = new SamplePotion("MP Potion", 10);
		maxHeath = selectedHero.getHealth();
		maxMana = selectedHero.getMana();
		pressedKeys = new ArrayList<Integer>();
		dialogue = "";
		
//		player.addItem(sword);
//		player.addItem(sword2);
//		player.addItem(armor);
//		player.addItem(armor2);
//		player.addItem(potion);
//		player.addItem(potion2);
//		hero2.addItem(sword);
//		hero2.addItem(sword2);
//		hero2.addItem(armor);
//		hero2.addItem(armor2);
//		hero2.addItem(potion);
//		hero2.addItem(potion2);
//		hero3.addItem(sword);
//		hero3.addItem(sword2);
//		hero3.addItem(armor);
//		hero3.addItem(armor2);
//		hero3.addItem(potion);
//		hero3.addItem(potion2);
		
		
//		heroImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//		try{
//			java.net.URL url = getClass().getResource("/character/sample/player.jpg"); 
//			icon = ImageIO.read(url);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

	public synchronized void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E){	
			for(int i = 1; i < list.characters.size(); i++){
				if(!player.getParty().party.contains(list.characters.get(i))){
					if(Math.abs(list.characters.get(i).getX() - player.getX()) < 100 &&
							Math.abs(list.characters.get(i).getY() - player.getY()) < 100){
						System.out.println(list.characters.get(i).getName());
						list.characters.get(i).interaction(player);
						if(list.characters.get(i).getClass() == Npc.class){
								npcDialogue = ((Npc) list.characters.get(i)).isDialogue();
								dialogue = ((Npc) list.characters.get(i)).getDialogue();
						}
					}
				}
			}
			
		}
		
		
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			heroNum++;
			if(heroNum > 3){
				heroNum = 1;
			}
			if(heroNum == 1){
				selectedHero = player;
			}else if(heroNum == 2){
				selectedHero = hero2;
			}else if(heroNum == 3){
				selectedHero = hero3;
			}
			name = selectedHero.getName();
			stats = selectedHero.getAllStats();
			update();
			game.repaint();
		}
//		//toggle menu
//		if(on){
//			if(e.getKeyCode()==KeyEvent.VK_Q){	
//				on = false;
//				update();
//				game.repaint();
//			}
//		}else{
//			if(e.getKeyCode()==KeyEvent.VK_Q){
//				on = true;
//				update();
//				game.repaint();
//			}
//		}
//		
//		if(!wepOn){
//			if(e.getKeyCode()==KeyEvent.VK_1 && selectedHero.isHasWeapon()==false){	
//				wepOn = true;
//				selectedHero.setHasWeapon(true);
//				selectedHero.removeItem(sword);
//				selectedHero.equipItem(sword);
//				selectedHero.setAttack(selectedHero.getAttack() + sword.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}else{
//			if(e.getKeyCode()==KeyEvent.VK_1){	
//				wepOn = false;
//				selectedHero.setHasWeapon(false);
//				selectedHero.addItem(sword);
//				selectedHero.dequipItem(sword);
//				selectedHero.setAttack(selectedHero.getAttack() - sword.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//		
//		//equip/dequip wep
//		if(!wepOn2){
//			if(e.getKeyCode()==KeyEvent.VK_2 && selectedHero.isHasWeapon()==false){	
//				wepOn2 = true;
//				selectedHero.setHasWeapon(true);
//				selectedHero.removeItem(sword2);
//				selectedHero.equipItem(sword2);
//				selectedHero.setAttack(selectedHero.getAttack() + sword2.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}else{
//			if(e.getKeyCode()==KeyEvent.VK_2){	
//				wepOn2 = false;
//				selectedHero.setHasWeapon(false);
//				selectedHero.addItem(sword2);
//				selectedHero.dequipItem(sword2);
//				selectedHero.setAttack(selectedHero.getAttack() - sword2.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//		
//		
//		//equip/dequip armor
//		if(!armorOn){
//			if(e.getKeyCode()==KeyEvent.VK_3 && selectedHero.isHasArmor()==false){	
//				armorOn = true;
//				selectedHero.setHasArmor(true);
//				selectedHero.removeItem(armor);
//				selectedHero.equipItem(armor);
//				selectedHero.setDefense(selectedHero.getDefense() + armor.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}else{
//			if(e.getKeyCode()==KeyEvent.VK_3){	
//				armorOn = false;
//				selectedHero.setHasArmor(false);
//				selectedHero.addItem(armor);
//				selectedHero.dequipItem(armor);
//				selectedHero.setDefense(selectedHero.getDefense() - armor.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//		
//		if(!armorOn2){
//			if(e.getKeyCode()==KeyEvent.VK_4 && selectedHero.isHasArmor()==false){	
//				armorOn2 = true;
//				selectedHero.setHasArmor(true);
//				selectedHero.removeItem(armor2);
//				selectedHero.equipItem(armor2);
//				selectedHero.setDefense(selectedHero.getDefense() + armor2.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}else{
//			if(e.getKeyCode()==KeyEvent.VK_4){	
//				armorOn2 = false;
//				selectedHero.setHasArmor(false);
//				selectedHero.addItem(armor2);
//				selectedHero.dequipItem(armor2);
//				selectedHero.setDefense(selectedHero.getDefense() - armor2.statBoost());
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//
//		//drink potion
//		if(e.getKeyCode()==KeyEvent.VK_5){
//			if(selectedHero.getInvList().contains(potion)){
//				maxHeath = selectedHero.getHealth();
//				selectedHero.removeItem(potion);
//				if(selectedHero.getCurrHealth() < maxHeath){
//					selectedHero.setCurrHealth(selectedHero.getCurrHealth() + potion.heal());
//					if(selectedHero.getCurrHealth() > maxHeath){
//						selectedHero.setCurrHealth(maxHeath);
//					}
//				}
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//		
//		//get potion
//		if(e.getKeyCode()==KeyEvent.VK_6){	
//			selectedHero.addItem(potion);
//			update();
//			game.repaint();
//		}
//		
//		if(e.getKeyCode()==KeyEvent.VK_7){
//			if(selectedHero.getInvList().contains(potion2)){
//				maxHeath = selectedHero.getMana();
//				selectedHero.removeItem(potion2);
//				if(selectedHero.getCurrMana() < maxMana){
//					selectedHero.setCurrMana(selectedHero.getCurrMana() + potion.heal());
//					if(selectedHero.getCurrMana() > maxMana){
//						selectedHero.setCurrMana(maxMana);
//					}
//				}
//				stats = selectedHero.getAllStats();
//				update();
//				game.repaint();
//			}
//		}
//		
//		//get mana pot
//		if(e.getKeyCode()==KeyEvent.VK_8){	
//			selectedHero.addItem(potion2);
//			update();
//			game.repaint();
//		}
		
		//receive damage
		if(e.getKeyCode()==KeyEvent.VK_F){
			selectedHero.setCurrHealth(selectedHero.getCurrHealth() - 10);
			if(selectedHero.getCurrHealth() <= 0){
				selectedHero.setCurrHealth(0);
			}
			stats = selectedHero.getAllStats();
			update();
			game.repaint();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_G){
			selectedHero.setCurrMana(selectedHero.getCurrMana() - 10);
			if(selectedHero.getCurrMana() <= 0){
				selectedHero.setCurrMana(0);
			}
			stats = selectedHero.getAllStats();
			update();
			game.repaint();
		}
		
		 int keyCode = e.getKeyCode();
		 if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			 if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
			 if(keyCode == KeyEvent.VK_UP){
				 for(int i = 1; i < player.getParty().party.size(); i++){
					 if((Math.abs(player.getParty().party.get(i).getX() - player.getParty().party.get(i-1).getX()) <= 5) &&
						player.getParty().party.get(i-1).getY() <= player.getParty().party.get(i).getY() - player.getCharHeight()){
							player.getParty().party.get(i).setFront(player.getParty().party.get(i-1).isFront());
							player.getParty().party.get(i).setBack(player.getParty().party.get(i-1).isBack());
							player.getParty().party.get(i).setRight(player.getParty().party.get(i-1).isRight());
							player.getParty().party.get(i).setLeft(player.getParty().party.get(i-1).isLeft());
					 }
				 }
				 player.getParty().party.get(0).setFront(false);
				 player.getParty().party.get(0).setBack(true);
				 player.getParty().party.get(0).setRight(false);
				 player.getParty().party.get(0).setLeft(false);		
			 }else if(keyCode == KeyEvent.VK_DOWN){
				 for(int i = 1; i < player.getParty().party.size(); i++){
					 if((Math.abs(player.getParty().party.get(i).getX() - player.getParty().party.get(i-1).getX()) <= 5) &&		 
						player.getParty().party.get(i-1).getY() >= player.getParty().party.get(i).getY() + player.getCharHeight()){
							player.getParty().party.get(i).setFront(player.getParty().party.get(i-1).isFront());
							player.getParty().party.get(i).setBack(player.getParty().party.get(i-1).isBack());
							player.getParty().party.get(i).setRight(player.getParty().party.get(i-1).isRight());
							player.getParty().party.get(i).setLeft(player.getParty().party.get(i-1).isLeft());
					 }
				 }
				 player.getParty().party.get(0).setFront(true);
				 player.getParty().party.get(0).setBack(false);
				 player.getParty().party.get(0).setRight(false);
				 player.getParty().party.get(0).setLeft(false);
			 }else if(keyCode == KeyEvent.VK_RIGHT){
				 for(int i = 1; i < player.getParty().party.size(); i++){
					 if((Math.abs(player.getParty().party.get(i).getY() - player.getParty().party.get(i-1).getY()) <= 5) &&
						player.getParty().party.get(i-1).getX() >= player.getParty().party.get(i).getX() + 60){
							player.getParty().party.get(i).setFront(player.getParty().party.get(i-1).isFront());
							player.getParty().party.get(i).setBack(player.getParty().party.get(i-1).isBack());
							player.getParty().party.get(i).setRight(player.getParty().party.get(i-1).isRight());
							player.getParty().party.get(i).setLeft(player.getParty().party.get(i-1).isLeft());
					 }
				 }
				 player.getParty().party.get(0).setFront(false);
				 player.getParty().party.get(0).setBack(false);
				 player.getParty().party.get(0).setRight(true);
				 player.getParty().party.get(0).setLeft(false);
				 
			 }else{ 
				 for(int i = 1; i < player.getParty().party.size(); i++){
					 if((Math.abs(player.getParty().party.get(i).getY() - player.getParty().party.get(i-1).getY()) <= 5) &&
						player.getParty().party.get(i-1).getX() <= player.getParty().party.get(i).getX() - 60){
							player.getParty().party.get(i).setFront(player.getParty().party.get(i-1).isFront());
							player.getParty().party.get(i).setBack(player.getParty().party.get(i-1).isBack());
							player.getParty().party.get(i).setRight(player.getParty().party.get(i-1).isRight());
							player.getParty().party.get(i).setLeft(player.getParty().party.get(i-1).isLeft());
					 }
				 }
				 player.getParty().party.get(0).setFront(false);
				 player.getParty().party.get(0).setBack(false);
				 player.getParty().party.get(0).setRight(false);
				 player.getParty().party.get(0).setLeft(true);
				
			 }
			
		 }
		 if(!pressedKeys.isEmpty()){
			 for(int i = 0; i < player.getParty().party.size(); i ++){
				 player.getParty().party.get(i).setWalking(true);
			 }
		 }
		 respondToKeyInput();
	}

	public void keyReleased(KeyEvent e) {
		 int keyCode = e.getKeyCode();
		 if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			 pressedKeys.remove(pressedKeys.indexOf(keyCode));
		 }
		 if(pressedKeys.isEmpty()){
			 for(int i = 0; i < player.getParty().party.size(); i ++){
				 player.getParty().party.get(i).setWalking(false);
			 }
		 }
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

	private void respondToKeyInput(){ 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)){
			// player.getParty().party.get(0).setY(player.getParty().party.get(0).getY() - MOVE_UNIT);
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			// player.getParty().party.get(0).setY(player.getParty().party.get(0).getY() + MOVE_UNIT); 
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			// player.getParty().party.get(0).setX(player.getParty().party.get(0).getX() + MOVE_UNIT);
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
			// player.getParty().party.get(0).setX(player.getParty().party.get(0).getX() - MOVE_UNIT); 
			 for(int i = 0; i < player.getParty().party.size(); i++){		 
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
	}
	
	public void paintScreen(Graphics2D g2){
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		//Color c = new Color(0, 102, 51, 200);
		g2.drawImage(list.characters.get(i).getImage(),0,0,null);
		//g2.setColor(c);
		//g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		g2.drawString("Press 'Q' to toggle stat menu", 30, 75);
		g2.drawString("Press 'F' to take damage", 30, 90);
		g2.drawString("Press 'G' to consume mana", 30, 105);
		g2.drawString("Press 'Spacebar' switch heroes", 30, 120);
		g2.drawString("Press '1' to equip/dequip weapon", 30, 135);
		g2.drawString("Press '2' to equip/dequip better weapon", 30, 150);
		g2.drawString("Press '3' to equip/dequip armor", 30, 165);
		g2.drawString("Press '4' to equip/dequip better armor", 30, 180);
		g2.drawString("Press '5' to use HP potion", 30, 195);
		g2.drawString("Press '6' to get HP potion", 30, 210);
		g2.drawString("Press '7' to use MP potion", 30, 225);
		g2.drawString("Press '8' to get MP potion", 30, 240);

//			g2.setColor(Cr.white)
//			g2.fillRect(0, 0, width, height);
//			g2.setColor(Color.black);
		
		//Stat menu
		if(on){
			int x = 50;
			int y = 400;
			g2.setColor(Color.black);	
			g2.drawString(name, x, y);
			stats = selectedHero.getAllStats();

			for(int i = 0; i < stats.length; i++){
				y += 15;
				g2.drawString(statNames[i] + ": "+ stats[i], x, y);
			}
		}
		
//		//Inventory
//		int invX = 530;
//		int invY = 75;
//		g2.drawString("Inventory", invX, invY);
//		for(int j = 0; j < selectedHero.getInventory().length; j++){
//			invY += 15;
//			g2.drawString(selectedHero.getInventory()[j] + "", invX, invY);
//		}
//		
//		
//		
//		//Equiped
//		int eqX = 730;
//		int eqY = 75;
//		g2.drawString("Equipped", eqX, eqY);
//		for(int l = 0; l < selectedHero.getEquiped().length; l++){
//			eqY
//			+= 15;
//			g2.drawString(selectedHero.getEquiped()[l] + "", eqX, eqY);
//		}
//		
		//display character
		
		for(int k = 0; k < player.getParty().party.size(); k++){
			player.getParty().party.get(k).increaseCount();
		}

		for(int i = list.characters.size() - 1; i >= 0 ; i--){
			g2.drawImage(list.characters.get(i).getImage(),list.characters.get(i).getX(),list.characters.get(i).getY(),null);
		}

		//dialogue
		if(npcDialogue){
			g2.setColor(Color.white);
			g2.fillRect(100, 650, 500, 125);
			g2.setColor(Color.black);
			g2.draw(new RoundRectangle2D.Double(100, 650, 500, 125, 10, 10));
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g2.drawString(dialogue, 150, 700);
		}
	}
	
}
