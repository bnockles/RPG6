package example;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This class is a point in the story where something can change
 * it inherits the StoryEvents from the previous StoryPoint but also
 * presents a decision that can change the story 
 * @author bnockles - Tasnia
 *
 */
public class StoryPoint {

	private BufferedImage image;//for displaying information about this point of the game in the demo GUI
	public static final int NUMBER_OF_EVENTS = 5;
	private StoryEvent[] events;
	private Descision descisionAtHand;
	private String currentString;
	private boolean choiceMade;
	private int width;
	private int height;
	private int selection;
	private int choiceID;

	public static final String CHAR_NAME = "TROY";
	public static final String LOVE_GAL_1 = "GRENDA";
	public static final String LOVE_GAL_2 = "YUNG LI";
	public static final String LOVE_BOY_1 = "PIP";
	public static final String LOVE_BOY_2 = "ORLANDO";	
	

	//the default storypoint (beginning of the game)
	public StoryPoint(){
		events = new StoryEvent[NUMBER_OF_EVENTS];
		choiceID = 1;
		//automatically fills in all events, since events are numbered
		for(int i = 0; i< NUMBER_OF_EVENTS; i++){
			events[i] = new StoryEvent(i) {
			};
		}
		//The first decision:
		StorylineScreen.callImage(DESTORY_VILLAGE);
		String[] context = {"The first seven years of your life were full of bliss.",
				"Kind friends. A warm home. A loving family.",
				"These were the kinds of luxuries you took for granted.",
				"...",
				CHAR_NAME+": What's that?", //background change
				"A fire has started, and is spreading through your entire village!"};
		String[] choices = {"Run left.", "Run right"};
		boolean[] outcome = {true, false};
		String[][] consequences= {{"You run left as far as you can. Around you, all you can see are the corpses of your neighbors and friends. You pass by your house on the way, and it doesnt seem like anyone will ever make it out. You continue to run as far as you can.","You run right as far as you can. Around you, all you can see are the corpses of your neighbors and friends. You pass by your house on the way, and it doesnt seem like anyone will ever make it out. You continue to run as far as you can."}};
		Choice pickDirection = new Choice(events[StoryEvent.DIRECTION],choices ,outcome, consequences);
		descisionAtHand = new Descision(context, pickDirection);
		currentString = descisionAtHand.nextLine();
		width = 600;
		height = 400;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		choiceMade = false;
		update();

	}

	public StoryPoint(StoryEvent[] previousState, int i) {
		this.events = previousState;
		choiceID = i ;
		//automatically fills in all events, since events are numbered

		if (i==StoryEvent.NEW_ALLY){
			StorylineScreen.callImage(NEW_ALLY);
			String[] context = {"Eventually, you are found by the troops of a neighboring kingdom. You are your village's only survivor.",
					"As the days pass by in the neighboring kingdom, you grow increasingly angry.",
					CHAR_NAME+":Who was it that took away my family? Who was it that ruined my life?",
					"Eventually, you join the army to answer this question.",
					"Later on, you are approached by a strange group of people, asking if you would like to be allies."};
			String[] choices = {"Become allies", "Do not become allies."};
			boolean[] outcome = {true, true};
			String[][] consequences= {{"You have made new friends!"}, {"Come on, you know you want to be friends...", "It's not like you have any other ones..."}};
			Choice becomeFriends = new Choice(events[StoryEvent.NEW_ALLY],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, NEW_ALLY);
			currentString = descisionAtHand.nextLine();
			width = 600;
			height = 400;
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			choiceMade = false;
			update();
		}
	}
	public StoryPoint(StoryEvent[] previousState, int i) {
		this.events = previousState;
		choiceID = i ;
		if (i==StoryEvent.KISS_SO){
			StorylineScreen.callImage(KISS_SO);
			String[] context = {"Eventually, you were able to grow close to these friends.",
					"So much so, that you decide you might want to settle down with one."};
			String[] choices = {"Kiss someone you care about", "Do not kiss anyone.."};
			boolean[] outcome = {true, true};
			String[][] consequences= {{"You decide to maybe take one of them on a date"}, {"You decide to be a hermit forever."}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO);
			currentString = descisionAtHand.nextLine();
			width = 600;
			height = 400;
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			choiceMade = false;
			update();
			
		}
	}
	public void update(){
		Graphics2D g = (Graphics2D)image.getGraphics();
		paint(g);
	}

	public void paint(Graphics2D g){
		g.setColor(new Color(200,200,200));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		final int LINE_SPACE = 30;
		int y = 40;
		g.drawString("PRESS 'Q' TO JUMP TO THE NEXT POINT IN THE STORY.",30, y);
		y+=LINE_SPACE;
		for(StoryEvent se : events){
			y=printMultiLine(g, se.getDescription() + ": "+ se.state(), 30, y, 75);
		}
		g.setColor(Color.blue);
		g.fillRect(15, y-20, width-30, 175);
		g.setColor(Color.white);
		g.drawString("CURRENT DESCISION",30, y);
		y+=LINE_SPACE;

		if(!choiceMade){
			y=printMultiLine(g,currentString, 30, y, 70);
			if(descisionAtHand.isDisplayingLastLine()){
				for(int i = 0; i<descisionAtHand.getChoices().getChoiceDesciptions().length; i++){
					String str = (i+1)+") "+descisionAtHand.getChoices().getChoiceDesciptions()[i];
					y=printMultiLine(g,str, 30, y, 70);
				}
				g.drawString("Select by pressing the number of your choice",30, y);
			}
		}else{
			y=printMultiLine(g,currentString, 30, y, 70);
		}

	}

	/**
	 * 
	 * @param g
	 * @param s
	 * @param x
	 * @param y
	 * @return the y coordinate after multiple lines have been added
	 */
	public static int printMultiLine(Graphics2D g, String s, int x, int y, int length){
		String[] strings = s.split(" ");
		ArrayList<String> lines = new ArrayList<String>();
		String currentLine = "";
		int i = 0;
		while(i<strings.length){
			while (i< strings.length && currentLine.length()+strings[i].length() < length){
				currentLine+=strings[i]+" ";
				i++;
			}
			//			System.out.println("length is "+ currentLine.length());
			lines.add(currentLine);
			currentLine = "";
		}
		for(String str: lines){
			g.drawString(str, x, y);
			y+=30;
		}
		return y;

	}

	//returns true when this sequence is over
	public boolean nextLn(){
		if(!choiceMade){
			if(!descisionAtHand.isDisplayingLastLine())currentString=descisionAtHand.nextLine();

		}else{
			if(!descisionAtHand.getChoices().isDisplayingLastLine())currentString=descisionAtHand.getChoices().nextLine();
			else return true;
		}
		update();
		return false;
	}

	public BufferedImage getImage(){
		return image;
	}

	public StoryEvent[] getEvents(){
		return events;
	}

	public void select(int i) {
		selection = i;		
		descisionAtHand.getChoices().choose(i);
		choiceMade = true;
		if(descisionAtHand.isDisplayingLastLine()){
			currentString = descisionAtHand.getChoices().nextLine();
		}else{
			currentString="";
		}


	}

	//determines which point to go to next, depending on the decision that was previously made
	public int getNextPoint() {
		if(choiceID==StoryEvent.LEFT)return StoryEvent.NEW_ALLY;
		else if(choiceID==StoryEvent.NEW_ALLY)return StoryEvent.KISS_SO;
		else if(choiceID==StoryEvent.KISS_SO){
//			if(selection == 0)return "This is the end of the game.";
//			else return StoryEvent.GEAR_BOUGHT;
//		}
		return 0;
	}

}
