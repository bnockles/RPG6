package items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import directors.Game;
import directors.Screen;


public class ItemScreen2 extends Screen implements KeyListener{
	
	Character character;

	static ArrayList<Item> inventory = new ArrayList<Item>();
	static ArrayList<Item> cInventory = new ArrayList<Item>();
	static ArrayList<Item> qInventory = new ArrayList<Item>();
	public static boolean currentFirst = false;
	public static boolean currentSecond = false;
	public static boolean currentThird = false;
	public static boolean currentFourth = false;
	public static boolean currentFifth = false;
	public static boolean equips = false;
	public static boolean consumes = false;
	public static boolean quests = false;
	public static boolean noItems = false;
	public static String noItemString = "";
	public static String welcomeMessage = "WELCOME TO THE ITEM DATABASE!";
	public static String index = "This is beginning! Press 'X' for the Equipment Index. Press 'Y' for the Consumables Index. Press 'Z' for the Quest Items Index.";
	public static String currentPage = "You are currently on no page.";
	public static String message = "Press 1 to display 9 items, and press A-J depending on the amount of items for more info.";
	public static String message2 = "Press 1-5 to display different sets of items.";
	public static String info = "Information of Item";
	public static String nameMessage = "";
	public static String reqMessage = "";
	public static String descriptionMessage = "";
	public static String statsMessage = "";
	
	
	/**
	 * @param game
	 */
	
	
	
	public ItemScreen2(Game game) {
		super(game);		
		for (int i = 0; i < 49; i++){
			inventory.add(equipStock.equipStocks(i));
		}
		for (int i = 0; i < 14; i++){
			cInventory.add(potionStock.consumableStock(i));
		}
		update();
	}

	public void paintScreen(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		
		try{

			int x = 150;
			if (currentFirst){
			for(int i=0; i<10;i++){
				if (equips){
					g2.drawString(inventory.get(i).getName(), 150, x);
					x += 25;
				}
				if (consumes){
					g2.drawString(cInventory.get(i).getName(), 150, x);
					x += 25;
				}
			}
			}
			if (currentSecond){
				for(int i=10; i<20; i++){
					if (equips){
						g2.drawString(inventory.get(i).getName(), 150, x);
						x += 25;
					}
				}
				for(int i=10; i<14; i++){
					if (consumes){
						g2.drawString(cInventory.get(i).getName(), 150, x);
						x += 25;
					}
				}
			}
			if (currentThird){
				for (int i=20; i<30; i++){
					if (equips){
						g2.drawString(inventory.get(i).getName(), 150, x);
						x += 25;
					}
				}
			}
			if (currentFourth){
				for (int i=30; i<40; i++){
					if (equips){
						g2.drawString(inventory.get(i).getName(), 150, x);
						x += 25;
					}
				}
			}
			if (currentFifth){
				for (int i=40; i<48; i++){
					if (equips){
						g2.drawString(inventory.get(i).getName(), 150, x);
						x += 25;
					}
				}
			}
			if (noItems && consumes){
				g2.drawString(noItemString, 150, 175);
			}
			g2.drawString(index, 150, 75);
			g2.drawString(currentPage, 150, 100);
			g2.drawString("Available Items", 150, 125);
			g2.drawString(welcomeMessage, 450, 50);
			g2.drawString(message, 50, 425);
			g2.drawString(message2, 50, 450);
			g2.drawString(info, 50, 475);
			g2.drawString(nameMessage, 50, 500);
			g2.drawString(reqMessage, 50, 525);
			g2.drawString(descriptionMessage, 50, 550);
			g2.drawString(statsMessage, 50, 575);
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		
	}
	
	public static void updateMessages(int i){
		nameMessage = inventory.get(i).getName();
		reqMessage = inventory.get(i).getDescription();
		descriptionMessage = inventory.get(i).getReq();
		statsMessage = "Stats- STR: " + ((Equipment) inventory.get(i)).getStats().getStrength() +
						" DEX: " + ((Equipment) inventory.get(i)).getStats().getDexterity() +
						" INT: " + ((Equipment) inventory.get(i)).getStats().getIntelligence() +
						" WIS: " + ((Equipment) inventory.get(i)).getStats().getWisdom() +
						" LUK: " + ((Equipment) inventory.get(i)).getStats().getLuck() +
						" ATK: " + ((Equipment) inventory.get(i)).getStats().getAttack();
	}
	
	public static void updateCMessages(int i){
		nameMessage = cInventory.get(i).getName();
		reqMessage = cInventory.get(i).getDescription();
		descriptionMessage = cInventory.get(i).getReq();
	}
	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		
//		if(e.getKeyCode()==talkNpc1 && currentTown.getTownName() == "Pellet Town"){
//			System.out.println("1 was pressed");
//			
//			if(character.getCurrency() < 300){
//				message = "Oops! Seems like you don't have enough to buy anything! You need at least 300 gems, go and see Bob to try and earn some money!";
//				actionMessage = "You need more gems!";
//			}
//	}

		if(e.getKeyCode() == KeyEvent.VK_1){
			System.out.println("1 is pressed");
			currentPage = "You are on page 1.";
			noItems = false;
			currentFirst = true;
			currentSecond = false;
			currentThird = false;
			currentFourth = false;
			currentFifth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_2){
			System.out.println("2 is pressed");
			currentPage = "You are on page 2.";
			noItems = false;
			currentFirst = false;
			currentSecond = true;
			currentThird = false;
			currentFourth = false;
			currentFifth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_3){
			System.out.println("3 is pressed");
			currentPage = "You are on page 3.";
			noItems = true;
			noItemString = "There are no items on this list!";
			currentFirst = false;
			currentSecond = false;
			currentThird = true;
			currentFourth = false;
			currentFifth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_4){
			System.out.println("4 is pressed");
			currentPage = "You are on page 4.";
			noItems = true;
			noItemString = "There are no items on this list!";
			currentFirst = false;
			currentSecond = false;
			currentThird = false;
			currentFourth = true;
			currentFifth = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_5){
			System.out.println("5 is pressed");
			currentPage = "You are on page 5.";
			noItems = true;
			noItemString = "There are no items on this list!";
			currentFirst = false;
			currentSecond = false;
			currentThird = false;
			currentFourth = false;
			currentFifth = true;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_X){
			index = "This is the Equipment Index! Press 'Y' for the Consumables Index. Press 'Z' for the Quest Items Index.";
			equips = true;
			consumes = false;
			quests = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_Y){
			index = "This is the Consumables Index! Press 'X' for the Equipment Index. Press 'Z' for the Quest Items Index.";
			equips = false;
			consumes = true;
			quests = false;
			update();
			game.repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_Z){
			index = "This is the Equipment Index! Press 'X' for the Equipment Index. Press 'Y' for the Consumables Index.";
			equips = false;
			consumes = false;
			quests = true;
			update();
			game.repaint();
		}
		if(equips){
		if (currentFirst){
			if(e.getKeyCode() == KeyEvent.VK_A){
				updateMessages(0);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				updateMessages(1);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				updateMessages(2);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				updateMessages(3);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				updateMessages(4);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				updateMessages(5);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				updateMessages(6);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				updateMessages(7);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				updateMessages(8);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				updateMessages(9);
				update();
				game.repaint();
			}
		}
		if (currentSecond){
			if(e.getKeyCode() == KeyEvent.VK_A){
				updateMessages(10);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				updateMessages(11);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				updateMessages(12);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				updateMessages(13);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				updateMessages(14);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				updateMessages(15);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				updateMessages(16);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				updateMessages(17);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				updateMessages(18);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				updateMessages(19);
				update();
				game.repaint();
			}
		}
		if (currentThird){
			if(e.getKeyCode() == KeyEvent.VK_A){
				updateMessages(20);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				updateMessages(21);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				updateMessages(22);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				updateMessages(23);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				updateMessages(24);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				updateMessages(25);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				updateMessages(26);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				updateMessages(27);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				updateMessages(28);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				updateMessages(29);
				update();
				game.repaint();
			}
		}
		if (currentFourth){
			if(e.getKeyCode() == KeyEvent.VK_A){
				updateMessages(30);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				updateMessages(31);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				updateMessages(32);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				updateMessages(33);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				updateMessages(34);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				updateMessages(35);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				updateMessages(36);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				updateMessages(37);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				updateMessages(38);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				updateMessages(39);
				update();
				game.repaint();
			}
		}
		if (currentFifth){
			if(e.getKeyCode() == KeyEvent.VK_A){
				updateMessages(40);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				updateMessages(41);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				updateMessages(42);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				updateMessages(43);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				updateMessages(44);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				updateMessages(45);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				updateMessages(46);
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				updateMessages(47);
				update();
				game.repaint();
			}
		}
		}
		if (consumes){
			if (currentFirst){
				if(e.getKeyCode() == KeyEvent.VK_A){
					updateCMessages(0);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_B){
					updateCMessages(1);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_C){
					updateCMessages(2);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					updateCMessages(3);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_E){
					updateCMessages(4);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_F){
					updateCMessages(5);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_G){
					updateCMessages(6);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_H){
					updateCMessages(7);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_I){
					updateCMessages(8);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_J){
					updateCMessages(9);
					update();
					game.repaint();
				}
			}
			if (currentSecond){
				if(e.getKeyCode() == KeyEvent.VK_A){
					updateCMessages(10);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_B){
					updateCMessages(11);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_C){
					updateCMessages(12);
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					updateCMessages(13);
					update();
					game.repaint();
				}
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
