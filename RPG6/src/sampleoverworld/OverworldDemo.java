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

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new OverworldDemo();
	}

	public void reset() {
		Screen townScreen = new OverworldScreen(this,new SampleWanderer(),"sample","overworld",1,1,0,0,540,719);
		setScreen(townScreen);
		activeScreen.update();
		repaint();
	}
	
}
