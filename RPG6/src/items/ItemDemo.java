package items;

import directors.Game;
import directors.Screen;
import directors.StartScreen;

public final class ItemDemo extends Game {
	//s
	public static void main(String[] args) {
		Items.registerBufferedItems();
		
		new ItemDemo();
	}

	public ItemDemo(){
		this.setScreen(new ItemScreen(this));
	}
}
