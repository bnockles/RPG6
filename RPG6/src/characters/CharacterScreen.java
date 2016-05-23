package characters;

import items.Consumable;
import items.CraftHelper;
import items.Item;
import items.equipStock;
import items.Equipment;
import items.Stats;
import items.equipStock;
import items.potionStock;

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
	Item sword;
	Item sword2;
	Item armor;
	Item armor2;
	Item potion;
	Item potion2;
	BufferedImage heroImg;
	BufferedImage icon;
	ArrayList<Integer> pressedKeys;
	int heroNum = 0;
	String dialogue;
	
	public CharacterScreen(Game game) {
		super(game);
		try {
			bg = UtilityMethods.getImageFromFile(this, "/character/sample/bg.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		player = new Player("Link", 5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		hero2 = HeroTeam.getHero(HeroTeam.KNIGHT);
		hero3 = HeroTeam.getHero(HeroTeam.ADVENTURER);
		enemy = new Enemy("Reaper",  5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		enemy1 = new Enemy("Reaper",  5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		enemy2 = new Enemy("Reaper",  5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		enemy3 = new Enemy("Reaper",  5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		npc = new Npc("Billy",  5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
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
		pressedKeys = new ArrayList<Integer>();
		dialogue = "";
		
		
		sword = equipStock.equipStocks(0);
		armor = equipStock.equipStocks(33);
		potion = potionStock.consumableStock(0);
		potion2 = potionStock.consumableStock(3);
		
		player.addItem(sword);
		player.addItem(armor);
		player.addItem(potion);
		player.addItem(potion2);
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
		
		if(e.getKeyCode()==KeyEvent.VK_1){
			if(player.getInventory().contains(sword)){
				selectedHero.equip((Equipment) sword);
				player.getInventory().remove(sword);
				selectedHero.addEquipStats(sword);
			}else if(selectedHero.equipped.contains(sword)){
				selectedHero.unequip((Equipment) sword);
				player.getInventory().add(sword);
				selectedHero.removeEquipStats(sword);
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_2){
			if(player.getInventory().contains(armor)){
				selectedHero.equip((Equipment) armor);
				player.getInventory().remove(armor);
				selectedHero.addEquipStats(armor);
			}else if(selectedHero.equipped.contains(armor)){
				selectedHero.unequip((Equipment) armor);
				player.getInventory().add(armor);
				selectedHero.removeEquipStats(armor);
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_3){
			if(player.getInventory().contains(potion)){
				if(selectedHero.getCurrHealth() == selectedHero.getStats().getHealth()){
					return;
				}else{
					selectedHero.setCurrHealth(selectedHero.getStats().getHealth() + ((Consumable) potion).getAmount());
					player.getInventory().remove(potion);
				}
				if(selectedHero.getCurrHealth() > selectedHero.getStats().getHealth()){
					selectedHero.setCurrHealth(selectedHero.getStats().getHealth());
				}
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_4){
			if(player.getInventory().contains(potion2)){
				if(selectedHero.getCurrMana() == selectedHero.getStats().getMana()){
					return;
				}else{
					selectedHero.setCurrMana(selectedHero.getStats().getMana() + ((Consumable) potion2).getAmount());
					player.getInventory().remove(potion2);
				}
				if(selectedHero.getCurrMana() > selectedHero.getStats().getMana()){
					selectedHero.setCurrMana(selectedHero.getStats().getMana());
				}
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_5){
			player.getInventory().add(potion);
			player.getInventory().add(potion2);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			heroNum++;
			if(heroNum > player.getParty().party.size() - 1){
				heroNum = 0;
			}
			selectedHero = player.getParty().party.get(heroNum);
			name = selectedHero.getName();
			System.out.println(name);
			update();
			game.repaint();
		}
		
		//receive damage
		if(e.getKeyCode()==KeyEvent.VK_F){
			selectedHero.setCurrHealth(selectedHero.getCurrHealth() - 10);
			if(selectedHero.getCurrHealth() < 0){
				selectedHero.setCurrHealth(0);
			}
			
			update();
			game.repaint();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_G){
			selectedHero.setCurrMana(selectedHero.getCurrMana() - 10);
			if(selectedHero.getCurrMana() < 0){
				selectedHero.setCurrMana(0);
			}
			
			update();
			game.repaint();
		}
		
		 int keyCode = e.getKeyCode();
		 if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			 if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
			 if(keyCode == KeyEvent.VK_UP){
				 for(int i = 1; i < player.getParty().party.size(); i++){
					 if((Math.abs(player.getParty().party.get(i).getX() - player.getParty().party.get(i-1).getX()) <= 3) &&
						player.getParty().party.get(i-1).getY() >= player.getParty().party.get(i).getY() - player.getCharHeight()){
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
					 if((Math.abs(player.getParty().party.get(i).getX() - player.getParty().party.get(i-1).getX()) <= 3) &&		 
						player.getParty().party.get(i-1).getY() <= player.getParty().party.get(i).getY() + player.getCharHeight()){
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
					 if((Math.abs(player.getParty().party.get(i).getY() - player.getParty().party.get(i-1).getY()) <= 3) &&
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
					 if((Math.abs(player.getParty().party.get(i).getY() - player.getParty().party.get(i-1).getY()) <= 3) &&
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
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			 for(int i = 0; i < player.getParty().party.size(); i++){
				 if(player.getParty().party.get(i).isBack())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() - MOVE_UNIT);
				 if(player.getParty().party.get(i).isFront())player.getParty().party.get(i).setY(player.getParty().party.get(i).getY() + MOVE_UNIT); 
				 if(player.getParty().party.get(i).isRight())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() + MOVE_UNIT);
				 if(player.getParty().party.get(i).isLeft())player.getParty().party.get(i).setX(player.getParty().party.get(i).getX() - MOVE_UNIT);
			 }
		}
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
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
		g2.drawImage(bg,0,0,null);
		
		//menu box
		g2.setColor(Color.white);
		g2.fillRect(25, 50, 120, 500);
		g2.setColor(Color.black);
		g2.draw(new RoundRectangle2D.Double(25, 50, 120, 500, 10, 10));
		
//		g2.drawString("Press 'Q' to toggle stat menu", 30, 75);
//		g2.drawString("Press 'F' to take damage", 30, 90);
//		g2.drawString("Press 'G' to consume mana", 30, 105);
//		g2.drawString("Press 'Spacebar' switch heroes", 30, 120);
//		g2.drawString("Press '1' to equip/dequip weapon", 30, 135);
//		g2.drawString("Press '2' to equip/dequip better weapon", 30, 150);
//		g2.drawString("Press '3' to equip/dequip armor", 30, 165);
//		g2.drawString("Press '4' to equip/dequip better armor", 30, 180);
//		g2.drawString("Press '5' to use HP potion", 30, 195);
//		g2.drawString("Press '6' to get HP potion", 30, 210);
//		g2.drawString("Press '7' to use MP potion", 30, 225);
//		g2.drawString("Press '8' to get MP potion", 30, 240);
		
		
		int displayY = 75; 		
		g2.drawString("Stats:", 30, displayY);
		g2.drawString("Lv. " + selectedHero.getLevel() + " " + selectedHero.getName(), 30, displayY += 15);
		g2.drawString("Health: " + selectedHero.getCurrHealth() + "", 30, displayY += 15);
		g2.drawString("Mana: " + selectedHero.getCurrMana() + "", 30, displayY += 15);
		g2.drawString("Attack: " + selectedHero.getStats().getAttack() + "", 30, displayY += 15);
		g2.drawString("Defense: " + selectedHero.getStats().getDefense() + "", 30, displayY += 15);
		g2.drawString("Speed: " + selectedHero.getStats().getSpeed() + "", 30, displayY += 15);
		g2.drawString("Strength: " + selectedHero.getStats().getStrength() + "", 30, displayY += 15);
		g2.drawString("Dexterity: " + selectedHero.getStats().getDexterity() + "", 30, displayY += 15);
		g2.drawString("Intelligence: " + selectedHero.getStats().getIntelligence() + "", 30, displayY += 15);
		g2.drawString("Wisdom: " + selectedHero.getStats().getWisdom() + "", 30, displayY += 15);
		g2.drawString("Luck: " + selectedHero.getStats().getLuck() + "", 30, displayY += 15);
		
		
		
		//display inventory 
		
		g2.drawString("Inventory:", 30, displayY += 20);
		for(int i = 0; i < player.getInventory().size(); i++){
			displayY += 15;
			g2.drawString(i+ ": " + player.getInventory().get(i).getName(), 30, displayY);
		}

		
		//display equipped
		g2.drawString("Equipped:", 30, displayY += 20);
		for(int i = 0; i < selectedHero.getEquipped().size(); i++){
			displayY += 15;
			g2.drawString(selectedHero.getEquipped().get(i).getName(), 30, displayY);
		}
		
		
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
