package towns;

import directors.Game;
import directors.Screen;

public class StorageDemo extends Game{
	public static void main(String[] args){
		new StorageDemo();
	}
	
	public void reset(){
		Screen demoScreen = new StorageScreen(this);
		setScreen(demoScreen);
	}
}