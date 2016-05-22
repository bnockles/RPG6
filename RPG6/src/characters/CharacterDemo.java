
package characters;

import directors.Game;
import directors.Screen;
import characters.CharacterScreen;

public class CharacterDemo extends Game{
	Screen demoScreen = new CharacterScreen(this);
	Screen battleScreen = new BattleScreen(this);
	
	public static void main(String[] args) {
		new CharacterDemo();
	}

	protected void reset() {
		demoScreen = new CharacterScreen(this);
		battleScreen = new BattleScreen(this);
		setScreen(demoScreen);
		repaint();
	}
	
	public void changeScreen(int num){
		if(num == 1){
			setScreen(demoScreen);
		}
		if(num == 2){
			setScreen(battleScreen);
		}
	}
}
