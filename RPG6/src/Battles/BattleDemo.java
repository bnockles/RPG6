package Battles;
import directors.Game;
import directors.Screen;
public class BattleDemo extends Game{

	public static void main(String[] args) {
		new BattleDemo();

	}
	protected void reset() {
		Screen demoScreen = new UpdatedBattleScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
