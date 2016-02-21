package towns;

/**
 * 
 */

import directors.Game;
import directors.Screen;
import towns.TownScreen;


public class Npc extends Game{

	public static void main(String[] args) {
		new Npc();
	}
	
	protected void reset() {
		Screen demoScreen = new TownScreen(this);
		setScreen(demoScreen);
		repaint();
	}
	
}
