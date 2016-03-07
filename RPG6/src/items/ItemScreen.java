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
	
	
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.green);
		g2.fillRect(0, 0, width, height);

		//TODO: draw inventory here
		g2.setColor(Color.black);
		g2.fillRect(this.width/2-200, this.height/2-300, 400, 600);
		
		Item it = ItemSandbox.inv.getItem();
		g2.drawString(it.getName(), 		this.width/2-204, this.height/2-304);
		g2.drawString(it.getDescription(), 	this.width/2-204, this.height/2-326);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent ev) {
		
	}

	public void keyReleased(KeyEvent ev) {
		int key = ev.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)	ItemSandbox.inv.moveCursor(-1);
		if(key == KeyEvent.VK_RIGHT)ItemSandbox.inv.moveCursor(+1);
	}

	public void keyTyped(KeyEvent ev) {
		
	}

}
