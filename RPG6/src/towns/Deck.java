package towns;
/**
 * 
 * @author Yash Patel
 *
 */
public class Deck {
	    public static void main(String[] args) {
	        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	        String[] deck = new String[52];
	       // int SUITS = suits.length;
	       // int RANKS = ranks.length;
	       //int N = SUITS * RANKS;
	        
	        for (int i = 0; i < ranks.length; i++) {
	        	for (int j = 0; j < suits.length; j++) {
	                deck[suits.length*i + j] = ranks[i] + " of " + suits[j];
	            }
       }
	        for (int j = 0; j < (suits.length*ranks.length); j++) {
	            int r = j + (int) (Math.random() * ((suits.length*ranks.length)-j));
	            String t = deck[r];
	            deck[r] = deck[j];
	            deck[j] = t;
        }
	        for (int i = 0; i < suits.length*ranks.length; i++) {
	            System.out.println(deck[i]);
	        }
	    }
}