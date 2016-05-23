package towns;

import directors.Game;
import directors.Screen;

public class HfengDemo extends Game{
	public static void main(String[] args){
		new HfengDemo();
	}
	
	public void reset(){
		Screen demoScreen = new HfengScreen(this);
		setScreen(demoScreen);
	}
}
 