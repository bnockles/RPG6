package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import directors.Game;
import directors.Screen;


public class StorageScreen extends Screen implements KeyListener{

	public static final int storeItem1 = KeyEvent.VK_A;
	public static final int storeItem2 = KeyEvent.VK_S;
	public static final int storeItem3 = KeyEvent.VK_D;
	public static final int storeItem4 = KeyEvent.VK_F;
	public static final int slot1 = KeyEvent.VK_1;
	public static final int slot2 = KeyEvent.VK_2;
	public static final int slot3 = KeyEvent.VK_3;
	public static final int store = KeyEvent.VK_4;
	public static final int retrieve = KeyEvent.VK_5;
	public static final int left = KeyEvent.VK_LEFT;
	public static final int right = KeyEvent.VK_RIGHT;
	public static final int enter = KeyEvent.VK_ENTER;
	public static final int quit = KeyEvent.VK_Q;

	public static String welcomeMessage = "Welcome to your wares!";
	public static String actionMessage = "What would you like to do today? " +
			" Press 4 to Store Items and 5 to Retrieve Items";
	public static String storedItems = "";
	public static int selectedIndex = 0;

	Storage storageNPC;
	SampleCharacter sNPC;

	Item e1;
	Item e2;
	Item e3;
	Item e4;

	int counter = 0;
	boolean storing = false;

	public ArrayList<Item> playerInventory;

	public StorageScreen(Game game) {
		super(game);

		sNPC = new SampleCharacter("/images/storage.png",50,50,"npc");

		storageNPC = new Storage("Greg","Male","He is your storage guy, him and his cousins (who look exactly like him) "
				+ "are in every town in case you want to store items and then take them back for later.", true);

		playerInventory = new ArrayList<Item>(); 
		e1 = equipStock.equipStocks(0);
		e2 = equipStock.equipStocks(1);
		e3 = equipStock.equipStocks(2);
		e4 = equipStock.equipStocks(3);

		playerInventory.add(e1);
		playerInventory.add(e2);
		playerInventory.add(e3);
		playerInventory.add(e4);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == quit){
			System.out.println("Q was pressed");
			actionMessage = "What would you like to do today?" +
					"Press 4 to Store Items and 5 to Retrieve Items";
			storing = false;
			update();
		}
		if(e.getKeyCode() == store){
			actionMessage = "Move the left or right arrow keys to choose what to store! Press Q to quit.";
			System.out.println("4 was pressed");
			storing = true;
			update();
		}

		if(storing){
			if(e.getKeyCode() == left){
				System.out.println("Left arrow key was pressed");
				counter--;
				if(counter < 0){
					counter = playerInventory.size() - 1;
				}
				update();
				game.repaint();
			}
			if(e.getKeyCode() == right){
				System.out.println("Right arrow key was pressed");
				counter++;
				if(counter > playerInventory.size() - 1){
					counter = 0;
				}
				update();
				game.repaint();
			}
			selectedIndex = counter;
			if(e.getKeyCode() == enter){
				System.out.println("Enter was pressed");
				actionMessage = "Press 1 to store in slot 1, 2 to store in slot 2 and 3 to store in slot 3.";
				if(e.getKeyCode() == slot1){
					System.out.println("Picking slot 1");
				}
				if(e.getKeyCode() == slot2){
					System.out.println("Picking slot 1");
				}
				if(e.getKeyCode() == slot3){
					System.out.println("Picking slot 1");
				}

			}
		}

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintScreen(Graphics2D g2) {

		g2.drawImage(sNPC.getImage(), sNPC.getX(), sNPC.getY(), null);

		//displays greetings
		g2.drawString(welcomeMessage, 200, 100);

		//displays commands
		g2.drawString(actionMessage, 200, 150);

		//displays storage inventory
		g2.drawString("Storage Inventory: ",200, 200);
		int xAx = 300;
		for(Item s:Storage.getStorage()){
			if(s != null){
				g2.drawString(s.getItemName(), xAx, 200);
				xAx += 100;				
			}
		}

		//displays player inventory
		g2.drawString("Player Inventory: ", 200, 300);	
		int xAxis = 300;
		for(int i = 0; i < playerInventory.size(); i++){
			if(i == selectedIndex && storing){
				g2.setColor(Color.blue);
				g2.drawString(playerInventory.get(i).getItemName(),xAxis, 300);
			}else{
				g2.setColor(Color.black);
				g2.drawString(playerInventory.get(i).getItemName(),xAxis, 300);
			}
			xAxis += 100;
		}

	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

}