package towns;
import java.util.Random;
import java.util.ArrayList;
/**
 * 
 * @author Yash Patel
 *
 */
public class Deck {
     static ArrayList<Card> cards;
    
    public Deck() {
	        cards = new ArrayList<Card>();
	        int index_1, index_2;
	        Random generator = new Random();
	        Card temp;
	        int count=0;
	        while(count<5){
	        for(int i=0; i<=3; i++)
	        {
	            for(int j=0; j<=12; j++){
	               cards.add(new Card(i,j));
	             //  System.out.println(cards.get(i).toString());
	               count++;
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
