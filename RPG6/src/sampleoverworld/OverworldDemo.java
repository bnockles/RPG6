package sampleoverworld;

import directors.Game;
import directors.Screen;
/**
 * 
 * @author Fei
 * This class is for running towns in order to test them.
 *
 */
public class OverworldDemo extends Game {

	
	
	
	public static void main(String[] args) {
		new OverworldDemo();
	}

	public void reset() {
		Screen townScreen = new OverworldScreen(this,1,1);
		setScreen(townScreen);
		activeScreen.update();
		repaint();
	}
	
}
