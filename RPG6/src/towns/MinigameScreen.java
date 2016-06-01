package towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import directors.Game;
import directors.Screen;


public class MinigameScreen extends Screen implements KeyListener {
	String theMessage;
	String displayTheCard;
	String theMessageTwo;
	String theMessageThree;
	
	public MinigameScreen(Game game) {
		super(game);
		theMessage=" ";
		theMessageTwo=" ";
	    displayTheCard = " ";
	    theMessageThree=" ";
	}
	
	//Instructions when game is started
	public String doTheThing(){
		return "Instructions: You will be given five random cards from a standard deck. If you end up with a "
				+ "straight, a flush, and/or four of the same rank then you win the game meaning ";
	}
	
	public String doTheThingTwo(){
		return "that you won a free item! You have three turns in getting a new deck by pressing the space bar!";
	}
	
	public String doTheThingThree(){
		return "You have used up your three chances. You lost the game. No free item for you.";
	}
	
	//Arrays
	static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static int[] ranks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	
	static String[] deck = new String[52];
	static String[] fiveCards=new String[5];
	
	static String[] fullShuffledSuit=new String [52];
	static int[] fullShuffledRank=new int [52];
	
	static String[] fiveShuffledSuit=new String[5];
	static int[] fiveShuffledRank=new int[5];
	
	//Makes the actual deck of cards by putting in values into the empty arrays
	public static String addArrayValues() {
		//Makes a deck
        for (int i = 0; i < ranks.length; i++) {
        	for (int j = 0; j < suits.length; j++) {
                deck[suits.length*i + j] = ranks[i] + " of " + suits[j];
                fullShuffledSuit[suits.length*i+j]=suits[j];
                fullShuffledRank[suits.length*i+j]=ranks[i];
            }
        }
        
        //Shuffles the deck
        for (int j = 0; j < (suits.length*ranks.length); j++) {
            int r = j + (int) (Math.random() * ((suits.length*ranks.length)-j));
            String temp = deck[r];
            String tempSuit=fullShuffledSuit[r];
            int tempRank=fullShuffledRank[r];
            deck[r] = deck[j];
            fullShuffledSuit[r]=fullShuffledSuit[j];
            fullShuffledRank[r]=fullShuffledRank[j];
            deck[j] =temp;
            fullShuffledSuit[j]=tempSuit;
            fullShuffledRank[j]=tempRank;
        }
        
        //Sets first five random cards of deck into fiveCards
        for(int h=0;h<fiveCards.length;h++){
        	fiveCards[h]=deck[h];
        	fiveShuffledSuit[h]=fullShuffledSuit[h];
        	fiveShuffledRank[h]=fullShuffledRank[h];
        }
        
        String print="Player's Cards: "+Arrays.toString(fiveCards);
        
        //Check if suits match
        boolean checkFlush=true;
        for(int i=0;i<fiveShuffledSuit.length-1;i++){
        	if(!fiveShuffledSuit[i].equals(fiveShuffledSuit[i+1])){
        		checkFlush=false;
        	}
        }
        if(checkFlush==true){
        	print+="                 You have a flush meaning you won a free item!";
        }
        
        //Check if ranks match
        boolean checkStraight=true;
        for(int i=0; i<fiveShuffledRank.length-1;i++){
        	Arrays.sort(fiveShuffledRank);
        	if(fiveShuffledRank[i]!=(fiveShuffledRank[i+1])){
        		checkStraight=false;
        	}
        }
        if(checkStraight==true){
        	print+="                 You have a straight meaning you won a free item!";
        }
        
        //Checks if 4 of same card
        boolean checkFour=true;
        	Arrays.sort(fiveShuffledRank);
        	if((fiveShuffledRank[0]!=fiveShuffledRank[1]) || (fiveShuffledRank[1]!=fiveShuffledRank[2]) ||
        			(fiveShuffledRank[2]!=fiveShuffledRank[3]) || (fiveShuffledRank[3]!=fiveShuffledRank[4]) ||
        			(fiveShuffledRank[4]!=fiveShuffledRank[5])){
        		checkFour=false;
        	}
        	if(checkFour==true){
        		print+="                 You have four of the same rank meaning you won a free item!";
        	}
        
        if(checkFlush==true || checkStraight==true || checkFour==true){
        	print+="   You win ";
        }
        
        return print;
	}
	
	int counter=0;
	public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_SPACE && counter<3){
				theMessage=doTheThing();
				theMessageTwo=doTheThingTwo();
				displayTheCard=addArrayValues();
				counter++;
			}
			if(counter==3){
				theMessageThree=doTheThingThree();
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
		g2.drawString(theMessageTwo,200,175);
		g2.drawString(displayTheCard, 30, 225);
		g2.drawString(theMessageThree, 40, 275);
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}
}
