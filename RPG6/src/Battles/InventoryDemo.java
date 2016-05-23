
package Battles;

import directors.Game;
import directors.Screen;

public class InventoryDemo extends Game{

	public static void main(String[] args) {
		new InventoryDemo();
	}
	
	public void reset() {
		Screen startScreen = new InventoryDemoScreen(this);
		setScreen(startScreen);
		repaint();	
	}
}
