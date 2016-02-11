package towns;

import directors.Game;

public class TownDemo extends Game{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TownDemo();
	}
	
	protected void reset(){
		Screen demoScreen = new TownScreen(this);
		setScreen(demoScreen);
		repaint();
	}

}
