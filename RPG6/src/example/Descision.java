package example;

import java.util.ArrayList;

/**
 * A decision is present in every story point, it contains the information presented to the player, 
 * the possible decisions, and the effect of each decision
 * @author bnockles
 *
 */
public class Descision {

	
	String[] contextLines;
	Choice choices;
	int displayingLine;
	
	public Descision(String[] contextLines, Choice choice) {
		this.contextLines = contextLines;
		this.choices = choice;
		displayingLine=-1;
	}

	public String nextLine(){
		displayingLine++;
		return contextLines[displayingLine];
	}
	

	
	public boolean isDisplayingLastLine(){
		return displayingLine==contextLines.length-1;
	}
	
	public Choice getChoices(){
		return choices;
	}

}
