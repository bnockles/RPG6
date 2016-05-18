import directors.Game;
import directors.Screen;
import directors.StartScreen;


public class LootDemo extends Game{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LootDemo();
	}
	protected void reset() {
		Screen startScreen = new LootScreen(this,17);
		setScreen(startScreen);
		repaint();	
	}
}
