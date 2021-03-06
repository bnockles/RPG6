package towns;
import java.util.Random;
import java.util.ArrayList;
/**
 * 
 * @author Yash Patel
 *
 */
public class Deck {
    private ArrayList<Card> cards;
    
    private Deck() {
	        cards = new ArrayList<Card>();
	        int index_1, index_2;
	        Random generator = new Random();
	        Card temp;
	        for(int i=0; i<=3; i++)
	        {
	            for(int j=0; j<=12; j++){
	             
	               cards.add(new Card(i,j));
	             }
	        }
	        int size = cards.size()-1;
	        for (int i=0; i<100; i++)
	        {
	            index_1 = generator.nextInt(size);
	            index_2 = generator.nextInt(size);
	            temp = (Card) cards.get(index_2);
	            cards.set( index_2 , cards.get( index_1 ) );
	            cards.set( index_1, temp );
	        }
	    }
    public Card drawFromDeck()
    {     
        return cards.remove( cards.size()-1 );
    }
    public int getTotalCards()
    {
        return cards.size();
    }
}
