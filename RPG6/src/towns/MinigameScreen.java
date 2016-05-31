package towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import directors.Game;
import directors.Screen;


public class MinigameScreen extends Screen implements KeyListener {
	RunGame thing;
	String theMessage;
	String displayTheCard;
    Deck deck = new Deck();
	public MinigameScreen(Game game) {
		super(game);
		thing=new RunGame(); 
		theMessage=" ";
	    displayTheCard = " ";
	}

	public static void main(String[] args) {

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			//theMessage=thing.doTheThing();
			displayTheCard=thing.displayCard();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.drawString("Welcome to a Basic Game of Poker! If you win, you will receive an item "
				+ "as a reward totally free of cost! Press space bar to start game",100,100);
		g2.drawString(theMessage,100,200);
		g2.drawString(displayTheCard, 300, 300);
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

}
