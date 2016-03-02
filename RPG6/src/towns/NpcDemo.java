package towns;

/**
 * 
 */

import directors.Game;
import directors.Screen;
import towns.TownScreen;
import towns.MainTownScreen;


public class NpcDemo extends Game{

	public static void main(String[] args) {
		new NpcDemo();
	}
	
	protected void reset() {
		Screen demoScreen = new MainTownScreen(this);
		setScreen(demoScreen);
		repaint();
	}
	
}
