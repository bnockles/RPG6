package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class _BattleCursor extends MenuComponent {
	private int stepX, stepY;

	public _BattleCursor(Menu menu, int x, int y) {
		super(menu, x, y);
		
		this.stepX = 105;
		this.stepY = 55;
		this.setDimensions(100, 50);
	}

	public void draw(Graphics2D g2) {
		Point pos = getCoord().getGlobal();
		g2.drawRect(pos.x, pos.y, width, height);
	}

	public void keyPressed(KeyEvent e) {
		Coord cursor = this.getCoord();
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			cursor.translate(0,-stepY);
			break;
			
		case KeyEvent.VK_DOWN:
			cursor.translate(0,+stepY);
			break;
			
		case KeyEvent.VK_LEFT:
			cursor.translate(-stepX,0);
			break;
		
		case KeyEvent.VK_RIGHT:
			cursor.translate(+stepX,0);
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
