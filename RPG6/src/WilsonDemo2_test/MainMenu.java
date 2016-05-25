package WilsonDemo2_test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

//import directors.Game;
//import directors.Screen;
//import directors.UtilityMethods;

public class MainMenu extends Screen {

	public MainMenu(Game game) {
		super(game);
	}

	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.white);
		UtilityMethods.centerText(g2, "This is the main menu! Cool, right?", width, height);
	}

	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

}