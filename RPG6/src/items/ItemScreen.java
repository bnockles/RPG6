package items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import directors.Game;
import directors.Screen;

public final class ItemScreen extends Screen implements KeyListener {

	public ItemScreen(Game game) {
		super(game);
	}
//s
	
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.green);
		g2.fillRect(0, 0, width, height);

		//replace with Item.draw()
		g2.setColor(Color.black);
		g2.fillRect(50, 100, 365, 100);
		g2.setColor(Color.white);
		g2.drawString(ItemSandbox.testChest.getName(), 				50+10, 100+20);
		g2.drawString(ItemSandbox.testChest.getDescription(), 		50+10, 100+50);
		g2.drawString(ItemSandbox.testChest.getStats().toString(), 	50+10, 100+90);

		g2.setColor(Color.black);
		g2.fillRect(50, 300, 365, 100);
		g2.setColor(Color.white);
		g2.drawString(ItemSandbox.testPotion.getName(), 			50+10, 300+20);
		g2.drawString(ItemSandbox.testPotion.getDescription(), 		50+10, 300+90);
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
