package towns;

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
			
	public static String welcomeMessage = "Welcome to your wares!";
	public static String actionMessage = "What would you like to do today? " +
			"4 to Store Items and 5 to Retrieve Items";
	public static String storedItems = "";
	Item e1;
	Item e2;
	Item e3;
	Item e4;
	
	public ArrayList<Item> list;
	
	public StorageScreen(Game game) {
		super(game);
	
		list = new ArrayList<Item>(); 
		e1 = equipStock.equipStocks(0);
		e2 = equipStock.equipStocks(1);
		e3 = equipStock.equipStocks(2);
		e4 = equipStock.equipStocks(3);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		int yAxis = 100;
		
		//displays player inventory
		for(Item i:list){
			g2.drawString(i.getItemName(),100, yAxis);
			yAxis += 100;
		}
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
