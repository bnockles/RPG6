package storyline;

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
public class StoryPoint  {

	private BufferedImage image;//for displaying information about this point of the game in the demo GUI
	public static final int NUMBER_OF_EVENTS = 13;
	private StoryEvent[] events;
	private Descision descisionAtHand;
	private String currentString;
	private boolean choiceMade;
	private int width;
	private int height;
	private int selection;
	private int choiceID;

	public static final String CHAR_NAME = "TROY";
	public static final String GREEN = "GRENDA";
	public static final String YELLOW = "YUNG LI";
	public static final String PURPLE = "PIP";
	public static final String ORANGE = "ORLANDO";	


	//the default storypoint (beginning of the game)
	public StoryPoint(){
		events = new StoryEvent[NUMBER_OF_EVENTS];
		choiceID = 0;
		//automatically fills in all events, since events are numbered
		for(int i = 0; i< NUMBER_OF_EVENTS; i++){
			events[i] = new StoryEvent(i) {
			};
		}
		//The first decision:
	//	StorylineScreen.callImage(DESTORY_VILLAGE);
		String[] context = {"The first seven years of your life were full of bliss.",
				"Kind friends. A warm home. A loving family.",
				"These were the kinds of luxuries you took for granted.",
				"...",
				CHAR_NAME+": What's that?", //background change
				"A fire has started, and is spreading through your entire village!"};
		String[] choices = {"Run left.", "Run right"};
		int[] outcome = {0, 1};
		String[][] consequences= 
		{
			{"You run left as far as you can. Around you, all you can see are the corpses of your neighbors and friends.",
			"You pass by your house on the way, and it doesnt seem like anyone will ever make it out.",
			"You continue to run as far as you can."},
			
			{"You run right as far as you can. Around you, all you can see are the corpses of your neighbors and friends.",
			"You pass by your house on the way, and it doesnt seem like anyone will ever make it out.",
			"You continue to run as far as you can."}
		};
		Choice pickDirection = new Choice(events[StoryEvent.DIRECTION],choices ,outcome, consequences);
		descisionAtHand = new Descision(context, pickDirection);
		currentString = descisionAtHand.nextLine();
		width = 600;
		height = 400;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		choiceMade = false;
		update();

	}

	 public void StoryPoint(StoryEvent[] previousState, int i) {
		this.events = previousState;
		choiceID = i ;
		//automatically fills in all events, since events are numbered
			if (i==StoryEvent.LEFT){
			String[] context = {"You are your village's only survivor.",
					"You eventually find a kingdom.",
					"While the kingdom is wealthy and full, the orphanage is pretty cold...",
					"Still you grow up healthy and strong.",
					"AND REALLY ANGRY!!!!! >:O",
					"ITS TIME TO JOIN THE ARMY!"};
			String[] choices = {"OOH RAH"};
			int[] outcome = {1};
			String[][] consequences= {{"GUNG HO GUNG HO GUNG HO"}};
			Choice armyTime = new Choice(events[StoryEvent.LEFT],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, LEFT);
			}
			if (i==StoryEvent.RIGHT){
			String[] context = {"You are your village's only survivor.",
					"You eventually find a village",
					"It's pretty awful here. You sell matches like the street urchin you are",
					"Straight outta The Little Match Girl...",
					"You grow up on the leaner side. ",
					"But don't fool yourself, you are A LEEAAN MEEAAN MACHINE!!!",
					"TIME TO JOIN THE ARMY!!"
					};
			String[] choices = {"GUNG HO GUNG HO GUNG HO"};
			int[] outcome = {1};
			String[][] consequences= {{"OOH RAH"}};
			Choice armyTime = new Choice(events[StoryEvent.RIGHT],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, RIGHT);
		}
		if (i==StoryEvent.NEW_ALLY){
			String[] context = {"Eventually, you join the army to ensure such injustice never happens again",
					"And possibly enact some revenge....","But to do that you'll need a posse",
					"You usually scare off most people with your intense behavior", "Act more passively to make allies?"};
			String[] choices = {"Do it!", "Do it..."};
			int[] outcome = {1, 1};
			String[][] consequences= {{"You have made new friends!", "They all think you're cool!!", ":>"}, 
			{"You have made friends... sorta", "They think you're alright but they dont invite you out much."}};
			Choice becomeFriends = new Choice(events[StoryEvent.NEW_ALLY],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, NEW_ALLY);
		}
		if (i==StoryEvent.KISS_SO){
		//	StorylineScreen.callImage(KISS_SO);
			String[] context = {"Eventually, you were able to grow close to these friends.",
			"So much so, that you decide you might want to settle down with one."};
			String[] choices = {"<3 Time for relationships. <3", "I have better things to do."};
			int[] outcome = {0,1,2,3,4,5};
			String[][] consequences= {
				{"You decide that "+ YELLOW + " is the one for you", "She's pretty cute.",
				"Lean and a little scary, but cute! <3", "Plus she's into revenge as much as you.", 
				"She trains you in weapons too!"}, 
				
				{"You decide that " + GREEN + " has captured your heart", "What a hottie! Real easy on the eyes ;o", 
				"She's also really easy to talk to.", GREEN + ": UR PRETTY GUD URSELF <3333 ;PPP", "OH MAN",
				"... she trains you... in potions... and other things....", "...so many things////"},
				
				{"You decide that " + PURPLE + " is the man of your dreams", "He's really strong, hoo boy.",
				"You use this to your advantage and ask for his workouts while flirting",PURPLE+": THESE ARE SECRET!!!!", 
				CHAR_NAME+ ": I'll make it worth your wild","You give him the face", "It works ,';^)"},
				
				{"You decide " + ORANGE + " is pretty hunky", "He may be the weakest one here.", 
				"and really shy and loner-y", "But that's his selling points!!!", "You look inside and you see...",
				"He's really good at running and defense."},
				
				{"You decide to do you. Love is way too much work.", "And besides what good can come from it?"}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO);
		}
		if (i==StoryEvent.KISS_SO_YELLOW){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO_YELLOW],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO_YELLOW);
		}
		if (i==StoryEvent.KISS_SO_GREEN){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO_GREEN],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO_GREEN);
		}
		if (i==StoryEvent.KISS_SO_PURPLE){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO_PURPLE],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO_PURPLE);
		}
		if (i==StoryEvent.KISS_SO_ORANGE){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.KISS_SO_ORANGE],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, KISS_SO_ORANGE);
		}
		if (i==StoryEvent.ENDING){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.ENDING],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, ENDING);
		}
		if (i==StoryEvent.DEATH){
			String[] context = {// TODO
			};
			int[] outcome = {};
			String[][] consequences= {{}};
			Choice becomeFriends = new Choice(events[StoryEvent.DEATH],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, DEATH);
		}
		currentString = descisionAtHand.nextLine();
		width = 600;
		height = 400;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		choiceMade = false;
		update();
	 }
	public void update(){
		Graphics2D g = (Graphics2D)image.getGraphics();
		paint(g);
		StorylineScreen.paintScreen(g2);
		// this is to repaint the background white. it maybe work who knows.
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
		if(choiceID==StoryEvent.DIRECTION){
			if(selection == 0)return StoryEvent.LEFT;
			else return StoryEvent.RIGHT;
		}
		else if(choiceID==StoryEvent.LEFT || choiceID==StoryEvent.RIGHT){
			return StoryEvent.NEW_ALLY;
		}
		else if(choiceID==StoryEvent.NEW_ALLY){
			return StoryEvent.KISS_SO;
		}
		else if(choiceID==StoryEvent.KISS_SO){
			if(selection == 0)return StoryEvent.KISS_SO_YELLOW;
			if(selection == 1)return StoryEvent.KISS_SO_GREEN;
			if(selection == 2)return StoryEvent.KISS_SO_PURPLE;
			if(selection == 3)return StoryEvent.KISS_SO_ORANGE;
			else return StoryEvent.REGRET;
		}
		else if(choiceID == StoryEvent.KISS_SO_YELLOW || choiceID == StoryEvent.KISS_SO_GREEN|| 
			choiceID == StoryEvent.KISS_SO_PURPLE || choiceID == StoryEvent.KISS_SO_ORANGE ||){
			return StoryEvent.ENDING;
		}
		else if(choiceID==StoryEvent.REGRET){
			return StoryEvent.DEATH;
		}

	}
}
