package towns;

import directors.Game;
import directors.Screen;

public class MinigameDemo extends Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MinigameDemo();
	}
	public void reset(){
		Screen demoScreen=new MinigameScreen(this);
		setScreen(demoScreen);
	}
}
