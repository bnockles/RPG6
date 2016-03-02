package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import menus.MainMenu;
import directors.Game;
import directors.Screen;

/**
 * 
 * @author Khandaker Shayel & Yash Patel
 *
 */
public class TownScreen extends Screen implements KeyListener{

	public static final int talkMerchant = KeyEvent.VK_1;
	public static final int talkMini = KeyEvent.VK_2;
	public static final int talkStorage = KeyEvent.VK_3;
	public static final int storeItem = KeyEvent.VK_4;
	public static final int takeItem = KeyEvent.VK_5;
	public static final int buyItem1 = KeyEvent.VK_6;
	public static final int buyItem2 = KeyEvent.VK_7;
	public static final int buyItem3 = KeyEvent.VK_8;
	public static final int sellItem = KeyEvent.VK_9;
	public static final int rock = KeyEvent.VK_R;
	public static final int paper = KeyEvent.VK_R;
	public static final int scissor = KeyEvent.VK_S;
	public static final int infoNpc1 = KeyEvent.VK_Q;
	public static final int infoNpc3 = KeyEvent.VK_W;
	public static final int infoNpc2 = KeyEvent.VK_E;
	public static final int quit = KeyEvent.VK_K;
	public static final int goToPellet = KeyEvent.VK_B;
	public static final int goToBigRoot = KeyEvent.VK_N;
	public static final int goToOldYelp = KeyEvent.VK_M;
	
	SampleCharacter character;
	SampleCharacter displayNpc;
	Merchant merchant1;
	Merchant merchant2;
	Merchant merchant3;
	Minigame miniGame1;
	Minigame miniGame2;
	dummy dummy;
	Storage storageDude;
	int timesWonRps = 0;
	
	
	ArrayList<String> inventory = new ArrayList<String>();
	public static ArrayList<AbstractNPC> town1Npc = new ArrayList<AbstractNPC>();
	public static ArrayList<AbstractNPC> town2Npc = new ArrayList<AbstractNPC>();
	public static ArrayList<AbstractNPC> town3Npc = new ArrayList<AbstractNPC>();
	ArrayList<towns> Towns = new ArrayList<towns>();
	
	towns currentTown;

	public static String welcomeMessage = "Welcome to Pellet Town!";
	public static String message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
	public static String actionMessage = "";
	public static String storedItems = "";
	
	
	private BufferedImage img;
	
	
	/**
	 * @param game
	 */
	
	
	
	public TownScreen(Game game) {
		super(game);
		
		currentTown = townStock.getTown(townStock.PelletTown);
		
		town1Npc.add(merchant1);
		town1Npc.add(miniGame1);
		town1Npc.add(storageDude);
		
		town2Npc.add(merchant2);
		town2Npc.add(miniGame2);
		town2Npc.add(storageDude);
		
		town3Npc.add(merchant3);
		town3Npc.add(dummy);
		town3Npc.add(storageDude);
		
		Towns.add(townStock.getTown(townStock.PelletTown));
		Towns.add(townStock.getTown(townStock.BigRootTown));
		Towns.add(townStock.getTown(townStock.OldYelpTown));
		
		inventory.add("Health Potion");
		inventory.add("Mana Potion");
		inventory.add("Broad Sword");
		inventory.add("Long Bow");
		
		this.character = new SampleCharacter(400, "Con Duh Kurr","/images/character.png",9,590, inventory);
		this.displayNpc = new SampleCharacter("/images/white.png",600,590);
		
		//Npcs in Town 1
		this.merchant1 = new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true);
		this.miniGame1 = new Minigame("Bob","Male","Bob triggers a minigame, there are different minigames in each town that will help you earn money in the game, Bob lets you play rock, paper, scissors in this demo." , true);
		
		//Npcs in Town 2
		this.merchant2 = new Merchant("Rebecca", "Female", "Rebecca is the merchant for Big Root Town, she sells wepaons!", true);
		this.miniGame2 = new Minigame("Shrek","Male", "Shrek is a mini game NPC, in this town shrek well let you play 'Hot or cold', a number guessing game.", true);
		
		//Npcs in Town 3
		this.merchant3 = new Merchant("Karmen", "Female", "Karmen is the merchant for Old Yelelr Town, she sells armor!", true);
		this.dummy = new dummy("Omar", "Male", "All the storage dudes look the same... I secretly think they are all clones of each other! And how do they all store the same items when they are in different towns???",true);
		
		//Storage is in Every Town
		this.storageDude = new Storage("Greg","Male","He is your storage guy, him and his cousins (who look exactly like him) are in every town in case you want to store items and then take them back for later.", true);
		
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
			g2.drawString(welcomeMessage, 450, 50);
			g2.drawString(message, 50, 375);
			g2.drawString(actionMessage, 50, 400);
			g2.drawString(storedItems, 50, 425);
			
			
			
			//Gui for first town
			if(currentTown.getTownName() == "Pellet Town"){
				welcomeMessage = "Welcome to Pellet Town";
				g2.drawString("Press 'N' to go to Big Root Town, or 'M' to go to Old Yelp Town.", 350, 75);
				
				g2.drawString(merchant1.getName(), 50, 100);
				g2.drawString(miniGame1.getName(), 50, 200);
				g2.drawString(storageDude.getName(), 50, 300);

				g2.drawString("Press '1' to talk to the merchant or 'Q' for information.", 160, 100);
				g2.drawString("Press '2' to talk to the mini game NPC or 'W' for information.", 160, 200);
				g2.drawString("Press '3' to talk to to the storage NPC or 'E' for information.", 160, 300);
				
				
				
			}
			
			
			
			
			//Gui for Second town
			if(currentTown.getTownName() == "Big Root Town"){
				welcomeMessage = "Welcome to Big Root Town!";
				g2.drawString("Press 'B' to go to Pellet Town, or 'M' to go to Old Yelp Town.", 350, 75);
				
				g2.drawString(merchant2.getName(), 50, 100);
				g2.drawString(miniGame2.getName(), 50, 200);
				g2.drawString("Samuel", 50, 300);

				g2.drawString("Press '1' to talk to the merchant or 'Q' for information.", 160, 100);
				g2.drawString("Press '2' to talk to the mini game NPC or 'W' for information.", 160, 200);
				g2.drawString("Press '3' to talk to to the storage NPC or 'E' for information.", 160, 300);
				
			}
			
			
			
			
			//Gui for third town
			if(currentTown.getTownName() == "Old Yelp Town"){
				welcomeMessage = "Welcome to Old Yelp Town!";
				g2.drawString("Press 'B' to go to Pellet Town, or 'N' to go to Big Root Town.", 350, 75);
				
				g2.drawString(merchant3.getName(), 50, 100);
				g2.drawString(dummy.getName(), 50, 200);
				g2.drawString("Damon", 50, 300);

				g2.drawString("Press '1' to talk to the merchant or 'Q' for information.", 160, 100);
				g2.drawString("Press '2' to talk to the dummy NPC or 'W' for information.", 160, 200);
				g2.drawString("Press '3' to talk to to the storage NPC or 'E' for information.", 160, 300);
				
			}
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
		
		if(e.getKeyCode()==talkMerchant && currentTown.getTownName() == "Pellet Town"){
			System.out.println("1 was pressed");
			
			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You need more gems!";
			}
			
			else{
				message = "Welcome to the market! Feel free to buy what we have or sell what you have! Press 'K' to quit.";
			}
			
			displayNpc = new SampleCharacter("/images/merchant.png",810,400);
			miniGame1.setComputerPlay("null");
			actionMessage = "Press  6 for Healing Potions (300 Gems), 7 for Mana Potion (400 Gems), and 8 for Stats Potion (500 Gems)";
			Merchant.buyable = true;
			storedItems = "";
			Storage.storable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem1 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){
			
			System.out.println("6 was pressed");
			
			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}
			
			else{
				character.setCurrency(character.getCurrency()-300);
				inventory.add("Health Potion");
			}
			
			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem2 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){
			
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
		if(e.getKeyCode()==buyItem3 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){
			
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
		if(e.getKeyCode()==sellItem && Merchant.buyable == true){
			System.out.println("9 was pressed");
			if(character.getItems().size() == 0){
				actionMessage = "You have nothing to sell!";
			}
			else{
				actionMessage = "Soled " + inventory.get(0);
				if(inventory.get(0) == "Health Potion"){
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
				//ADD MORE ITEMS LATER
				//
				//
				//
				//
				//
				inventory.remove(0);
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==talkMini && currentTown.getTownName() == "Pellet Town"){
			System.out.println("2 was pressed");
			if(character.getCurrency() < 100){
				message = "You don't have enough money to play! Sorry!";
				miniGame1.setComputerPlay("null");
			}
			else{
				message = "We are going to play rock, paper, scissors. Press 'R' for rock, 'P' for paper, and 'S' for scissors. Or press 'K' to quit. You have won: " + timesWonRps + " times.";
				miniGame1.playRPS();
			}
			displayNpc = new SampleCharacter("/images/minigame.jpg",810,400);
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==rock){
			if(miniGame1.getComputerPlay()=="R"){
				message = "You both picked Rock, it's a tie! Press 'K' to quit.";
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="P"){
				message = "You picked Rock, the opponent picked paper ,you lose! You lose 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="S"){
				message = "You picked Rock, the oppoenent picked Scissors ,you win! You get 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWonRps++;
				miniGame1.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==paper){
			if(miniGame1.getComputerPlay()=="P"){
				message = "You both picked Paper, it's a tie! Press 'K' to quit.";
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="S"){
				message = "You picked Paper, the opponent picked Scissor ,you lose! You lose 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="R"){
				message = "You picked Paper, the opponent picked Rock, you win! You get 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWonRps++;
				miniGame1.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==scissor){
			if(miniGame1.getComputerPlay()=="S"){
				message = "You both picked Scissors, it's a tie! Press 'K' to quit.";
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="R"){
				message = "You picked Scissors, the opponenet picked Rock, you lose! You lose 100 gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				miniGame1.setComputerPlay("null");
			}
			if(miniGame1.getComputerPlay()=="P"){
				message = "You picked Scissors, the opponent picked paper, you win! You get 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()+100);
				timesWonRps++;
				miniGame1.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==talkStorage){
			System.out.println("3 was pressed");
			Storage.storable = true;
			message = "Have you seen my cousins? They look exactly like me! We store your goods! Store something (Press '4') or take out something out (Press '5'). Press 'K' to quit.";
			actionMessage = "";
			displayNpc = new SampleCharacter("/images/storage.png",810,400);
			storedItems = "The items you have stored are: ";
			for(int i=0;i < Storage.storedItems.size();i++){
				storedItems += Storage.storedItems.get(i)+ " ";
			}
			miniGame1.setComputerPlay("null");
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant.png",810,400);
			message = merchant1.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant2.png",810,400);
			message = merchant2.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Old Yelp Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant3.png",810,400);
			message = merchant3.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc2){
			System.out.println("E was pressed");
			this.displayNpc = new SampleCharacter("/images/storage.png",810,400);
			message = storageDude.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/minigame.jpg",810,400);
			message = miniGame1.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/minigame2.jpg",810,400);
			message = miniGame2.getDescription();
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Old Yelp Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/dummy.jpg",810,400);
			message = dummy.getDescription();
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==quit){
			System.out.println("K was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400);
			message =  "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==storeItem && Storage.storable == true){
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
			miniGame1.setComputerPlay("null");
			update();
			game.repaint();
		}
		if(e.getKeyCode()==takeItem && Storage.storable == true){
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
			miniGame1.setComputerPlay("null");
			update();
			game.repaint();
		}
		if(e.getKeyCode()==goToPellet && currentTown.getTownName() != "Pellet Town"){
			System.out.println("B was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400);
			message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			currentTown = townStock.getTown(townStock.PelletTown);
			welcomeMessage = "Welcome to Pellet Town!";
			update();
			game.repaint();
		}
		if(e.getKeyCode()==goToBigRoot && currentTown.getTownName() != "Big Root Town"){
			System.out.println("N was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400);
			message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			currentTown = townStock.getTown(townStock.BigRootTown);
			welcomeMessage = "Welcome to Big Root Town!";
			update();
			game.repaint();
		}
		if(e.getKeyCode()==goToOldYelp && currentTown.getTownName() != "Old Yelp Town"){
			System.out.println("M was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400);
			message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			actionMessage = "";
			storedItems = "";
			Storage.storable = false;
			Merchant.buyable = false;
			currentTown = townStock.getTown(townStock.OldYelpTown);
			welcomeMessage = "Welcome to Old Yelp Town!";
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

