package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class _DemoPlayer extends MenuComponent {

	public _DemoPlayer(Menu menu, int x, int y) {
		super(menu, x, y);
		this.setColor(Color.BLUE);
		this.setDimensions(100, 200);
	}

	public void draw(Graphics2D g2) {
		g2.setColor(color);
		
		Point player = getCoord().getGlobal();
		g2.fillRect(player.x, player.y, width, height);
	}

	public void keyPressed(KeyEvent e) {
		Point player = getCoord().getGlobal();
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			player.translate(0,-1);
			break;
			
		case KeyEvent.VK_DOWN:
			player.translate(0,+1);
			break;
			
		case KeyEvent.VK_LEFT:
			player.translate(-1,0);
			break;
		
		case KeyEvent.VK_RIGHT:
			player.translate(+1,0);
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
