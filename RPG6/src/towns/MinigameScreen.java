package towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import directors.Game;
import directors.Screen;


public class MinigameScreen extends Screen implements KeyListener {
	RunGame thing;
	String theMessage;
	public MinigameScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		thing=new RunGame();
		theMessage=" ";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

/*	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			theMessage=thing.doTheThing();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawString(theMessage,50,100);
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}*/

}

