package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import directors.Game;
import directors.Screen;

/**
 * 
 * @author Khandaker Shayel & Yash Patel
 *
 */
public class TownScreen extends Screen implements KeyListener{

	SampleCharacter character;
	SampleCharacter displayNpc;
	Merchant merchant1;
	Minigame rpsMan;
	Storage storageDude;
	int timesWon = 0;
	
	
	ArrayList<String> inventory = new ArrayList<String>();
	

	public static String message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
	public static String actionMessage = "";
	public static String storedItems = "";
	
	
	private BufferedImage img;
	
	
	/**
	 * @param game
	 */
	
	
	
	public TownScreen(Game game) {
		
		super(game);
		
		inventory.add("Health Potion");
		inventory.add("Mana Potion");
		inventory.add("Broad Sword");
		inventory.add("Long Bow");
		
		this.character = new SampleCharacter(400, "Smith","/images/character.png",9,590, inventory);
		this.displayNpc = new SampleCharacter("/images/white.png",600,590);
		this.merchant1 = new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true);
		this.rpsMan = new Minigame("Bob","Male","Bob triggers a minigame, there are different minigames in each town that will help you earn money in the game, Bob lets you play rock, paper, scissors in this demo." , true);
		this.storageDude = new Storage("Greg","Male","Greg is your storage guy, he is in every town in case you want to store items and then take them back for later.", true);
		update();
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		
		try{
			g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
			g2.drawImage(displayNpc.getImage(),displayNpc.getX(),displayNpc.getY(),null);
			g2.drawString("NAME: " + character.getName(), 170, 620);
			g2.drawString("BALANCE: " + character.getCurrency() + " Gems", 170, 640);
			g2.drawString("Current Inventory: ", 170, 720);

			int x = 170;
			for(int i=0; i<inventory.size();i++){
				g2.drawString(inventory.get(i), x,740);
				x += 100;
			}
			g2.drawString("Available NPCs", 50, 75);
			g2.drawString(merchant1.getName(), 50, 100);
			g2.drawString(rpsMan.getName(), 50, 200);
			g2.drawString(storageDude.getName(), 50, 300);
			g2.drawString("Press '1' to talk to the merchant or 'Q' for information.", 160, 100);
			g2.drawString("Press '2' to talk to the mini game NPC or 'W' for information.", 160, 200);
			g2.drawString("Press '3' to talk to to the storage NPC or 'E' for information.", 160, 300);

			g2.drawString(message, 50, 375);
			g2.drawString(actionMessage, 50, 400);
			g2.drawString(storedItems, 50, 425);
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		
	}

	/* (non-Javadoc)
	 * @see directors.Screen#getKeyListener()
	 */
	@Override
	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_1){
			System.out.println("1 was pressed");
			
			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You need more gems!";
			}
			
			else{
				message = "Welcome to the market! Feel free to buy what we have or sell what you have! Press 'K' to quit.";
			}
			
			displayNpc = new SampleCharacter("/images/merchant.png",810,400);
			
			rpsMan.setComputerPlay("null");
			
			actionMessage = "Press  6 for Healing Potions (300 Gems), 7 for Mana Potion (400 Gems), and 8 for Stats Potion (500 Gems)";
			
			Merchant.buyable = true;
			
			storedItems = "";
			
			Storage.storable = false;
			
			update();
			
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_6 && Merchant.buyable == true){
			
			System.out.println("6 was pressed");
			
			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}
			
			else{
				character.setCurrency(character.getCurrency()-300);
				inventory.add("Healing Potion");
			}
			
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_7 && Merchant.buyable == true){
			
			System.out.println("7 was pressed");
			
			if(character.getCurrency() < 400){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}
			
			else{
				character.setCurrency(character.getCurrency()-400);
				inventory.add("Mana Potion");
			}
			
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_8 && Merchant.buyable == true){
			
			System.out.println("8 was pressed");
			
			if(character.getCurrency() < 500){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}
			
			else{
				character.setCurrency(character.getCurrency()-500);
				inventory.add("Stats Potion");
			}
			
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_9 && Merchant.buyable == true){
			System.out.println("9 was pressed");
			if(character.getItems().size() == 0){
				actionMessage = "You have nothing to sell!";
			}
			else{
				actionMessage = "Soled " + inventory.get(0);
				if(inventory.get(0) == "Healing Potion"){
					character.setCurrency(character.getCurrency()+200);
				}
				if(inventory.get(0) == "Mana Potion"){
					character.setCurrency(character.getCurrency()+300);				
				}
				if(inventory.get(0) == "Stats Potion"){
					character.setCurrency(character.getCurrency()+400);
				}
				if(inventory.get(0) == "Broad Sword"){
					character.setCurrency(character.getCurrency()+500);
				}
				if(inventory.get(0) == "Long Bow"){
					character.setCurrency(character.getCurrency()+600);
				}
				inventory.remove(0);
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			System.out.println("2 was pressed");
			if(character.getCurrency() < 100){
				message = "You don't have enough money to play! Sorry!";
				rpsMan.setComputerPlay("null");
			}
			else{
				message = "We are going to play rock, paper, scissors. Press 'R' for rock, 'P' for paper, and 'S' for scissors. Or press 'K' to quit. You have won: " + timesWon + " times.";
				rpsMan.playRPS();
			}
			displayNpc = new SampleCharacter("/images/minigame.jpg",810,400);
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_R){
			if(rpsMan.getComputerPlay()=="R"){
				message = "You both picked Rock, it's a tie! Press 'K' to quit.";
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="P"){
				message = "You picked Rock, the opponent picked paper ,you lose! You lose 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="S"){
				message = "You picked Rock, the oppoenent picked Scissors ,you win! You get 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWon++;
				rpsMan.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_P){
			if(rpsMan.getComputerPlay()=="P"){
				message = "You both picked Paper, it's a tie! Press 'K' to quit.";
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="S"){
				message = "You picked Paper, the opponent picked Scissor ,you lose! You lose 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="R"){
				message = "You picked Paper, the opponent picked Rock, you win! You get 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWon++;
				rpsMan.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			if(rpsMan.getComputerPlay()=="S"){
				message = "You both picked Scissors, it's a tie! Press 'K' to quit.";
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="R"){
				message = "You picked Scissors, the opponenet picked Rock, you lose! You lose 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				rpsMan.setComputerPlay("null");
			}
			if(rpsMan.getComputerPlay()=="P"){
				message = "You picked Scissors, the opponent picked paper, you win! You get 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWon++;
				rpsMan.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			System.out.println("3 was pressed");
			Storage.storable = true;
			message = "We store your goods! Store something (Press '4') or take out something you already stored (Press '5'). Press 'K' to quit.";
			actionMessage = "";
			displayNpc = new SampleCharacter("/images/storage.png",810,400);
			storedItems = "The items you have stored are: ";
			for(int i=0;i < Storage.storedItems.size();i++){
				storedItems += Storage.storedItems.get(i)+ " ";
			}
			rpsMan.setComputerPlay("null");
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_Q){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant.png",810,400);
			message = merchant1.getDescription();
			rpsMan.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_E){
			System.out.println("E was pressed");
			this.displayNpc = new SampleCharacter("/images/storage.png",810,400);
			message = storageDude.getDescription();
			rpsMan.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_W){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/minigame.jpg",810,400);
			message = rpsMan.getDescription();
			rpsMan.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_K){
			System.out.println("K was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400);
			Storage.storable = true;
			message =  "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			rpsMan.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_4 && Storage.storable == true){
			System.out.println("4 was pressed");
			if(character.getItems().size() == 0){
				actionMessage = "You have nothing else we can store...";
			}
			else{
				actionMessage = "Stored " + inventory.get(0);
				storedItems = storedItems + inventory.get(0) + " ";
				Storage.storedItems.add(inventory.get(0));
				inventory.remove(0);				
			}
			rpsMan.setComputerPlay("null");
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_5 && Storage.storable == true){
			System.out.println("5 was pressed");
			if(Storage.storedItems.size() == 0){
				actionMessage = "You have nothing stored here...";
				storedItems = "The items you have stored are: ";
			}
			else{
				actionMessage = "Taken out " + Storage.storedItems.get(0);
				inventory.add(Storage.storedItems.get(0));
				Storage.storedItems.remove(0);
			}
			storedItems = "The items you have stored are: ";
			for(int i=0;i < Storage.storedItems.size();i++){
				storedItems += Storage.storedItems.get(i)+ " ";
			}
			rpsMan.setComputerPlay("null");
			update();
			game.repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

