package items;

import directors.Game;
import directors.Screen;
import directors.StartScreen;

public final class ItemDemo extends Game {
	
	public static void main(String[] args) {
		new ItemDemo();
	}

	public ItemDemo(){
<<<<<<< HEAD
		Screen demoScreen = new ItemScreen2(this);
=======
		Screen demoScreen = new ItemScreen3(this);
>>>>>>> refs/remotes/origin/characters
		setScreen(demoScreen);
		repaint();

	}
}
