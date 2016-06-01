package towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import directors.Game;
import directors.Screen;


public class MinigameScreen extends Screen implements KeyListener {
	
	//Fields
	String theMessage;
	String displayTheCard;
	String theMessageTwo;
	String theMessageThree;
	String theMessageFour;
	static Item item;
	
	public MinigameScreen(Game game) {
		super(game);
		theMessage=" ";
		theMessageTwo=" ";
	    displayTheCard = " ";
	    theMessageThree=" ";
	    theMessageFour=" ";
	}
	
	//Text to be displayed upon key listener
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
	
	public String doTheThingFour(){
		return "Your reward is "+ item + "!!! Congrats!!!";
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
	
	//Checks for player win
	static boolean win=false;
	
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
        
        //Helper method shuffles the deck
        shuffleDeck(suits, ranks, deck, fullShuffledRank, fullShuffledSuit);
        
        //Helper method which sets a five card hand for the player
        setHand(fiveCards, deck, fiveShuffledSuit, fiveShuffledRank, fullShuffledSuit, fullShuffledRank);
        
        String print="Player's Cards: "+Arrays.toString(fiveCards);
        
        //Check if suits match
        boolean checkFlush=true;
        checkFlush=checkFlush(checkFlush, fiveShuffledSuit); //Helper method
        if(checkFlush==true){
        	print+="                 You have a flush meaning you won a free item!";
        }
        
        //Check if ranks match
        boolean checkStraight=true;
        checkStraight=checkStraight(checkStraight, fiveShuffledRank); //Helper method
        if(checkStraight==true){
        	print+="                 You have a straight meaning you won a free item!";
        }
        
        //Checks if 4 of same card
        boolean checkFour=true;
        checkFour=checkFour(checkFour, fiveShuffledRank); //Helper method
        	if(checkFour==true){
        		print+="                 You have four of the same rank meaning you won a free item!";
        	}
        	
        //Sets win boolean to true if player wins the game
        if(checkFlush==true || checkStraight==true || checkFour==true){
        	win=true;
        }
        
        //Sees if player qualifies for an item (Integration used from interface)
        if(win==true){
        	for(int i=0;i<Equipment.ItemArrayList.size();i++){
        		if(Equipment.getDurability()<50 && Equipment.getRarity()<50 && Equipment.priceOfItem()<5000&&
	        		Equipment.playerHasItem()==false){
        				item=Equipment.ItemArrayList.get(i);
        		}
        	}
        }
        
        return print;
	}
	public static void shuffleDeck(String[] suits, int[] ranks, String[] deck, int[] fullShuffledRank, String[] fullShuffledSuit){
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
	}
	
	public static void setHand(String[] fiveCards, String[] deck, String[] fiveShuffledSuit, int[] fiveShuffledRank, 
			String[] fullShuffledSuit, int[] fullShuffledRank){
		//Sets first five random cards of deck into fiveCards
        for(int h=0;h<fiveCards.length;h++){
        	fiveCards[h]=deck[h];
        	fiveShuffledSuit[h]=fullShuffledSuit[h];
        	fiveShuffledRank[h]=fullShuffledRank[h];
        }
	}
	
	public static boolean checkFlush(boolean checkFlush, String[] fiveShuffledSuit){
		//Checks player's hand for a flush
		for(int i=0;i<fiveShuffledSuit.length-1;i++){
        	if(!fiveShuffledSuit[i].equals(fiveShuffledSuit[i+1])){
        		checkFlush=false;
        	}
        }
		return checkFlush;
	}
	
	public static boolean checkStraight(boolean checkStraight, int[] fiveShuffledRank){
		//Checks player's hand for a straight
    	Arrays.sort(fiveShuffledRank);
		for(int i=0; i<fiveShuffledRank.length-1;i++){
        	if(fiveShuffledRank[i]!=(fiveShuffledRank[i+1])){
        		checkStraight=false;
        	}
        }
		return checkStraight;
	}
	
	public static boolean checkFour(boolean checkFour, int[] fiveShuffledRank ){
		//Checks player's hand for four of the same rank
		Arrays.sort(fiveShuffledRank);
    	if((fiveShuffledRank[0]!=fiveShuffledRank[1]) || (fiveShuffledRank[1]!=fiveShuffledRank[2]) ||
    			(fiveShuffledRank[2]!=fiveShuffledRank[3]) || (fiveShuffledRank[3]!=fiveShuffledRank[4]) ||
    			(fiveShuffledRank[4]!=fiveShuffledRank[5])){
    		checkFour=false;
    	}
    	return checkFour;
	}
	
	int counter=0;
	public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_SPACE && counter<3 && win==false){
				theMessage=doTheThing();
				theMessageTwo=doTheThingTwo();
				displayTheCard=addArrayValues();
				counter++;
			}
			if(counter==3){
				theMessageThree=doTheThingThree();
			}
			if(win==true){
				theMessageFour=doTheThingFour();
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
		g2.drawString(theMessageFour, 40, 275);
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}
}
