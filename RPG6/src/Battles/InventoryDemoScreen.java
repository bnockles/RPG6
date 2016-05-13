package Battles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import directors.Screen;
import directors.Game;

public class InventoryDemoScreen extends Screen {

	ItemsComponent inventory;
	public InventoryDemoScreen(Game game) {
		super(game);
		inventory=new ItemsComponent();
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.drawRect (width-150, height-120, 150, 120);
		g2.drawRect (width-300, height-120, 150, 120);
		g2.drawRect (width-150, height-240, 150, 120);
		g2.drawRect (width-300, height-240, 150, 120);
		g2.drawRect (width-650, height-120, 350, 120);
		g2.drawRect (width-650, height-240, 350, 120);
		g2.drawRect (width-1000, height-120, 350, 120);
		g2.drawRect (width-1000, height-240, 350, 120);
		g2.setColor(Color.black);
		g2.drawImage(inventory.getImage(), inventory.getX(), inventory.getY(), null);
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}
}
