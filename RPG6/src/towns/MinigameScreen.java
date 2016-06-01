package towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import directors.Game;
import directors.Screen;


public class MinigameScreen extends Screen implements KeyListener {
	RunGame thing;
	String theMessage;
	String displayTheCard;
	
	public MinigameScreen(Game game) {
		super(game);
		thing=new RunGame(); 
		theMessage=" ";
	    displayTheCard = " ";
	}
	
	static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static String[] deck = new String[52];
	static String[] fiveCards=new String[5];
	
	public static String[] addArrayValues(String[] deck,String[] fiveCards) {
		//Makes a deck
        for (int i = 0; i < ranks.length; i++) {
        	for (int j = 0; j < suits.length; j++) {
                deck[suits.length*i + j] = ranks[i] + " of " + suits[j];
            }
        }
        
        //Shuffles the deck
        for (int j = 0; j < (suits.length*ranks.length); j++) {
            int r = j + (int) (Math.random() * ((suits.length*ranks.length)-j));
            String t = deck[r];
            deck[r] = deck[j];
            deck[j] = t;
        }
        
        //Sets first five random cards of deck into fiveCards
        for(int h=0;h<fiveCards.length;h++){
        	fiveCards[h]=deck[h];
        }
        
        return fiveCards;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			theMessage=thing.doTheThing();
			displayTheCard="Player's Cards: "+Arrays.toString(addArrayValues(deck,fiveCards));
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
		g2.drawString(theMessage,40,150);
		g2.drawString(displayTheCard, 200, 200);
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}
}
