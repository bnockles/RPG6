package towns;

/**
 * 
 * @author Khandaker Shayel
 *
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Minigame extends AbstractNPC {

	public void setComputerPlay(String computerPlay) {
		this.computerPlay = computerPlay;
	}

	public String getComputerPlay() {
		return computerPlay;
	}

	public Minigame(String nm, String gen, String des, boolean talkable) {
		super(nm, gen, des, talkable);
		// TODO Auto-generated constructor stub
	}
	

    String computerPlay;

	public void playRPS(){
		int loses=0;
		int wins=0;
		
		Random generator = new Random(); 
		 //Generate computer's play (0,1,2) 
	    int computerInt = generator.nextInt(3)+1; 
	    //Translate computer's randomly generated play to 
	    //string using if //statements 
	    if (computerInt == 1){ 
	       computerPlay = "R";
	       System.out.println("Computer: R");
	    }
	    else if (computerInt == 2){ 
	       computerPlay = "P"; 
	       System.out.println("Computer: P");
	    }
	    else if (computerInt == 3){ 
	       computerPlay = "S"; 
	       System.out.println("Computer: S");
	    }
	}
	
	public void flipCoin(){
		Random generator = new Random(); 
		 //Generate computer's play (0,1,2) 
	    int computerInt = generator.nextInt(2)+1; 
	    //Translate computer's randomly generated play to 
	    //string using if //statements 
	    if (computerInt == 1){ 
	       computerPlay = "H";
	       System.out.println("Computer: H");
	    }
	    else if (computerInt == 2){ 
	       computerPlay = "T"; 
	       System.out.println("Computer: T");
	    }
	}
	
	@Override
	public void npcMovement() {
		// TODO Auto-generated method stub
	}
}
