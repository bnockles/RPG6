package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class _DemoPlayer extends MenuComponent {
	private int speed;

	public _DemoPlayer(Menu menu, int x, int y) {
		super(menu, x, y);
		this.setColor(Color.BLUE);
		this.setDimensions(50, 100);
		
		this.speed = 3;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}

	public void draw(Graphics2D g2) {
		g2.setColor(color);
		
		Point player = getCoord().getGlobal();
		g2.fillRect(player.x, player.y, width, height);
	}

	public void keyPressed(KeyEvent e) {
		Coord player = getCoord();
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			player.translate(0,-speed);
			break;
			
		case KeyEvent.VK_DOWN:
			player.translate(0,+speed);
			break;
			
		case KeyEvent.VK_LEFT:
			player.translate(-speed,0);
			break;
		
		case KeyEvent.VK_RIGHT:
			player.translate(+speed,0);
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
