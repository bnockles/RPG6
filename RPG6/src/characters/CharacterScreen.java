package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import directors.Game;
import directors.Screen;

public class CharacterScreen extends Screen implements KeyListener{

	public CharacterScreen(Game game) {
		super(game);
		//Please work
		// TODO Auto-generated constructor stub
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public void paintScreen1(Graphics2D g2){
			g2.setColor(Color.white);
			g2.fillRect(0, 0, width, height);
			g2.setColor(Color.black);
			try{
				g2.drawString("Inventory", 50, 50);;
				g2.drawString(SampleArmor.b, 120, 75);
				g2.drawString(SamplePotion.c, 120, 100);
				g2.drawString(SampleAccesory.a, 120, 125);
				g2.drawString(SampleWeapon.d, 120, 150);
			}catch(Exception e){
				//idk
			}
	}
}
