
package characters;

import directors.Game;
import directors.Screen;
import characters.CharacterScreen;

public class CharacterDemo extends Game{
	Screen demoScreen = new CharacterScreen(this);
	
	public static void main(String[] args) {
		new CharacterDemo();
	}

	protected void reset() {
		demoScreen = new CharacterScreen(this);
		setScreen(demoScreen);
		repaint();
	}
	
}
