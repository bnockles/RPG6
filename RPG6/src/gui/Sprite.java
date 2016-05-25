package gui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Sprite extends MenuComponent {
	private BufferedImage image;

	public Sprite(Menu menu, BufferedImage image, int x, int y) {
		super(menu);
		
		this.image = image;
		this.setPosition(x, y);
	}

	public void draw(Graphics2D g2) {
		

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
