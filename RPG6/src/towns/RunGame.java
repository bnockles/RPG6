package towns;

import java.util.Arrays;

public class RunGame {
	public RunGame(){
		
	}
	public String doTheThing(){
		return "Instructions: You will be given a five random cards from a standard deck. If you end up with a "
				+ "straight or a flush, then you win the game meaning that you won a free item!";
	}
	public String displayCard(){
		  String print="Player's Cards: ";
		  print+=Arrays.toString(Deck.randomSuits);
		  return print;
	}
}
