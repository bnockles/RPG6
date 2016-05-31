package towns;

import java.util.Arrays;
import java.util.Random;

public class RunGame {
	public RunGame(){
		
	}
	public String doTheThing(){
		return "Instructions: You will be given a five random cards from a standard deck. If you end up with a "
				+ "straight or a flush, then you win the game meaning that you won a free item!";
	}
	public String displayCard(){
		  String print="Player's Cards: ";
		  print+=Arrays.toString(Deck.deck);
		  return print;
	}
	public static Card[] randomizeArray(Card[] array){
		Random rgen = new Random();	
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    Card temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
}
