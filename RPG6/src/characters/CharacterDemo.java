package characters;

import directors.Game;
import directors.Screen;
import characters.CharacterScreen;

public class CharacterDemo extends Game{

	public static void main(String[] args) {
		new CharacterDemo();
	}

	public void reset() {
		Screen demoScreen = new CharacterScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
