package items;

import directors.Game;
import directors.Screen;
import directors.StartScreen;

public final class ItemDemo extends Game {
	
	public static void main(String[] args) {
		new ItemDemo();
	}

	public ItemDemo(){
		Screen demoScreen = new ItemScreen3(this);
		setScreen(demoScreen);
		repaint();

	}
}
