package example;

import java.util.ArrayList;

public class Choice {

	StoryEvent event;
	String[] choiceDesciption;
	boolean[] effects;
	String[][] consequences;
	int choice;
	int displayingLine;
	
	
	public Choice(StoryEvent event, String[] choiceDesciption, boolean[] effects, String[][] consequences) {
	this.event = event;
		this.choiceDesciption = choiceDesciption;
		this.effects = effects;
		this.consequences = consequences;
		displayingLine = -1;
	}
	
	public String[] getChoiceDesciptions(){
		return choiceDesciption;
	}
	
	public String[][] getChoiceConsequences(){
		return consequences;
	}
	
	public String nextLine(){
		displayingLine++;
		if(displayingLine < consequences[choice].length)
		return consequences[choice][displayingLine];
		else return "";
	}
	

	
	public boolean isDisplayingLastLine(){
		return displayingLine>=consequences[choice].length-1;
	}
	
	
	public void choose(int choice){
		event.setState(effects[choice]);
		this.choice = choice; 
		
	}
	
	

}
