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


public class HfengTestScreen extends Screen implements KeyListener {
	
	ArrayList<Merchant> listOfMerchant = new ArrayList<Merchant>();
	ArrayList<Store> listOfStore = new ArrayList<Store>();
	ArrayList<Item> playerInventory = new ArrayList<Item>();
	
	ArrayList<Item> storeInventory_Kathy = new ArrayList<Item>();
	ArrayList<Item> storeInventory_Rebecca = new ArrayList<Item>();
	ArrayList<Item> storeInventory_Karmen = new ArrayList<Item>();
	
	// KeyEvent Controls
	public static final int SHOP_1 = KeyEvent.VK_F1;
	public static final int SHOP_2 = KeyEvent.VK_F2;
	public static final int SHOP_3 = KeyEvent.VK_F3;
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
	public static final int NUMBER_OF_POTIONS = (int) (Math.random()*7)+10;
	public static final int NUMBER_OF_WEAPONS = (int) (Math.random()*10)+15;
	public static final int NUMBER_OF_ARMOR = (int) (Math.random()*5)+10;
		
	// GUI control
	public static boolean SHOP_OPEN = false;
	public static boolean INVENTORY_OPEN = false;
	public static boolean BUY_MENU = false;
	public static boolean SELL_MENU = false;
	public static boolean BUY_WARNING = false;
	public static boolean SELL_WARNING = false;
	
	// activates / disables KeyPressed Events
	public static boolean RUN_FUNCTION_KEYS = false;
	public static boolean RUN_I = false;
	public static boolean RUN_ARROW_KEYS = false;
	public static boolean RUN_ESC = false;
	public static boolean RUN_NUMBERS = false;
	public static boolean RUN_B = true;
	public static boolean RUN_S = true;
	
	//
	public static boolean ERROR_MONEY = false;
	public static int PLAYER_WEALTH = 5000;
	public static int SHOP_NUMBER = 0;
	
	// Item Display Variables
	public static int ITEM_NUMBER = 0;
	public static int CURRENT_PAGE = 1;
	public static int START = 1;
	public static int END = 9;
	
	public HfengTestScreen(Game game){
		super(game);
		
		listOfMerchant.add(new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true));
		listOfMerchant.add(new Merchant("Rebecca", "Female", "Rebecca is the merchant for Big Root Town, she sells wepaons!", true));
		listOfMerchant.add(new Merchant("Karmen", "Female", "Karmen is the merchant for Old Yelelr Town, she sells armor!", true));
			
		for(int i = 0; i < NUMBER_OF_POTIONS; i++){
			storeInventory_Kathy.add(potionStock.consumableStock(i));
		}
		for(int i = 0; i < NUMBER_OF_WEAPONS; i++){
			storeInventory_Rebecca.add(equipStock.equipStocks(i));

		}
		for(int i = 0; i < NUMBER_OF_ARMOR; i++){
			storeInventory_Karmen.add(equipStock.equipStocks(i+32));
		}
		
		listOfStore.add(new Store("Kathy's Potion Shop","A shop with a wide variety of potions.",storeInventory_Kathy));
		listOfStore.add(new Store("Rebecca's Weapons","The finest weapons in town!",storeInventory_Rebecca));
		listOfStore.add(new Store("Karmen's Armory","The sturdiest armor in all the 9 realms.",storeInventory_Karmen));
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
			if(SHOP_OPEN == false && INVENTORY_OPEN == false){
				RUN_FUNCTION_KEYS = true;
				RUN_I = true;
				BUY_WARNING = false;
				BUY_MENU = false;
				SELL_MENU = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				for(int i = 0; i < listOfMerchant.size(); i++){
					g2.drawString("Press [F" + (i+1) +"] to visit " + listOfStore.get(i).getName(), x, y);
					y+= 75;
				}
				g2.drawString("Press [I] to open your inventory", x, y);
				y-= listOfMerchant.size() * 75;
				g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
			}
			
			// Shop
			if(SHOP_OPEN == true){
				RUN_FUNCTION_KEYS = false;
				RUN_ESC = true;
				RUN_I = false;
				INVENTORY_OPEN = false;
				g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
				y-= 50;
				g2.drawString("Press [ESC] to leave the store", x, y);
				y+= 50;
				g2.drawString("Hi, welcome to " + listOfStore.get(SHOP_NUMBER).getName() + ". What would you like to do?", x, y);
				y+= 50;
				g2.drawString("Press [B] buy items.", x, y);
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
					if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() % 9 !=0){
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (listOfStore.get(SHOP_NUMBER).getStoreInventory().size() / 9 + 1), x, y);
					}
					else{
						g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (listOfStore.get(SHOP_NUMBER).getStoreInventory().size() / 9), x, y);
					}
					g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
					y+= 50;
					g2.drawString("You have " + NumberFormat.getIntegerInstance().format(PLAYER_WEALTH) + " gold coins.", x, y);
					y-= 450;
					
					if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() >= 9){
						
						if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() > 9){
							
							RUN_ARROW_KEYS = true;
						}
						for(int r = START; r < END + 1; r++){
							if(r % 9 != 1 && (r-1)%3 == 0){
								y+= 125;
								x-= 750;
							}
							
							g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getName(), x, y);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
							y+= 25;
							g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getDescription(), x, y);
							
							if(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().length() > 40){
								
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().substring(0, 40), x, y);
								y+= 25;
								g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().substring(40, listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().length()), x, y);
							}
							else{
								g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
								y+= 25;
								g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq(), x, y);
								y+= 25;
							}
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							y-= 75;
							x+= 250;	
							g2.setColor(Color.black);
						
						}
					}
					else{
						if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() <= 8 && listOfStore.get(SHOP_NUMBER).getStoreInventory().size() >= 1){
							END = listOfStore.get(SHOP_NUMBER).getStoreInventory().size();
							for(int r = START; r < END + 1; r++){
								if(r % 9 != 1 && (r-1)%3 == 0){
									y+= 125;
									x-= 750;
								}
								g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getName(), x, y);
								g2.setFont(new Font("Comic Sans", Font.BOLD, 12));
								y+= 25;
								g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getDescription(), x, y);
								if(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().length() > 40){
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().substring(0, 40), x, y);
									y+= 25;
									g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().substring(40, listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq().length()), x, y);
								}
								else{
									g2.setFont(new Font("Comic Sans", Font.ITALIC, 12));
									y+= 25;
									g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(r-1).getReq(), x, y);
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
							g2.drawString("Whoa! Looks like there are no more items available.", x, y+50);
							g2.setColor(Color.black);
						}
						
					}
					if(BUY_WARNING == true){
						RUN_NUMBERS = false;
						RUN_ARROW_KEYS = false;
						RUN_ESC = false;
						if(ITEM_NUMBER <= listOfStore.get(SHOP_NUMBER).getStoreInventory().size()){
							g2.setColor(TRANSPARENT_BUY_MENU);
							g2.fillRect(0, 0, width, height);
							g2.setColor(GOLD);
							g2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
							g2.drawString(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getName() + " costs " + NumberFormat.getIntegerInstance().format(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getItemBuyPrice()) + " gold coins.", 200, 200);
							g2.setColor(Color.black);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 30));
							g2.drawString("Do you want to buy this?", 200, 250);
							g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
							g2.drawString("Press [Y] to buy " + listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getName() + ".", 200, 350);
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
						g2.drawString("Um, you don't have enough gold coins for " + listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1) + ".", 200, 250);
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
					if(playerInventory.size() == 0){
						g2.drawString("Currently displaying page 0 of 0", x, y);
					}
					else{
						if(playerInventory.size() % 9 !=0){
							g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9 + 1), x, y);
						}
						else{
							g2.drawString("Currently displaying page " + CURRENT_PAGE + " of " + (playerInventory.size() / 9), x, y);
						}
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
			
			
			// RUN INVENTORY
			if(INVENTORY_OPEN == true){
				RUN_ESC = true;
				RUN_FUNCTION_KEYS = false;
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
			SHOP_OPEN = false;
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
//			update();
//			game.repaint();
		}
		if(e.getKeyCode() == SHOP_1 && RUN_FUNCTION_KEYS == true){
			SHOP_OPEN = true;
			INVENTORY_OPEN = false;
			SHOP_NUMBER = 0;
//			update();
//			game.repaint();
		}
		if(e.getKeyCode() == SHOP_2 && RUN_FUNCTION_KEYS == true){
			SHOP_OPEN = true;
			INVENTORY_OPEN = false;
			SHOP_NUMBER = 1;
//			update();
//			game.repaint();
		}
		if(e.getKeyCode() == SHOP_3 && RUN_FUNCTION_KEYS == true){
			SHOP_OPEN = true;
			INVENTORY_OPEN = false;
			SHOP_NUMBER = 2;
//			update();
//			game.repaint();
		}
		if(e.getKeyCode() == INVENTORY && RUN_I == true){
			SHOP_OPEN = false;
			INVENTORY_OPEN = true;
//			update();
//			game.repaint();
		}	
		if(e.getKeyCode() == NEXT_PAGE && RUN_ARROW_KEYS == true){
			if(BUY_MENU == true){
				if(END < listOfStore.get(SHOP_NUMBER).getStoreInventory().size() && listOfStore.get(SHOP_NUMBER).getStoreInventory().size() > 9){
					CURRENT_PAGE++;
					START += 9;
					if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() % 9 !=0 && CURRENT_PAGE == (listOfStore.get(SHOP_NUMBER).getStoreInventory().size() / 9) + 1){
						END = listOfStore.get(SHOP_NUMBER).getStoreInventory().size();
					}
					else{
						if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() % 9 == 0 && CURRENT_PAGE == (listOfStore.get(SHOP_NUMBER).getStoreInventory().size() / 9)){
							END = listOfStore.get(SHOP_NUMBER).getStoreInventory().size();
						}
						else{
							END += 9;
						}
					}		
//					update();
//					game.repaint();
				}
			}
			if(SELL_MENU == true){
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
//					update();
//					game.repaint();
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
//					update();
//					game.repaint();
				}
			}
		}
		
		if(e.getKeyCode() == PREVIOUS_PAGE){
			if(START != 1 && RUN_ARROW_KEYS == true){
				CURRENT_PAGE--;
				START -= 9;
				END = START + 8;
//				update();
//				game.repaint();
			}	
		}
		
		if(e.getKeyCode() == STORE_BUY && RUN_B == true){
			BUY_MENU = true;
			RUN_S = false;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == STORE_SELL && RUN_S == true){
			SELL_MENU = true;
			RUN_B = false;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == TOP_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
//				update();
//				game.repaint();
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
				update();
				game.repaint();
			}
			ITEM_NUMBER = START;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == TOP_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 1;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == TOP_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 2;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == MIDDLE_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 3;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == MIDDLE_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 4;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == MIDDLE_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 5;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == BOTTOM_LEFT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 6;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == BOTTOM_CENTER_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 7;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == BOTTOM_RIGHT_ITEM && RUN_NUMBERS == true){
			if(BUY_MENU == true){
				BUY_WARNING = true;
			}
			if(SELL_MENU == true){
				SELL_WARNING = true;
			}
			ITEM_NUMBER = START + 8;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == GO_BACK){
			ERROR_MONEY = false;
			BUY_WARNING = false;
			SELL_WARNING = false;
			RUN_NUMBERS = true;
			RUN_ARROW_KEYS = true;
//			update();
//			game.repaint();
		}
		
		if(e.getKeyCode() == YES ){
			if(BUY_MENU == true && BUY_WARNING == true){
				if(listOfStore.get(SHOP_NUMBER).getStoreInventory().size() > 0){
					if(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getItemBuyPrice() < PLAYER_WEALTH){
						PLAYER_WEALTH = PLAYER_WEALTH - listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getItemBuyPrice();
						listOfStore.get(SHOP_NUMBER).buyItem(playerInventory, listOfStore.get(SHOP_NUMBER).getStoreInventory(), ITEM_NUMBER - 1, PLAYER_WEALTH);
						if(END % 9 != 0){
							END--;
						}
						BUY_WARNING = false;
						RUN_ARROW_KEYS = true;
//						update();
//						game.repaint();
					}
					else{
						BUY_WARNING = false;
						ERROR_MONEY = true;
						RUN_ARROW_KEYS = false;
//						update();
//						game.repaint();
					}
				}
				if(CURRENT_PAGE * 9 - 8 > listOfStore.get(SHOP_NUMBER).getStoreInventory().size()){
					CURRENT_PAGE--;
					START -= 9;
					END = START + 8;
				}
//				update();
//				game.repaint();
			}
			if(SELL_MENU == true && SELL_WARNING == true){
				System.out.println(listOfStore.get(SHOP_NUMBER).getStoreInventory().get(ITEM_NUMBER-1).getItemSellPrice());
				PLAYER_WEALTH = PLAYER_WEALTH + playerInventory.get(ITEM_NUMBER-1).getItemSellPrice();
				listOfStore.get(SHOP_NUMBER).sellItem(playerInventory, listOfStore.get(SHOP_NUMBER).getStoreInventory(), (ITEM_NUMBER - 1), PLAYER_WEALTH);
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
//				update();
//				game.repaint();
			}	
//			update();
//			game.repaint();
		}
		update();
		game.repaint();
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