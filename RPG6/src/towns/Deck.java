package towns;

import java.util.Arrays;

/**
 * 
 * @author Yash Patel
 *
 */
public class Deck {
		//Creation of Arrays
		static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		static String[] deck = new String[52];
		static String[] fiveCards=new String[5];
    
	    public static void main(String[] args) {	
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
	        getTheRightString(fiveCards);
	    }
	    public static String getTheRightString(String[] array){
	        String print="Player's Cards: ";
        	print+=Arrays.toString(array);
        	System.out.println(print);
        	return print;
        }
}