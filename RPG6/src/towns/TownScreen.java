package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import directors.Game;
import directors.Screen;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * 
 * @author Khandaker Shayel
 *
 */

public class TownScreen extends Screen implements KeyListener{

	public static final int talkNpc1 = KeyEvent.VK_1;
	public static final int talkNpc2 = KeyEvent.VK_2;
	public static final int talkNpc3 = KeyEvent.VK_3;
	public static final int storeItem = KeyEvent.VK_4;
	public static final int takeItem = KeyEvent.VK_5;
	public static final int buyItem1 = KeyEvent.VK_6;
	public static final int buyItem2 = KeyEvent.VK_7;
	public static final int buyItem3 = KeyEvent.VK_8;
	public static final int sellItem = KeyEvent.VK_9;
	public static final int repairItem = KeyEvent.VK_R;
	public static final int paper = KeyEvent.VK_R;
	public static final int heads = KeyEvent.VK_H;
	public static final int tails = KeyEvent.VK_T;
	public static final int scissor = KeyEvent.VK_S;
	public static final int infoNpc1 = KeyEvent.VK_Q;
	public static final int infoNpc3 = KeyEvent.VK_W;
	public static final int infoNpc2 = KeyEvent.VK_E;
	public static final int quit = KeyEvent.VK_K;
	public static final int goToPellet = KeyEvent.VK_B;
	public static final int goToBigRoot = KeyEvent.VK_N;
	public static final int goToOldYelp = KeyEvent.VK_M;
	public static final int up = KeyEvent.VK_UP;
	public static final int down = KeyEvent.VK_DOWN;
	public static final int left = KeyEvent.VK_LEFT;
	public static final int right = KeyEvent.VK_RIGHT;
	public static final int craft = KeyEvent.VK_C;
	public static final int crafting = KeyEvent.VK_X;
	public static final int storeItem1 = KeyEvent.VK_A;
	public static final int storeItem2 = KeyEvent.VK_S;
	public static final int storeItem3 = KeyEvent.VK_D;
	public static final int storeItem4 = KeyEvent.VK_F;
	public static final int slot1 = KeyEvent.VK_J;
	public static final int slot2 = KeyEvent.VK_K;
	public static final int slot3 = KeyEvent.VK_L;



	static SampleCharacter character;
	SampleCharacter displayNpc;
	Merchant merchant1;
	Merchant merchant2;
	Merchant merchant3;
	Minigame miniGame1;
	Minigame miniGame2;
	dummy dummy;
	static int dummyCounter = 0;
	Storage storageDude;
	int timesWonRps = 0;
	int timesWonFlip =0;
	static boolean town1 = true;
	static boolean town2 = false;
	static boolean town3 = false;
	boolean repairing;
	boolean inRepair;
	boolean inCrafting;
	int repairIndex = 0;
	int craftIndex = 0;
	ArrayList<Equipment> items;
	ArrayList<String> craftableThings;


	//Sounds and music
	static AudioPlayer MGP = AudioPlayer.player;
	static AudioStream BGM;
	static AudioData MD;
	static ContinuousAudioDataStream loop = null;
	static InputStream town1Music;  
	static InputStream town2Music; 
	static InputStream town3Music;
	String selected;


	static ArrayList<Equipment> inventory = new ArrayList<Equipment>();
	static ArrayList<Equipment> repairItems = new ArrayList<Equipment>();
	public static ArrayList<AbstractNPC> town1Npc = new ArrayList<AbstractNPC>();
	public static ArrayList<AbstractNPC> town2Npc = new ArrayList<AbstractNPC>();
	public static ArrayList<AbstractNPC> town3Npc = new ArrayList<AbstractNPC>();
	ArrayList<towns> Towns = new ArrayList<towns>();

	static towns currentTown;

	public static String welcomeMessage = "Welcome to Pellet Town!";
	SampleCharacter town;
	public static String message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
	public static String actionMessage = "";
	public static String storedItems = "";


	private BufferedImage img;


	/**
	 * @param game
	 */



	public TownScreen(Game game) {
		super(game);		

		Sound.audio("src/towns/images/town1.wav");

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

		inventory.add(equipStock.equipStocks(equipStock.B_SD));
		inventory.add(equipStock.equipStocks(equipStock.W_BW));
		inventory.add(equipStock.equipStocks(equipStock.M_WD));
		inventory.add(equipStock.equipStocks(equipStock.P_HR));

		this.character = new SampleCharacter(69420, "Con Duh Kurr","/images/character.png",9,590, inventory);
		this.displayNpc = new SampleCharacter("/images/white.png",600,590, "npc");
		this.town = new SampleCharacter("/images/town1.png",600,100, "town");

		//Npcs in Town 1
		this.merchant1 = new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true);
		this.miniGame1 = new Minigame("Bob","Male","Bob triggers a minigame, there are different minigames in each town that will help you earn money in the game, Bob lets you play rock, paper, scissors in this demo." , true);

		//Npcs in Town 2
		this.merchant2 = new Merchant("Rebecca", "Female", "Rebecca is the merchant for Big Root Town, she sells wepaons!", true);
		this.miniGame2 = new Minigame("Shrek","Male", "Shrek is a mini game NPC, in this town shrek well let you play 'Hot or cold', a number guessing game.", true);

		//Npcs in Town 3
		inRepair = true;
		repairItems = new ArrayList<Equipment>();
		this.merchant3 = new Merchant("Karmen", "Female", "Karmen is the black smith for Old Yelelr Town, she will repair your equipment!", true);
		this.dummy = new dummy("Omar", "Male", "This is a dummy npc, they don't do much in terms of actual gameplay but rather they give you small hints and tips on what to do in the game.",true);


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
			g2.drawImage(town.getImage(),town.getX(),town.getY(),null);
			g2.drawString("NAME: " + character.getName(), 170, 620);
			g2.drawString("BALANCE: " + character.getCurrency() + " Gems", 170, 640);
			g2.drawString("Current Inventory: ", 170, 720);

			int x = 170;
			int y = 425;
			for(int i=0; i<inventory.size();i++){
				g2.drawString(inventory.get(i).getName() + "     " + (inventory.get(i).getDurability()), x,740);
				x += 150;
			}

			if(inRepair == true){
				for(int i=0; i<repairItems.size();i++){
					if(i == repairIndex){
						selected = "[SELECTED]";
					}
					else{
						selected = "";
					}
					if(inventory.get(i).getDurability() <= 100  && inventory.get(i).getDurability() >= 75)
					{
						g2.setColor(Color.blue);
					}
					if(inventory.get(i).getDurability() < 75  && inventory.get(i).getDurability() >= 50)
					{
						g2.setColor(Color.green);
					}
					if(inventory.get(i).getDurability() < 50  && inventory.get(i).getDurability() >= 25)
					{
						g2.setColor(Color.orange);
					}
					if(inventory.get(i).getDurability() < 25  && inventory.get(i).getDurability() >= 0)
					{				
						g2.setColor(Color.red);
					}
					items = repairItems;
					g2.drawString(items.get(i).getName() + "     Durability: " + (items.get(i).getDurability()) +  "     Status: " + BlackSmith.durabilityMeter(items.get(i)) + "     Price: " + BlackSmith.getCostRepair(items.get(i)) + "     "+ selected, 50, y);
					y += 30;
				}
			}


			if(inCrafting == true){
				for(int i=0; i<craftableThings.size();i++)
				{
					if(i == craftIndex){
						selected = "[SELECTED]";
					}
					else{
						selected = "";
					}
					g2.setColor(Color.magenta);
					g2.drawString(craftableThings.get(i) + "     Things needed to craft it: " + Arrays.deepToString(BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(i))])+ "     " +selected, 50, y);
					y += 30;
				}
			}


			g2.setColor(Color.black);
			g2.drawString("Available NPCs", 50, 75);
			g2.drawString(welcomeMessage, 450, 50);
			g2.drawString(message, 50, 375);
			g2.drawString(actionMessage, 50, 400);
			g2.drawString(storedItems, 50, 425);


			//Gui for first town
			if(currentTown.getTownName() == "Pellet Town"){

				welcomeMessage = "Welcome to Pellet Town";
				this.town = new SampleCharacter("/images/town1.png",600,100, "town");
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
				this.town = new SampleCharacter("/images/town2.png",600,100, "town");
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
				this.town = new SampleCharacter("/images/town3.png",600,100, "town");
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

	@Override

	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		//CODE FOR BLACK SMITH
		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Old Yelp Town")
		{
			System.out.println("1 was pressed");
			inRepair = true;
			inCrafting = false;
			message = "Welcome to the black smith shop! We will repair what you need! You can also press 'C' to craft! Press 'K' to quit.";

			displayNpc = new SampleCharacter("/images/merchant3.png",810,400,"npc");
			miniGame1.setComputerPlay("null");
			if(BlackSmith.needRepairs(inventory) == false)
			{
				actionMessage = "You don't need anything repaired!";
				repairItems.clear();
			}
			else
			{
				actionMessage = "Here are your list of things that need to be repaired: ";
				repairItems = BlackSmith.addRepairList(inventory);
			}
			Merchant.buyable = true;
			storedItems = "";
			//Storage.storable = false;
			update();
			game.repaint();
		}

		if(e.getKeyCode()==repairItem && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town" && inRepair == true)
		{
			if(character.getCurrency() < BlackSmith.getCostRepair(repairItems.get(repairIndex))){
				actionMessage = "Oops! You do not have enough money to repair that at this time!";
			}
			if(repairIndex < repairItems.size() && character.getCurrency() >= BlackSmith.getCostRepair(repairItems.get(repairIndex))){
				if(repairItems.get(repairIndex).getDurability()==100){
					actionMessage = "This has already been repaired!";
				}
				System.out.println("R was pressed");
				if(repairItems.get(repairIndex).getDurability() != 100){
					actionMessage = "We repaired your " + repairItems.get(repairIndex) + "!";
				}
				character.setCurrency(character.getCurrency()-(BlackSmith.getCostRepair(repairItems.get(repairIndex))));
				System.out.println("Price: " + BlackSmith.getCostRepair(repairItems.get(repairIndex)));
				BlackSmith.repair(repairItems.get(repairIndex));
				System.out.println(repairItems.get(0).getName());
				System.out.println(repairItems.get(0).getDurability());
			}		
			update();
			game.repaint();

		}
		if(e.getKeyCode()==craft && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town")
		{
			message = "Welcome to the crafting station! Combine your items to make even better ones! Press 'K' to quit.";
			ItemCraftable smith = new BlackSmith(selected, selected, selected, inRepair);
			if(smith.matchesRecipe(inventory, BlackSmith.Recipe).size() == 0)
			{
				actionMessage = "You don't have the required combination of items to craft something or you may need to make repairs!";
			}
			else{
				inCrafting = true;
				actionMessage = "Here are your list of things that you are able to craft: ";
				craftableThings = smith.matchesRecipe(inventory, BlackSmith.Recipe);
			}
			inRepair = false;	
			update();
			game.repaint();
		}
		if(e.getKeyCode()==crafting && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town" && inRepair == false)
		{
			if(inCrafting){
				String craftedItem = craftableThings.get(craftIndex);
				System.out.println(craftedItem);
				if(craftedItem.equals("Iron Bow")){
					for(int i=0; i<BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(craftIndex))].length;i++)
					{	
						for(int j=0; j<inventory.size();j++){
							if(BlackSmith.Recipe[BlackSmith.returnInt("Iron Bow")][i].getName().equals(inventory.get(j).getName())){
								System.out.println(BlackSmith.Recipe[BlackSmith.returnInt("Iron Bow")][i].getName());
								inventory.remove(j);
							}	
						}				
					}
					inventory.add(equipStock.equipStocks(equipStock.I_BW));
				}
				if(craftedItem.equals("Mithril Hammer")){
					for(int i=0; i<BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(craftIndex))].length;i++)
					{
						for(int j=0; j<inventory.size();j++){
							if(BlackSmith.Recipe[BlackSmith.returnInt("Mithril Hammer")][i].getName().equals(inventory.get(j).getName())){
								System.out.println(BlackSmith.Recipe[BlackSmith.returnInt("Mithril Hammer")][i].getName());
								inventory.remove(j);
							}
						}
					}	
					inventory.add(equipStock.equipStocks(equipStock.M_HR));
				}
				if(craftedItem.equals("Spear of Destruction")){
					for(int i=0; i<BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(craftIndex))].length;i++)
					{
						for(int j=0; j<inventory.size();j++){
							if(BlackSmith.Recipe[BlackSmith.returnInt("Spear of Destruction")][i].getName().equals(inventory.get(j).getName())){
								System.out.println(BlackSmith.Recipe[BlackSmith.returnInt("Spear of Destruction")][i].getName());
								inventory.remove(j);
							}	
						}
					}
					inventory.add(equipStock.equipStocks(equipStock.SR_D));
				}
				if(craftedItem.equals("Diamond Bow")){
					for(int i=0; i<BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(craftIndex))].length;i++)
					{
						for(int j=0; j<inventory.size();j++){
							if(BlackSmith.Recipe[BlackSmith.returnInt("Diamond Bow")][i].getName().equals(inventory.get(j).getName())){
								System.out.println(BlackSmith.Recipe[BlackSmith.returnInt("Diamond Bow")][i].getName());
								inventory.remove(j);
							}
						}
					}
					inventory.add(equipStock.equipStocks(equipStock.D_BW));
				}
				if(craftedItem.equals("Plat Sword")){
					for(int i=0; i<BlackSmith.Recipe[BlackSmith.returnInt(craftableThings.get(craftIndex))].length;i++)
					{
						for(int j=0; j<inventory.size();j++){
							if(BlackSmith.Recipe[BlackSmith.returnInt("Plat Sword")][i].getName().equals(inventory.get(j).getName())){
								System.out.println(BlackSmith.Recipe[BlackSmith.returnInt("Plat Sword")][i].getName());
								inventory.remove(j);
							}
						}
					}
					inventory.add(equipStock.equipStocks(equipStock.P_SD));
				}
			}
			actionMessage = "You just crafted the " + craftableThings.get(craftIndex) + "!";
			inCrafting = false;
			inRepair = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()== up)
		{
			if(inRepair){
				if(repairIndex >= 0){
					repairIndex--;
				}
				if(repairIndex < 0){
					repairIndex = repairItems.size()-1;
				}
			}
			if(inCrafting){
				if(craftIndex >= 0){
					craftIndex--;
				}
				if(craftIndex < 0){
					craftIndex = craftableThings.size()-1;
				}
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()== down)
		{
			if(inRepair){
				if(repairIndex < repairItems.size()){
					repairIndex++;
				}
				if(repairIndex >= repairItems.size()){
					repairIndex = 0;
				}
			}			
			if(inCrafting){
				if(craftIndex < craftableThings.size()){
					craftIndex++;
				}
				if(craftIndex >= craftableThings.size()){
					craftIndex = 0;
				}
			}
			update();
			game.repaint();			
		}
		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("1 was pressed");
			inRepair = false;
			inCrafting = false;
			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You need more gems!";
			}

			else{
				message = "Welcome to the market! Feel free to buy what we have or sell what you have! Press 'K' to quit.";
			}

			displayNpc = new SampleCharacter("/images/merchant.png",810,400,"npc");
			miniGame1.setComputerPlay("null");
			actionMessage = "Press  6 for Healing Potions (300 Gems), 7 for Mana Potion (400 Gems), and 8 for Stats Potion (500 Gems)";
			Merchant.buyable = true;
			storedItems = "";
			//Storage.storable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("1 was pressed");
			inRepair = false;
			inCrafting = false;
			if(character.getCurrency() < 600){
				message = "Oops! Seems like you don't have enough to buy anything! You need at least 600 gems, go and see Bob to try and earn some money!";
				actionMessage = "You need more gems!";
			}

			else{
				message = "Welcome to the market! Feel free to buy what we have or sell what you have! Press 'K' to quit.";
			}

			displayNpc = new SampleCharacter("/images/merchant2.png",810,400,"npc");
			miniGame1.setComputerPlay("null");
			actionMessage = "Press  6 for Shuriken (600 Gems), 7 for Katana (700 Gems), and 8 for Pistol (800 Gems)";
			Merchant.buyable = true;
			storedItems = "";
			//Storage.storable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem1 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){

			System.out.println("6 was pressed");

			if(character.getCurrency() < 300){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 400 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-300);
				//inventory.add("Health Potion");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem1 && Merchant.buyable == true && currentTown.getTownName() == "Big Root Town"){

			System.out.println("6 was pressed");

			if(character.getCurrency() < 600){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 600 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-600);
				//inventory.add("Shuriken");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem1 && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town"){

			System.out.println("6 was pressed");

			if(character.getCurrency() < 400){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 400 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-400);
				//inventory.add("Leather Armor");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem2 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){

			System.out.println("7 was pressed");

			if(character.getCurrency() < 400){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 400 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-400);
				//inventory.add("Mana Potion");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem2 && Merchant.buyable == true && currentTown.getTownName() == "Big Root Town"){

			System.out.println("7 was pressed");

			if(character.getCurrency() < 700){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 700 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-700);
				//inventory.add("Katana");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem2 && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town"){

			System.out.println("7 was pressed");

			if(character.getCurrency() < 500){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 500 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}
			else{
				character.setCurrency(character.getCurrency()-500);
				//inventory.add("Iron Armor");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem3 && Merchant.buyable == true && currentTown.getTownName() == "Pellet Town"){

			System.out.println("8 was pressed");
			inRepair = false;
			inCrafting = false;
			if(character.getCurrency() < 500){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 300 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-500);
				//inventory.add("Stats Potion");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem3 && Merchant.buyable == true && currentTown.getTownName() == "Big Root Town"){

			System.out.println("8 was pressed");
			inRepair = false;
			inCrafting = false;
			if(character.getCurrency() < 800){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 800 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-800);
				//inventory.add("Pistol");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==buyItem3 && Merchant.buyable == true && currentTown.getTownName() == "Old Yelp Town"){

			System.out.println("8 was pressed");
			inRepair = false;
			inCrafting = false;
			if(character.getCurrency() < 600){
				message = "Oops! Seems like you don't have enough to buy this! You need at least 600 gems, go and see Bob to try and earn some money!";
				actionMessage = "You don't have any more gems!";
			}

			else{
				character.setCurrency(character.getCurrency()-600);
				//inventory.add("Diamond Armor");
			}

			update();
			game.repaint();
		}
		if(e.getKeyCode()==sellItem && Merchant.buyable == true){
			System.out.println("9 was pressed");
			//			if(character.getItems().size() == 0){
			//				actionMessage = "You have nothing to sell!";
			//			}
			//			else{
			//				actionMessage = "Soled " + inventory.get(0);
			//				if(inventory.get(0) == "Health Potion"){
			//					character.setCurrency(character.getCurrency()+200);
			//				}
			//				if(inventory.get(0) == "Mana Potion"){
			//					character.setCurrency(character.getCurrency()+300);				
			//				}
			//				if(inventory.get(0) == "Stats Potion"){
			//					character.setCurrency(character.getCurrency()+400);
			//				}
			//				if(inventory.get(0) == "Broad Sword"){
			//					character.setCurrency(character.getCurrency()+500);
			//				}
			//				if(inventory.get(0) == "Long Bow"){
			//					character.setCurrency(character.getCurrency()+600);
			//				}
			//				if(inventory.get(0) == "Leather Armor"){
			//					character.setCurrency(character.getCurrency()+300);
			//				}
			//				if(inventory.get(0) == "Iron Armor"){
			//					character.setCurrency(character.getCurrency()+400);
			//				}
			//				if(inventory.get(0) == "Diamond Armor"){
			//					character.setCurrency(character.getCurrency()+500);
			//				}
			//				if(inventory.get(0) == "Shuriken"){
			//					character.setCurrency(character.getCurrency()+500);
			//				}
			//				if(inventory.get(0) == "Katana"){
			//					character.setCurrency(character.getCurrency()+600);
			//				}
			//				if(inventory.get(0) == "Pistol"){
			//					character.setCurrency(character.getCurrency()+700);
			//				}
			//				inventory.remove(0);
			//			}
			//			update();
			//		game.repaint();
		}
		if(e.getKeyCode()==talkNpc2 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("2 was pressed");
			if(character.getCurrency() < 100){
				message = "You don't have enough money to play! Sorry!";
				miniGame1.setComputerPlay("null");
			}
			else{
				message = "We are going to play rock, paper, scissors. Press 'R' for rock, 'P' for paper, and 'S' for scissors. Or press 'K' to quit. You have won: " + timesWonRps + " times.";
				miniGame1.playRPS();
			}
			displayNpc = new SampleCharacter("/images/minigame.jpg",810,400,"npc");
			actionMessage = "";
			storedItems = "";
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}

		//EDIT MINI GAME 2
		if(e.getKeyCode()==talkNpc2 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("2 was pressed");
			if(character.getCurrency() < 100){
				message = "You don't have enough money to play! Sorry!";
				miniGame2.setComputerPlay("null");
			}
			else{
				message = "Dare to take chance? Lets flip coin, yeah? 'H' for heads, 'T' for tails! Or press 'K' to quit. You have won: " + timesWonFlip + " times.";
				miniGame2.flipCoin();
			}
			displayNpc = new SampleCharacter("/images/minigame2.jpg",810,400,"npc");
			actionMessage = "";
			storedItems = "";
			//Storage.storable = false;
			inRepair = false;
			inCrafting = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==talkNpc2 && currentTown.getTownName() == "Old Yelp Town"){
			System.out.println("2 was pressed");
			displayNpc = new SampleCharacter("/images/dummy.jpg",810,400,"npc");
			dummyCounter++;
			message = dummy.getNpcMessages(dummyCounter);
			inRepair = false;
			inCrafting = false;
			actionMessage = "";
			storedItems = "";
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==heads){
			if(miniGame2.getComputerPlay()=="H"){
				message = "It lands on heads! I lost??? Take 100 gems. Press 'K' to quit.";
				timesWonFlip++;
				character.setCurrency(character.getCurrency()+100);
				miniGame2.setComputerPlay("null");
			}
			if(miniGame2.getComputerPlay()=="T"){
				message = "It lands on tails! Ha! I have won, you lost 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				miniGame2.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==tails){
			if(miniGame2.getComputerPlay()=="T"){
				message = "It lands on tails! I lost??? Take 100 gems. Press 'K' to quit.";
				timesWonFlip++;
				character.setCurrency(character.getCurrency()+100);
				miniGame2.setComputerPlay("null");
			}
			if(miniGame2.getComputerPlay()=="H"){
				message = "It lands on heads! Ha! I have won, you lost 100 Gems! Press 'K' to quit.";
				character.setCurrency(character.getCurrency()-100);
				miniGame2.setComputerPlay("null");
			}
			update();
			game.repaint();
		}
		if(e.getKeyCode()==repairItem){
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
		if(e.getKeyCode()==talkNpc3){
			System.out.println("3 was pressed");
			//Storage.storable = true;
			message = "Have you seen my cousins? They look exactly like me! We store your goods! Store something (Press '4') or take out something out (Press '5'). Press 'K' to quit.";
			actionMessage = "";
			inRepair = false;
			inCrafting = false;
			displayNpc = new SampleCharacter("/images/storage.png",810,400,"npc");
			storedItems = "The items you have stored are: ";
			for(int i=0;i < Storage.convertToList(Storage.getStorage()).size();i++){
				storedItems += Storage.convertToList(Storage.getStorage()).get(i)+ " ";
			}
			miniGame1.setComputerPlay("null");
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant.png",810,400,"npc");
			message = merchant1.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant2.png",810,400,"npc");
			message = merchant2.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc1 && currentTown.getTownName() == "Old Yelp Town"){
			System.out.println("Q was pressed");
			this.displayNpc = new SampleCharacter("/images/merchant3.png",810,400,"npc");
			message = merchant3.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc2){
			System.out.println("E was pressed");
			this.displayNpc = new SampleCharacter("/images/storage.png",810,400,"npc");
			message = storageDude.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Pellet Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/minigame.jpg",810,400,"npc");
			message = miniGame1.getDescription();
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Big Root Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/minigame2.jpg",810,400,"npc");
			message = miniGame2.getDescription();
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==infoNpc3 && currentTown.getTownName() == "Old Yelp Town"){
			System.out.println("W was pressed");
			this.displayNpc = new SampleCharacter("/images/dummy.jpg",810,400,"npc");
			message = dummy.getDescription();
			actionMessage = "";
			storedItems = "";
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==quit){
			System.out.println("K was pressed");
			this.displayNpc = new SampleCharacter("/images/white.png",810,400,"npc");
			message =  "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
			miniGame1.setComputerPlay("null");
			actionMessage = "";
			storedItems = ""; 
			inRepair = false;
			inCrafting = false;
			//Storage.storable = false;
			Merchant.buyable = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode()==storeItem){
			System.out.println("4 was pressed");
			if(character.getEquipments().size() == 0){
				actionMessage = "You have nothing else we can store...";
			}
			else{
				actionMessage = "Press A to store the first item, S to store the second item, D to store the third item, F to store the fourth item";
				if(e.getKeyCode() == storeItem1){
					System.out.println("A was pressed");
					actionMessage = "Press J to store in slot 1, K to store in slot 2 and L to store in slot 3";
					update();
					game.repaint();
					if(e.getKeyCode() == slot1){
						System.out.println("J was pressed");
						actionMessage = "Stored " + inventory.get(0);
						storedItems = storedItems + inventory.get(0) + " ";
						Storage.storeItem(1, inventory.get(0));
						inventory.remove(0);
					}

				}

			}
			//			}
			//			miniGame1.setComputerPlay("null");
			//			update();
			//			game.repaint();
			//		}
			////		if(e.getKeyCode()==takeItem && Storage.storable == true){
			//			System.out.println("5 was pressed");
			////			if(Storage.storedItems.size() == 0){
			////				actionMessage = "You have nothing stored here...";
			////				storedItems = "The items you have stored are: ";
			////			}
			////			else{
			//				//actionMessage = "Taken out " + Storage.storedItems.get(0);
			//				//inventory.add(Storage.storedItems.get(0));
			//				//Storage.storedItems.remove(0);
			//			}
			//			storedItems = "The items you have stored are: ";
			////			for(int i=0;i < Storage.storedItems.size();i++){
			////				storedItems += Storage.storedItems.get(i)+ " ";
			////			}
			//			miniGame1.setComputerPlay("null");
			//			update();
			//			game.repaint();
			//		}
			if(e.getKeyCode()==goToPellet && currentTown.getTownName() != "Pellet Town"){
				System.out.println("B was pressed");
				this.displayNpc = new SampleCharacter("/images/white.png",810,400,"npc");
				message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
				actionMessage = "";
				storedItems = "";
				//			Storage.storable = false;
				Merchant.buyable = false;
				currentTown = townStock.getTown(townStock.PelletTown);
				town1 = true;
				town2 = false;
				town3 = false;
				inRepair = false;
				inCrafting = false;
				Sound.stopaudio();
				Sound.audio("src/towns/images/town1.wav");;
				welcomeMessage = "Welcome to Pellet Town!";
				update();
				game.repaint();
			}
			if(e.getKeyCode()==goToBigRoot && currentTown.getTownName() != "Big Root Town"){
				System.out.println("N was pressed");
				this.displayNpc = new SampleCharacter("/images/white.png",810,400,"npc");
				message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
				actionMessage = "";
				storedItems = "";
				//			Storage.storable = false;
				Merchant.buyable = false;
				currentTown = townStock.getTown(townStock.BigRootTown);
				town1 = false;
				town2 = true;
				town3 = false;
				inRepair = false;
				inCrafting = false;
				Sound.stopaudio();
				Sound.audio("src/towns/images/town2.wav");
				welcomeMessage = "Welcome to Big Root Town!";
				update();
				game.repaint();
			}
			if(e.getKeyCode()==goToOldYelp && currentTown.getTownName() != "Old Yelp Town"){
				System.out.println("M was pressed");
				this.displayNpc = new SampleCharacter("/images/white.png",810,400,"npc");
				message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
				actionMessage = "";
				storedItems = "";
				//			Storage.storable = false;
				Merchant.buyable = false;
				currentTown = townStock.getTown(townStock.OldYelpTown);
				town1 = false;
				town2 = false;
				town3 = true;
				inRepair = false;
				inCrafting = false;
				Sound.stopaudio();
				Sound.audio("src/towns/images/town3.wav");
				welcomeMessage = "Welcome to Old Yelp Town!";
				update();
				game.repaint();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

