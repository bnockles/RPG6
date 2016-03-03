package Battles;
import directors.Game;
import directors.Screen;
public class BattleDemo extends Game{

	public static void main(String[] args) {
		new BattleDemo();

	}
	protected void reset() {
		Screen demoScreen = new battleScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
