package directors;

import java.awt.image.BufferedImage;

public abstract class Screen {

	Game game;
	BufferedImage screenImage;
	public int width;
	public int height;
	
	//Every screen must access the Game instance so one screen
	//can cause the game to switch to a new screen
	public Screen(Game game) {
		this.game = game;
		this.width = 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
