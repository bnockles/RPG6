package towns;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import directors.Game;
import directors.Screen;


public class HfengScreen extends Screen implements KeyListener {
	//Testing from PC 
	ArrayList<Merchant> listOfMerchant = new ArrayList<Merchant>();
	ArrayList<Item> storeInventory_Kathy = new ArrayList<Item>();
	ArrayList<Item> storeInventory_Rebecca = new ArrayList<Item>();
	ArrayList<Store> listOfStore = new ArrayList<Store>();
	ArrayList<Item> playerInventory = new ArrayList<Item>();
	
	// KeyEvent Controls
	public static final int SHOP_1 = KeyEvent.VK_F1;
	public static final int SHOP_2 = KeyEvent.VK_F2;
	public static final int INVENTORY = KeyEvent.VK_I;
	public static final int CLOSE = KeyEvent.VK_ESCAPE;
	public static final int NEXT_PAGE = KeyEvent.VK_RIGHT;
	public static final int PREVIOUS_PAGE = KeyEvent.VK_LEFT;
	public static final int STORE_BUY = KeyEvent.VK_B; 
	public static final int STORE_SELL = KeyEvent.VK_S; 
	public static final int TOP_LEFT_ITEM = KeyEvent.VK_NUMPAD7;
	public static final int TOP_CENTER_ITEM = KeyEvent.VK_NUMPAD8;
	public static final int TOP_RIGHT_ITEM = KeyEvent.VK_NUMPAD9;
	public static final int MIDDLE_LEFT_ITEM = KeyEvent.VK_NUMPAD4;
	public static final int MIDDLE_CENTER_ITEM = KeyEvent.VK_NUMPAD5;
	public static final int MIDDLE_RIGHT_ITEM = KeyEvent.VK_NUMPAD6;
	public static final int BOTTOM_LEFT_ITEM = KeyEvent.VK_NUMPAD1;
	public static final int BOTTOM_CENTER_ITEM = KeyEvent.VK_NUMPAD2;
	public static final int BOTTOM_RIGHT_ITEM = KeyEvent.VK_NUMPAD3;
	public static final int GO_BACK = KeyEvent.VK_BACK_SPACE;
	public static final int YES = KeyEvent.VK_Y;
	
	//
	public static final int NUMBER_OF_POTIONS = (int) (Math.random()*10)+7;
	public static final int NUMBER_OF_EQUIPMENTS = (int) (Math.random()*10)+10;
		
	// GUI control
	public static boolean SHOP_1_OPEN = false;
	public static boolean SHOP_2_OPEN = false;
	public static boolean INVENTORY_OPEN = false;
	public static boolean BUY_MENU = false;
	public static boolean SELL_MENU = false;
	public static boolean BUY_WARNING = false;
	public static boolean SELL_WARNING = false;
	
	// activates / disables KeyPressed Events
	public static boolean RUN_F1 = false;
	public static boolean RUN_F2 = false;
	public static boolean RUN_I = false;
	public static boolean RUN_ARROW_KEYS = false;
	public static boolean RUN_ESC = false;
	public static boolean RUN_NUMBERS = false;
	public static boolean RUN_B = true;
	public static boolean RUN_S = true;
	
	//
	public static boolean ERROR_MONEY = false;
	public static int PLAYER_WEALTH = 5000;
	
	// Item Display Variables
	public static int ITEM_NUMBER = 0;
	public static int CURRENT_PAGE = 1;
	public static int START = 1;
	public static int END = 9;
	
	public HfengScreen(Game game){
		super(game);
		
		listOfMerchant.add(new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true));
		listOfMerchant.add(new Merchant("Rebecca", "Female", "Rebecca is the merchant for Big Root Town, she sells wepaons!", true));
		listOfMerchant.add(new Merchant("Karmen", "Female", "Karmen is the merchant for Old Yelelr Town, she sells armor!", true));
			
		for(int i = 0; i < NUMBER_OF_POTIONS; i++){
			storeInventory_Kathy.add(potionStock.consumableStock(i));
		}
		for(int i = 0; i < NUMBER_OF_EQUIPMENTS; i++){
			storeInventory_Rebecca.add(equipStock.equipStocks(i));
		}
		
		listOfStore.add(new Store("Kathy's Potion Shop","A shop with a wide variety of potions.",storeInventory_Kathy));
		listOfStore.add(new Store("Rebecca's Armory","The finest armor and weapons in town!",storeInventory_Rebecca));
	}
	
	public void paintScreen(Graphics2D g2){
		Color TRANSPARENT_BUY_MENU = new Color(34, 102, 102, 225);
		Color GOLD = new Color(255, 215, 0);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
		int x = 100;
		int y = 200;

		try{
			if(SHOP_1_OPEN == false && SHOP_2_OPEN == false && INVENTORY_OPEN == false){
				RUN_F1 = true;
				RUN_F2 = true;
				RUN_I = true;
				BUY_WARNING = false;
				BUY_MENU = false;
				SELL_MENU = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				g2.drawString("Press [F1] to visit Kathy's Potion Shop", x, y);
				y+= 100;
				g2.drawString("Press [F2] to visit Rebecca's Armory", x, y);
				y+= 100;
				g2.drawString("Press [I] to open your inventory", x, y);
				y-= 200;
				g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
			}
			// Opening Kathy's Potion Shop.
			if(SHOP_1_OPEN == true){
				RUN_ESC = true;
				RUN_F2 = false;
				RUN_I = false;
				SHOP_2_OPEN = false;
				INVENTORY_OPEN = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				y-= 50;
				g2.drawString("Press [ESC] to leave the store", x, y);
				y+= 50;
				g2.drawString("Hi, welcome to my potion shop. What would you like to do?", x, y);
				y+= 50;
				g2.drawString("Press [B] buy potions.", x, y);
				y+= 25;
				g2.drawString("Press [S] to sell your items.", x, y);
				y-= 75;
				if(BUY_MENU == true){
					RUN_S = false;
					RUN_NUMBERS = true;
					g2.setColor(Color.white);
					g2.fillRect(0, 0, width, height);
					g2.setColor(Color.black);
					y-= 50;
					g2.drawString("Press [ESC] to leave the store", x, y);
					y+= 450;
					g2.setFont(new Font("Comic Sans", Font.PLAIN, 17));
					if(storeInventory_Kathy.size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (storeInventory_Kathy.size() / 9 + 1), x, y);
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (storeInventory_Kathy.size() / 9), x, y);
					}
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					y+= 50;
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 450;
					if(storeInventory_Kathy.size() >= 9){
						if(storeInventory_Kathy.size() > 9){
							RUN_ARROW_KEYS = true;
						}
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							g2.drawString(storeInventory_Kathy.get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(storeInventory_Kathy.get(r-1).getDescription(), x, y);
							if(storeInventory_Kathy.get(r-1).getReq().length() > 40){
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(storeInventory_Kathy.get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(storeInventory_Kathy.get(r-1).getReq().substring(40, storeInventory_Kathy.get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(storeInventory_Kathy.get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						
						}
					}
					else{
						if(storeInventory_Kathy.size() <= 8 && storeInventory_Kathy.size() >= 1){
							END = storeInventory_Kathy.size();
							for(int r = START; r < END + 1; r++){
								if(r % 9 != 1 && (r-1)%3 == 0){
									y+= 125;
									x-= 750;
								}
								g2.drawString(storeInventory_Kathy.get(r-1).getName(), x, y);
								g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
								y+= 25;
								g2.drawString(storeInventory_Kathy.get(r-1).getDescription(), x, y);
								if(storeInventory_Kathy.get(r-1).getReq().length() > 40){
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(storeInventory_Kathy.get(r-1).getReq().substring(0, 40), x, y);
									y+= 25;
									g2.drawString(storeInventory_Kathy.get(r-1).getReq().substring(40, storeInventory_Kathy.get(r-1).getReq().length()), x, y);
								}
								else{
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(storeInventory_Kathy.get(r-1).getReq(), x, y);
									y+= 25;
								}
								g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
								y-= 75;
								x+= 250;	
								g2.setColor(Color.black);
							}
						}
						else{
							RUN_NUMBERS = false;
							g2.setColor(Color.red);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
							g2.drawString("Whoa! Looks like there are no more potions.", x, y+50);
							g2.setColor(Color.black);
						}
						
					}
					if(BUY_WARNING == true){
						RUN_NUMBERS = false;
						RUN_ARROW_KEYS = false;
						RUN_ESC = false;
						if(ITEM_NUMBER <= storeInventory_Kathy.size()){
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(GOLD);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
							g2.drawString(storeInventory_Kathy.get(ITEM_NUMBER-1).getName() + " costs " + NumberFormat.getIntegerInstance().format(storeInventory_Kathy.get(ITEM_NUMBER-1).getItemBuyPrice()) + " gold coins.", 200, 200);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 30));
							g2.drawString("Do you want to buy this?", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							g2.drawString("Press [Y] to buy " + storeInventory_Kathy.get(ITEM_NUMBER-1).getName() + ".", 200, 350);
							g2.drawString("Press [Backspace] to return to the shop.", 200, 400);
						}
						else{
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
							g2.drawString("Um, there is no item #" + ITEM_NUMBER + ". Press [Backspace] to go back.", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		
						}
					}
					if(ERROR_MONEY == true){
						RUN_ESC = false;
						BUY_WARNING = false;
						g2.setColor(TRANSPARENT_BUY_MENU);
						g2.fillRect(0, 0, width, height);
						g2.setColor(GOLD);
						g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
						g2.drawString("Um, you don't have enough gold coins for " + storeInventory_Kathy.get(ITEM_NUMBER-1) + ".", 200, 250);
						g2.setColor(Color.BLACK);
						g2.drawString("Press [Backspace] to go back.", 200, 325);
						g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
					}
				}
				if(SELL_MENU == true){
					RUN_B = false;
					if(playerInventory.size() > 0){
						RUN_NUMBERS = true;
					}
					else{
						RUN_NUMBERS = false;
					}
					g2.setColor(Color.white);
					g2.fillRect(0, 0, width, height);
					g2.setColor(Color.black);
					y-= 50;
					g2.drawString("Press [ESC] to exit Inventory.", x, y);			
					y+= 450;
					g2.setFont(new Font("Comic Sans", Font.PLAIN, 17));
					if(playerInventory.size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9 + 1), x, y);
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9), x, y);
					}
					y+=50;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 450;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					if(playerInventory.size() >= 9){
						if(playerInventory.size() > 9){
							RUN_ARROW_KEYS = true;
						}
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							g2.drawString(playerInventory.get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
							if(playerInventory.get(r-1).getReq().length() > 40){
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						
						}
					}
					else{
						if(playerInventory.size() <= 8 && playerInventory.size() >= 1){
							END = playerInventory.size();
							for(int r = START; r < END + 1; r++){
								if(r % 9 != 1 && (r-1)%3 == 0){
									y+= 125;
									x-= 750;
								}
								g2.drawString(playerInventory.get(r-1).getName(), x, y);
								g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
								if(playerInventory.get(r-1).getReq().length() > 40){
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
								}
								else{
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq(), x, y);
									y+= 25;
								}
								g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
								y-= 75;
								x+= 250;	
								g2.setColor(Color.black);
							}
						}
						else{
							g2.setColor(Color.red);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
							g2.drawString("Looks like my inventory is empty.", x, y+50);
							g2.setColor(Color.black);
						}
					}
					if(SELL_WARNING == true){
						RUN_NUMBERS = false;
						RUN_ARROW_KEYS = false;
						RUN_ESC = false;
						if(ITEM_NUMBER <= playerInventory.size()){
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(GOLD);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
							g2.drawString(playerInventory.get(ITEM_NUMBER-1).getName() + " sells for " + NumberFormat.getIntegerInstance().format(playerInventory.get(ITEM_NUMBER-1).getItemSellPrice()) + " gold coins.", 200, 200);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 30));
							g2.drawString("Do you want to sell this?", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							g2.drawString("Press [Y] to sell " + playerInventory.get(ITEM_NUMBER-1).getName() + ".", 200, 350);
							g2.drawString("Press [Backspace] to cancel.", 200, 400);
						}
						else{
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
							g2.drawString("Um, there is no item #" + ITEM_NUMBER + ". Press [Backspace] to go back.", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		
						}
					}
				}
			}
			
			
			
			
			// Opening Rebecca's Armory.
			if(SHOP_2_OPEN == true){
				RUN_ESC = true;
				RUN_F1 = false;
				RUN_I = false;
				SHOP_1_OPEN = false;
				INVENTORY_OPEN = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				y-= 50;
				g2.drawString("Press [ESC] to leave the store", x, y);
				y+= 50;
				g2.drawString("Hi, welcome to my armory. What would you like to do?", x, y);
				y+= 50;
				g2.drawString("Press [B] buy armor and weapons.", x, y);
				y+= 25;
				g2.drawString("Press [S] to sell your items.", x, y);
				y-= 75;
				if(BUY_MENU == true){
					RUN_NUMBERS = true;
					g2.setColor(Color.white);
					g2.fillRect(0, 0, width, height);
					g2.setColor(Color.black);
					y-= 50;
					g2.drawString("Press [ESC] to leave the store", x, y);
					y+= 450;
					g2.setFont(new Font("Comic Sans", Font.PLAIN, 17));
					if(storeInventory_Rebecca.size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (storeInventory_Rebecca.size() / 9 + 1), x, y);
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (storeInventory_Rebecca.size() / 9), x, y);
					}
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					y+= 50;
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 450;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					if(storeInventory_Rebecca.size() >= 9){
						if(storeInventory_Rebecca.size() > 9){
							RUN_ARROW_KEYS = true;
						}
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							g2.drawString(storeInventory_Rebecca.get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(storeInventory_Rebecca.get(r-1).getDescription(), x, y);
							if(storeInventory_Rebecca.get(r-1).getReq().length() > 40){
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(storeInventory_Rebecca.get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(storeInventory_Rebecca.get(r-1).getReq().substring(40, storeInventory_Rebecca.get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(storeInventory_Rebecca.get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						
						}
					}
					else{
						if(storeInventory_Rebecca.size() <= 8 && storeInventory_Rebecca.size() >= 1){
							END = storeInventory_Rebecca.size();
							for(int r = START; r < END + 1; r++){
								if(r % 9 != 1 && (r-1)%3 == 0){
									y+= 125;
									x-= 750;
								}
								g2.drawString(storeInventory_Rebecca.get(r-1).getName(), x, y);
								g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
								y+= 25;
								g2.drawString(storeInventory_Rebecca.get(r-1).getDescription(), x, y);
								if(storeInventory_Rebecca.get(r-1).getReq().length() > 40){
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(storeInventory_Rebecca.get(r-1).getReq().substring(0, 40), x, y);
									y+= 25;
									g2.drawString(storeInventory_Rebecca.get(r-1).getReq().substring(40, storeInventory_Rebecca.get(r-1).getReq().length()), x, y);
								}
								else{
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(storeInventory_Rebecca.get(r-1).getReq(), x, y);
									y+= 25;
								}
								g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
								y-= 75;
								x+= 250;	
								g2.setColor(Color.black);
							}
						}
						else{
							RUN_NUMBERS = false;
							g2.setColor(Color.red);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
							g2.drawString("Whoa! Looks like I have run out of armor and weapons.", x, y+50);
							g2.setColor(Color.black);
						}
						
					}
					if(BUY_WARNING == true){
						RUN_NUMBERS = false;
						RUN_ARROW_KEYS = false;
						RUN_ESC = false;
						if(ITEM_NUMBER <= storeInventory_Rebecca.size()){
							//RUN_BUY = true;
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(GOLD);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
							g2.drawString(storeInventory_Rebecca.get(ITEM_NUMBER-1).getName() + " costs " + NumberFormat.getIntegerInstance().format(storeInventory_Rebecca.get(ITEM_NUMBER-1).getItemBuyPrice()) + " gold coins.", 200, 200);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 30));
							g2.drawString("Do you want to buy this?", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							g2.drawString("Press [Y] to buy " + storeInventory_Rebecca.get(ITEM_NUMBER-1).getName() + ".", 200, 350);
							g2.drawString("Press [Backspace] to return to the shop.", 200, 400);
						}
						else{
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
							g2.drawString("Um, there is no item #" + ITEM_NUMBER + ". Press [Backspace] to go back.", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		
						}
					}
					if(ERROR_MONEY == true){
						RUN_ESC = false;
						BUY_WARNING = false;
						g2.setColor(TRANSPARENT_BUY_MENU);
						g2.fillRect(0, 0, width, height);
						g2.setColor(GOLD);
						g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
						g2.drawString("Um, you don't have enough gold coins for " + storeInventory_Rebecca.get(ITEM_NUMBER-1) + ".", 200, 250);
						g2.setColor(Color.BLACK);
						g2.drawString("Press [Backspace] to go back.", 200, 325);
						g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
					}
				}
				if(SELL_MENU == true){
					if(playerInventory.size() > 0){
						RUN_NUMBERS = true;
					}
					else{
						RUN_NUMBERS = false;
					}
					g2.setColor(Color.white);
					g2.fillRect(0, 0, width, height);
					g2.setColor(Color.black);
					y-= 50;
					g2.drawString("Press [ESC] to exit Inventory.", x, y);			
					y+= 450;
					g2.setFont(new Font("Comic Sans", Font.PLAIN, 17));
					if(playerInventory.size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9 + 1), x, y);
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9), x, y);
					}
					y+=50;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 450;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					if(playerInventory.size() >= 9){
						if(playerInventory.size() > 9){
							RUN_ARROW_KEYS = true;
						}
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							g2.drawString(playerInventory.get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
							if(playerInventory.get(r-1).getReq().length() > 40){
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						
						}
					}
					else{
						if(playerInventory.size() <= 8 && playerInventory.size() >= 1){
							END = playerInventory.size();
							for(int r = START; r < END + 1; r++){
								if(r % 9 != 1 && (r-1)%3 == 0){
									y+= 125;
									x-= 750;
								}
								g2.drawString(playerInventory.get(r-1).getName(), x, y);
								g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
								if(playerInventory.get(r-1).getReq().length() > 40){
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
								}
								else{
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(playerInventory.get(r-1).getReq(), x, y);
									y+= 25;
								}
								g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
								y-= 75;
								x+= 250;	
								g2.setColor(Color.black);
							}
						}
						else{
							g2.setColor(Color.red);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
							g2.drawString("Looks like my inventory is empty.", x, y+50);
							g2.setColor(Color.black);
						}
					}
					if(SELL_WARNING == true){
						RUN_NUMBERS = false;
						RUN_ARROW_KEYS = false;
						RUN_ESC = false;
						if(ITEM_NUMBER <= playerInventory.size()){
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(GOLD);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
							g2.drawString(playerInventory.get(ITEM_NUMBER-1).getName() + " sells for " + NumberFormat.getIntegerInstance().format(playerInventory.get(ITEM_NUMBER-1).getItemSellPrice()) + " gold coins.", 200, 200);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 30));
							g2.drawString("Do you want to sell this?", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							g2.drawString("Press [Y] to sell " + playerInventory.get(ITEM_NUMBER-1).getName() + ".", 200, 350);
							g2.drawString("Press [Backspace] to cancel.", 200, 400);
						}
						else{
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
							g2.drawString("Um, there is no item #" + ITEM_NUMBER + ". Press [Backspace] to go back.", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		
						}
					}
				}
			}
			if(INVENTORY_OPEN == true){
				RUN_ESC = true;
				RUN_F1 = false;
				RUN_F2 = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				y-= 50;
				g2.drawString("Press [ESC] to exit Inventory.", x, y);
				y+= 50;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 17));
				y+= 450;
				if(playerInventory.size() > 0){
					if(playerInventory.size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9 + 1), x, y);
						y+= 50;
						g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
						g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
						y-= 50;
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9), x, y);
						y+= 50;
						g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
						g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
						y-= 50;
					}
				}
				else{
					g2.drawString("Currently displaying page 0 of 0", x, y);
					y+= 50;
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 50;
				}
				y-= 450;
				g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
				if(playerInventory.size() >= 9){
					if(playerInventory.size() > 9){
						RUN_ARROW_KEYS = true;
					}
					for(int r = START; r < END + 1; r++){
						if(r % 9 != 1 && (r-1)%3 == 0){
							y+= 125;
							x-= 750;
						}
						g2.drawString(playerInventory.get(r-1).getName(), x, y);
						g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
						y+= 25;
						g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
						if(playerInventory.get(r-1).getReq().length() > 40){
							g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
						}
						else{
							g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getReq(), x, y);
							y+= 25;
						}
						g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
						y-= 75;
						x+= 250;	
						g2.setColor(Color.black);
					
					}
				}
				else{
					if(playerInventory.size() <= 8 && playerInventory.size() >= 1){
						END = playerInventory.size();
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							g2.drawString(playerInventory.get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(playerInventory.get(r-1).getDescription(), x, y);
							if(playerInventory.get(r-1).getReq().length() > 40){
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq().substring(40, playerInventory.get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(playerInventory.get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						}
					}
					else{
						g2.setColor(Color.red);
						g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
						g2.drawString("Looks like my inventory is empty.", x, y+50);
						g2.setColor(Color.black);
					}
				}
			}
		}
		catch(Exception e){
			
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == CLOSE && RUN_ESC == true){
			SHOP_1_OPEN = false;
			SHOP_2_OPEN = false;
			INVENTORY_OPEN = false;
			BUY_WARNING = false;
			BUY_MENU = false;
			SELL_WARNING = false;
			SELL_MENU = false;
			RUN_B = true;
			RUN_S = true;
			START = 1;
			END = 9;
			CURRENT_PAGE = 1;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == SHOP_1 && RUN_F1 == true){
			SHOP_1_OPEN = true;
			SHOP_2_OPEN = false;
			INVENTORY_OPEN = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == SHOP_2 && RUN_F2 == true){
			SHOP_1_OPEN = false;
			SHOP_2_OPEN = true;
			INVENTORY_OPEN = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == INVENTORY && RUN_I == true){
			SHOP_1_OPEN = false;
			SHOP_2_OPEN = false;
			INVENTORY_OPEN = true;
			update();
			game.repaint();
		}	
		if(e.getKeyCode() == NEXT_PAGE && RUN_ARROW_KEYS == true){
			if(BUY_MENU == true){
				if(SHOP_1_OPEN == true){
					if(END < storeInventory_Kathy.size() && storeInventory_Kathy.size() > 9){
						CURRENT_PAGE++;
						START += 9;
						if(storeInventory_Kathy.size() % 9 !=0 && CURRENT_PAGE == (storeInventory_Kathy.size() / 9) + 1){
							END = storeInventory_Kathy.size();
						}
						else{
							if(storeInventory_Kathy.size() % 9 == 0 && CURRENT_PAGE == (storeInventory_Kathy.size() / 9)){
								END = storeInventory_Kathy.size();
							}
							else{
								END += 9;
							}
						}		
						update();
						game.repaint();
					}
				}
				if(SHOP_2_OPEN == true){
					if(END < storeInventory_Rebecca.size() && storeInventory_Rebecca.size() > 9){
						CURRENT_PAGE++;
						START += 9;
						if(storeInventory_Rebecca.size() % 9 !=0 && CURRENT_PAGE == (storeInventory_Rebecca.size() / 9) + 1){
							END = storeInventory_Rebecca.size();
						}
						else{
							if(storeInventory_Rebecca.size() % 9 == 0 && CURRENT_PAGE == (storeInventory_Rebecca.size() / 9)){
								END = storeInventory_Rebecca.size();
							}
							else{
								END += 9;
							}
						}		
						update();
						game.repaint();
					}
				}
			}
			if(SELL_MENU == true){
				if(SHOP_1_OPEN == true){
					if(END < playerInventory.size() && playerInventory.size() > 9){
						CURRENT_PAGE++;
						START += 9;
						if(playerInventory.size() % 9 !=0 && CURRENT_PAGE == (playerInventory.size() / 9) + 1){
							END = playerInventory.size();
						}
						else{
							if(playerInventory.size() % 9 == 0 && CURRENT_PAGE == (playerInventory.size() / 9)){
								END = playerInventory.size();
							}
							else{
								END += 9;
							}
						}		
						update();
						game.repaint();
					}
				}
				if(SHOP_2_OPEN == true){
					if(END < playerInventory.size() && playerInventory.size() > 9){
						CURRENT_PAGE++;
						START += 9;
						if(playerInventory.size() % 9 !=0 && CURRENT_PAGE == (playerInventory.size() / 9) + 1){
							END = playerInventory.size();
						}
						else{
							if(playerInventory.size() % 9 == 0 && CURRENT_PAGE == (playerInventory.size() / 9)){
								END = playerInventory.size();
							}
							else{
								END += 9;
							}
						}		
						update();
						game.repaint();
					}
				}
			}
			if(INVENTORY_OPEN == true){
				if(END < playerInventory.size() && playerInventory.size() > 9){
					CURRENT_PAGE++;
					START += 9;
					if(playerInventory.size() % 9 !=0 && CURRENT_PAGE == (playerInventory.size() / 9) + 1){
						END = playerInventory.size();
					}
					else{
						if(playerInventory.size() % 9 == 0 && CURRENT_PAGE == (playerInventory.size() / 9)){
							END = playerInventory.size();
						}
						else{
							END += 9;
						}
					}		
					update();
					game.repaint();
				}
			}
		}
		if(e.getKeyCode() == PREVIOUS_PAGE){
			if(START != 1 && RUN_ARROW_KEYS == true){
				CURRENT_PAGE--;
				START -= 9;
				END = START + 8;
				update();
				game.repaint();
			}	
		}
		if(e.getKeyCode() == STORE_BUY && RUN_B == true){
			BUY_MENU = true;
			RUN_S = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == STORE_SELL && RUN_S == true){
			SELL_MENU = true;
			RUN_B = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == TOP_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
				update();
				game.repaint();
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
				update();
				game.repaint();
			}
			ITEM_NUMBER = START;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == TOP_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 1;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == TOP_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 2;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == MIDDLE_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 3;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == MIDDLE_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 4;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == MIDDLE_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 5;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == BOTTOM_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 6;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == BOTTOM_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 7;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == BOTTOM_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 8;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == GO_BACK){
			ERROR_MONEY = false;
			BUY_WARNING = false;
			SELL_WARNING = false;
			RUN_NUMBERS = true;
			RUN_ARROW_KEYS = true;
			update();
			game.repaint();

		}
		if(e.getKeyCode() == YES ){
			if(SHOP_1_OPEN == true){
				if(BUY_MENU == true && BUY_WARNING == true){
					if(storeInventory_Kathy.size() > 0){
						if(storeInventory_Kathy.get(ITEM_NUMBER-1).getItemBuyPrice() < PLAYER_WEALTH){
							playerInventory.add(storeInventory_Kathy.get(ITEM_NUMBER-1));
							PLAYER_WEALTH = PLAYER_WEALTH - storeInventory_Kathy.get(ITEM_NUMBER-1).getItemBuyPrice();
							storeInventory_Kathy.remove(ITEM_NUMBER-1);
							if(END % 9 != 0){
								END--;
							}
							BUY_WARNING = false;
							RUN_ARROW_KEYS = true;
						}
						else{
							BUY_WARNING = false;
							ERROR_MONEY = true;
							RUN_ARROW_KEYS = false;
							update();
							game.repaint();
						}
					}
					if(CURRENT_PAGE * 9 - 8 > storeInventory_Kathy.size()){
						CURRENT_PAGE--;
						START -= 9;
						END = START + 8;
					}
					update();
					game.repaint();
				}
				if(SELL_MENU == true && SELL_WARNING == true){
					storeInventory_Kathy.add(playerInventory.get(ITEM_NUMBER-1));
					PLAYER_WEALTH = PLAYER_WEALTH + playerInventory.get(ITEM_NUMBER-1).getItemSellPrice();
					playerInventory.remove(ITEM_NUMBER-1);
					if(END % 9 != 0){
						END--;
					}
					SELL_WARNING = false;
					RUN_ARROW_KEYS = true;
				
					if(CURRENT_PAGE * 9 - 8 > playerInventory.size()){
						CURRENT_PAGE--;
						START -= 9;
						END = START + 8;
					}
					update();
					game.repaint();
				}	
			}
		
			if(SHOP_2_OPEN == true){
				if(BUY_MENU == true && BUY_WARNING == true){
					if(storeInventory_Rebecca.size() > 0){
						if(storeInventory_Rebecca.get(ITEM_NUMBER-1).getItemBuyPrice() < PLAYER_WEALTH){
							PLAYER_WEALTH = PLAYER_WEALTH - storeInventory_Rebecca.get(ITEM_NUMBER-1).getItemBuyPrice();
							playerInventory.add(storeInventory_Rebecca.get(ITEM_NUMBER-1));
							storeInventory_Rebecca.remove(ITEM_NUMBER-1);
							if(END % 9 != 0){
								END--;
							}
							BUY_WARNING = false;
							RUN_ARROW_KEYS = true;
						}
						else{
							BUY_WARNING = false;
							ERROR_MONEY = true;
							RUN_ARROW_KEYS = false;
							update();
							game.repaint();
						}
					}
					if(CURRENT_PAGE * 9 - 8 > storeInventory_Rebecca.size()){
						CURRENT_PAGE--;
						START -= 9;
						END = START + 8;
					}
					update();
					game.repaint();
				}
				if(SELL_MENU == true && SELL_WARNING == true){
					storeInventory_Rebecca.add(playerInventory.get(ITEM_NUMBER-1));
					PLAYER_WEALTH = PLAYER_WEALTH + playerInventory.get(ITEM_NUMBER-1).getItemSellPrice();
					playerInventory.remove(ITEM_NUMBER-1);
					if(END % 9 != 0){
						END--;
					}
					SELL_WARNING = false;
					RUN_ARROW_KEYS = true;
				
					if(CURRENT_PAGE * 9 - 8 > playerInventory.size()){
						CURRENT_PAGE--;
						START -= 9;
						END = START + 8;
					}
					update();
					game.repaint();
				}
			}
			
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	

	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

}