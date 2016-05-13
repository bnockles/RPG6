
package Battles;

import directors.Game;
import directors.Screen;
import directors.StartScreen;

public class InventoryDemo extends Game{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InventoryDemo();
	}
	
	protected void reset() {
		Screen startScreen = new InventoryDemoScreen(this);
		setScreen(startScreen);
		repaint();	
	}
}
