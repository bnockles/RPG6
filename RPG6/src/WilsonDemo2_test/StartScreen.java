package WilsonDemo2_test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import menus.MainMenu;

public class StartScreen extends Screen implements KeyListener{

	public StartScreen(Game game) {
		super(game);
	}

	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		UtilityMethods.centerText(g2, "Press the space bar to start.", width, height);
	}

	public KeyListener getKeyListener() {
		return this;
		
		
	}

	public void keyPressed(KeyEvent arg) {
		int k = arg.getKeyCode();
		if(k==KeyEvent.VK_SPACE){
			Screen mainMenu = new MainMenu(game);
			game.setScreen(mainMenu);
		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}