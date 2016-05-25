	package Battles;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;

	/**
	 *
	 * Java program to read file using Scanner class in Java.
	 * java.util.Scanner is added on Java 5 and offer convenient method to read data
	 *
	 * @author
	 */
	public class Reader {
	    
	    static ArrayList<String> displayText = new ArrayList<String>();
	    private static Scanner scnr;

		public Reader() throws FileNotFoundException {
	 
	    	File text = new File("story.txt");
	    	scnr = new Scanner(text);
	    
	    	while(scnr.hasNextLine()){
	        	String line = scnr.nextLine();
	        	displayText.add(line);
	    	}
		}  
	    
	    //retrieves each line of dialogue for battles and ensures each is less than 50 characters
	    public String getBattleDialouge(int index){
	   	 return displayText.get(index);
	    }
	    
	    //retrieves the total number of lines in each dialogue
	    public int checkBattleDialogueLength(){
	   	 return displayText.size();
	    }
	 
	}
