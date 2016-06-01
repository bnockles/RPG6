package towns;

import java.util.Arrays;

public class RunGame {
	public RunGame(){
		
	}
	public String doTheThing(){
		return "Instructions: You will be given five random cards from a standard deck. If you end up with a "
				+ "straight and/or a flush, then you win the game meaning that you won a free item!";
	}
	public boolean isStraight(int[] hand) {

	    if(hand == null || hand.length != 5) {
	        return false;
	    }
	    else {
	        // Automatically sort the hand
	        Arrays.sort(hand);

	        // Set the "previous" variable to a theoretically impossible value
	        int prev = -1;

	        // Iterate through the hand and see if the next card is exactly one more than
	        //    the previous one.
	        for(int i = 0; i < hand.length; i++) {

	            // If prev is -1, then this is the first time through the for-loop
	            // If the card that we're on has a value of the previous card + 1,
	            //     we still have the possibility of a straight.
	            if(prev == -1 || (prev + 1) == hand[i]) {
	                prev = hand[i];
	            }
	            else {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
