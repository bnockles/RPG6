package items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;

public final class ItemScreen extends Screen implements KeyListener {

	public ItemScreen(Game game) {
		super(game);
	}

	
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.green);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.yellow);
		UtilityMethods.centerText(g2, "ITEMS DEMO", width, height);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent ev) {
		
	}

	public void keyReleased(KeyEvent ev) {
		
	}

	public void keyTyped(KeyEvent ev) {
		
	}

}
