package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class MenuBox extends MenuComponent {
	private boolean fill;
	
	public MenuBox(Menu menu, int x, int y) {
		super(menu, x, y);
		
		this.fill = true;
	}

	public MenuBox setFill(boolean fill){
		this.fill = fill;
		return this;
	}

	public void draw(Graphics2D g2) {
		Point global = getParentGlobal();
		
//		g2.drawString(getCoord().toString(), 400, 40);
		
		g2.setColor(color);
		
		if(fill)
			g2.fillRect(global.x, global.y, width, height);
		else
			g2.drawRect(global.x, global.y, width, height);
	}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}

}
