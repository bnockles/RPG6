package items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import directors.Game;
import directors.Screen;
import items.equipStock;


public class ItemScreen2 extends Screen implements KeyListener{
	
	Character character;

	ArrayList<Item> inventory = new ArrayList<Item>();
	ArrayList<Item> cInventory = new ArrayList<Item>();
	ArrayList<Item> qInventory = new ArrayList<Item>();
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
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		
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
				nameMessage = inventory.get(0).getName();
				reqMessage = inventory.get(0).getDescription();
				descriptionMessage = inventory.get(0).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				nameMessage = inventory.get(1).getName();
				reqMessage = inventory.get(1).getDescription();
				descriptionMessage = inventory.get(1).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				nameMessage = inventory.get(2).getName();
				reqMessage = inventory.get(2).getDescription();
				descriptionMessage = inventory.get(2).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				nameMessage = inventory.get(3).getName();
				reqMessage = inventory.get(3).getDescription();
				descriptionMessage = inventory.get(3).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				nameMessage = inventory.get(4).getName();
				reqMessage = inventory.get(4).getDescription();
				descriptionMessage = inventory.get(4).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				nameMessage = inventory.get(5).getName();
				reqMessage = inventory.get(5).getDescription();
				descriptionMessage = inventory.get(5).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				nameMessage = inventory.get(6).getName();
				reqMessage = inventory.get(6).getDescription();
				descriptionMessage = inventory.get(6).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				nameMessage = inventory.get(7).getName();
				reqMessage = inventory.get(7).getDescription();
				descriptionMessage = inventory.get(7).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				nameMessage = inventory.get(8).getName();
				reqMessage = inventory.get(8).getDescription();
				descriptionMessage = inventory.get(8).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				nameMessage = inventory.get(9).getName();
				reqMessage = inventory.get(9).getDescription();
				descriptionMessage = inventory.get(9).getReq();
				update();
				game.repaint();
			}
		}
		if (currentSecond){
			if(e.getKeyCode() == KeyEvent.VK_A){
				nameMessage = inventory.get(10).getName();
				reqMessage = inventory.get(10).getDescription();
				descriptionMessage = inventory.get(10).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				nameMessage = inventory.get(11).getName();
				reqMessage = inventory.get(11).getDescription();
				descriptionMessage = inventory.get(11).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				nameMessage = inventory.get(12).getName();
				reqMessage = inventory.get(12).getDescription();
				descriptionMessage = inventory.get(12).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				nameMessage = inventory.get(13).getName();
				reqMessage = inventory.get(13).getDescription();
				descriptionMessage = inventory.get(13).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				nameMessage = inventory.get(14).getName();
				reqMessage = inventory.get(14).getDescription();
				descriptionMessage = inventory.get(14).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				nameMessage = inventory.get(15).getName();
				reqMessage = inventory.get(15).getDescription();
				descriptionMessage = inventory.get(15).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				nameMessage = inventory.get(16).getName();
				reqMessage = inventory.get(16).getDescription();
				descriptionMessage = inventory.get(16).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				nameMessage = inventory.get(17).getName();
				reqMessage = inventory.get(17).getDescription();
				descriptionMessage = inventory.get(17).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				nameMessage = inventory.get(18).getName();
				reqMessage = inventory.get(18).getDescription();
				descriptionMessage = inventory.get(18).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				nameMessage = inventory.get(19).getName();
				reqMessage = inventory.get(19).getDescription();
				descriptionMessage = inventory.get(19).getReq();
				update();
				game.repaint();
			}
		}
		if (currentThird){
			if(e.getKeyCode() == KeyEvent.VK_A){
				nameMessage = inventory.get(20).getName();
				reqMessage = inventory.get(20).getDescription();
				descriptionMessage = inventory.get(20).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				nameMessage = inventory.get(21).getName();
				reqMessage = inventory.get(21).getDescription();
				descriptionMessage = inventory.get(21).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				nameMessage = inventory.get(22).getName();
				reqMessage = inventory.get(22).getDescription();
				descriptionMessage = inventory.get(22).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				nameMessage = inventory.get(23).getName();
				reqMessage = inventory.get(23).getDescription();
				descriptionMessage = inventory.get(23).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				nameMessage = inventory.get(24).getName();
				reqMessage = inventory.get(24).getDescription();
				descriptionMessage = inventory.get(24).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				nameMessage = inventory.get(25).getName();
				reqMessage = inventory.get(25).getDescription();
				descriptionMessage = inventory.get(25).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				nameMessage = inventory.get(26).getName();
				reqMessage = inventory.get(26).getDescription();
				descriptionMessage = inventory.get(26).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				nameMessage = inventory.get(27).getName();
				reqMessage = inventory.get(27).getDescription();
				descriptionMessage = inventory.get(27).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				nameMessage = inventory.get(28).getName();
				reqMessage = inventory.get(28).getDescription();
				descriptionMessage = inventory.get(28).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				nameMessage = inventory.get(29).getName();
				reqMessage = inventory.get(29).getDescription();
				descriptionMessage = inventory.get(29).getReq();
				update();
				game.repaint();
			}
		}
		if (currentFourth){
			if(e.getKeyCode() == KeyEvent.VK_A){
				nameMessage = inventory.get(30).getName();
				reqMessage = inventory.get(30).getDescription();
				descriptionMessage = inventory.get(30).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				nameMessage = inventory.get(31).getName();
				reqMessage = inventory.get(31).getDescription();
				descriptionMessage = inventory.get(31).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				nameMessage = inventory.get(32).getName();
				reqMessage = inventory.get(32).getDescription();
				descriptionMessage = inventory.get(32).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				nameMessage = inventory.get(33).getName();
				reqMessage = inventory.get(33).getDescription();
				descriptionMessage = inventory.get(33).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				nameMessage = inventory.get(34).getName();
				reqMessage = inventory.get(34).getDescription();
				descriptionMessage = inventory.get(34).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				nameMessage = inventory.get(35).getName();
				reqMessage = inventory.get(35).getDescription();
				descriptionMessage = inventory.get(35).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				nameMessage = inventory.get(36).getName();
				reqMessage = inventory.get(36).getDescription();
				descriptionMessage = inventory.get(36).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				nameMessage = inventory.get(37).getName();
				reqMessage = inventory.get(37).getDescription();
				descriptionMessage = inventory.get(37).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_I){
				nameMessage = inventory.get(38).getName();
				reqMessage = inventory.get(38).getDescription();
				descriptionMessage = inventory.get(38).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_J){
				nameMessage = inventory.get(39).getName();
				reqMessage = inventory.get(39).getDescription();
				descriptionMessage = inventory.get(39).getReq();
				update();
				game.repaint();
			}
		}
		if (currentFifth){
			if(e.getKeyCode() == KeyEvent.VK_A){
				nameMessage = inventory.get(40).getName();
				reqMessage = inventory.get(40).getDescription();
				descriptionMessage = inventory.get(40).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				nameMessage = inventory.get(41).getName();
				reqMessage = inventory.get(41).getDescription();
				descriptionMessage = inventory.get(41).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_C){
				nameMessage = inventory.get(42).getName();
				reqMessage = inventory.get(42).getDescription();
				descriptionMessage = inventory.get(42).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				nameMessage = inventory.get(43).getName();
				reqMessage = inventory.get(43).getDescription();
				descriptionMessage = inventory.get(43).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_E){
				nameMessage = inventory.get(44).getName();
				reqMessage = inventory.get(44).getDescription();
				descriptionMessage = inventory.get(44).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_F){
				nameMessage = inventory.get(45).getName();
				reqMessage = inventory.get(45).getDescription();
				descriptionMessage = inventory.get(45).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_G){
				nameMessage = inventory.get(46).getName();
				reqMessage = inventory.get(46).getDescription();
				descriptionMessage = inventory.get(46).getReq();
				update();
				game.repaint();
			}
			if(e.getKeyCode() == KeyEvent.VK_H){
				nameMessage = inventory.get(47).getName();
				reqMessage = inventory.get(47).getDescription();
				descriptionMessage = inventory.get(47).getReq();
				update();
				game.repaint();
			}
		}
		}
		if (consumes){
			if (currentFirst){
				if(e.getKeyCode() == KeyEvent.VK_A){
					nameMessage = cInventory.get(0).getName();
					reqMessage = cInventory.get(0).getDescription();
					descriptionMessage = cInventory.get(0).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_B){
					nameMessage = cInventory.get(1).getName();
					reqMessage = cInventory.get(1).getDescription();
					descriptionMessage = cInventory.get(1).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_C){
					nameMessage = cInventory.get(2).getName();
					reqMessage = cInventory.get(2).getDescription();
					descriptionMessage = cInventory.get(2).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					nameMessage = cInventory.get(3).getName();
					reqMessage = cInventory.get(3).getDescription();
					descriptionMessage = cInventory.get(3).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_E){
					nameMessage = cInventory.get(4).getName();
					reqMessage = cInventory.get(4).getDescription();
					descriptionMessage = cInventory.get(4).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_F){
					nameMessage = cInventory.get(5).getName();
					reqMessage = cInventory.get(5).getDescription();
					descriptionMessage = cInventory.get(5).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_G){
					nameMessage = cInventory.get(6).getName();
					reqMessage = cInventory.get(6).getDescription();
					descriptionMessage = cInventory.get(6).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_H){
					nameMessage = cInventory.get(7).getName();
					reqMessage = cInventory.get(7).getDescription();
					descriptionMessage = cInventory.get(7).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_I){
					nameMessage = cInventory.get(8).getName();
					reqMessage = cInventory.get(8).getDescription();
					descriptionMessage = cInventory.get(8).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_J){
					nameMessage = cInventory.get(9).getName();
					reqMessage = cInventory.get(9).getDescription();
					descriptionMessage = cInventory.get(9).getReq();
					update();
					game.repaint();
				}
			}
			if (currentSecond){
				if(e.getKeyCode() == KeyEvent.VK_A){
					nameMessage = cInventory.get(10).getName();
					reqMessage = cInventory.get(10).getDescription();
					descriptionMessage = cInventory.get(10).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_B){
					nameMessage = cInventory.get(11).getName();
					reqMessage = cInventory.get(11).getDescription();
					descriptionMessage = cInventory.get(11).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_C){
					nameMessage = cInventory.get(12).getName();
					reqMessage = cInventory.get(12).getDescription();
					descriptionMessage = cInventory.get(12).getReq();
					update();
					game.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					nameMessage = cInventory.get(13).getName();
					reqMessage = cInventory.get(13).getDescription();
					descriptionMessage = cInventory.get(13).getReq();
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
