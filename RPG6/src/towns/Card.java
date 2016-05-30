package towns;
/**
 * 
 * @author Yash Patel
 *
 */
public class Card {
	public int rank, suit;

	    public static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
	    public static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	    
	    public static String rankAsString(int rank) {
	        return ranks[rank];
	    }
	    
	    Card(int suit, int rank) {
	        this.rank=rank;
	        this.suit=suit;
	    }
	    
//	    public @Override String toString() {
//	          return ranks[rank] + " of " + suits[suit];
//	    }
	    
	    public int getRank() {
	         return rank;
	    }
	    public int getSuit() {
	        return suit;
	    }
	    
	}