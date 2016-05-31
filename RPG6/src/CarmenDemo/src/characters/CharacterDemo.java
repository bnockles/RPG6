
package characters;

import directors.Game;
import directors.Screen;
import characters.CharacterScreen;

public class CharacterDemo extends Game{
	Screen demoScreen = new CharacterScreen(this);
	
	public static void main(String[] args) {
		new CharacterDemo();
	}

<<<<<<< HEAD
	protected void reset() {
		demoScreen = new CharacterScreen(this);
=======
	public void reset() {
		Screen demoScreen = new CharacterScreen(this);
>>>>>>> refs/remotes/origin/saving
		setScreen(demoScreen);
		repaint();
	}
	
}
