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
 * @author bnockles
 *
 */
public class StoryPoint {

	private BufferedImage image;//for displaying information about this point of the game in the demo GUI
	public static final int NUMBER_OF_EVENTS = 6;
	private StoryEvent[] events;
	private Descision descisionAtHand;
	private String currentString;
	private boolean choiceMade;
	private int width;
	private int height;
	private int selection;
	private int choiceID;

	public static final String CHAR_NAME = "TROY";
	
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
		String[] context = {"It had been six years since your mother died",
				"Ever since then it was just you and your father...",
				"Living in the wilderness was never easy...",
				"Especially after the arrival of King Letralus",
				"The king withdrew the army from the farther reachest of the kingdom",
				"And that included the little region near the falls where your father and you had been living together",
				"Monsters had crept in...",
				"Making the forest more dangerous than ever...",
				"...",
				CHAR_NAME+": What's that?",
				"FATHER: I'll go check it out..."};
		String[] choices = {"Follow him.", "Stay home"};
		boolean[] outcome = {true, true};
		String[][] consequences= {{"FATHERR: You need to stay here.",CHAR_NAME+": I'm scare for you.","FATHER: I said stay! It's too dangerous!","","",CHAR_NAME+":FAAAAAATHER!"}, {"","",CHAR_NAME+":FAAAAAATHER!"}};
		Choice followFather = new Choice(events[StoryEvent.FATHER_LEAVES],choices ,outcome, consequences);
		descisionAtHand = new Descision(context, followFather);
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
	
		if (i==StoryEvent.SWORD_FOUND){
			String[] context = {CHAR_NAME+": What is that gleaming light?",
					CHAR_NAME+": It looks like it's made of metal.",
					CHAR_NAME+": It looks like its been laying here for years...",
					CHAR_NAME+": ...but it isn't at all rusted.",
					CHAR_NAME+": Is that a sword?"};
			String[] choices = {"Take.", "Don't take."};
			boolean[] outcome = {true, true};
			String[][] consequences= {{"You have obtained a strange sword. Though it seems older than you can image, the blade is infinitely sharp!"}, {"Come on, you know you want to take it...","Take.","You have obtained a strange sword. Though it seems older than you can image, the blade is infinitely sharp!"}};
			Choice takeSword = new Choice(events[StoryEvent.SWORD_FOUND],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, takeSword);
		}		if (i==StoryEvent.BOSS_1_DEFEATED){
			String[] context = {"MYSTERIOUS VOICE: Did you ever wonder why King Letralus withdrew his trops from the forest?",
					CHAR_NAME+": Who's there?",
					"MYSTERIOUS VOICE: Only a loyal servant of King Letralus.",
					CHAR_NAME+": Show yourself!",
					"MYSTERIOUS VOICE: <chuckle><chuckle> If you insisssssst.",
					"GIANT SNAKE: Nicccce to meet you, brave adventurer.",
					CHAR_NAME+": You're no servant of the king!.",
					"GIANT SNAKE: Show's how little you know."};
			String[] choices = {"Attack"};
			boolean[] outcome = {true};
			String[][] consequences= {{"The GIANT SNAKE twitches as the life escapes from its body.",CHAR_NAME+": Why did he say he was a servant of the king?"}};
			Choice takeSword = new Choice(events[StoryEvent.BOSS_1_DEFEATED],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, takeSword);
		}if (i==StoryEvent.GEAR_FOUND){
			String[] context = {"A rare alatnium gear lays on the ground."};
			String[] choices = {"Take gear.","Do not take gear."};
			boolean[] outcome = {true, false};
			String[][] consequences= {{"You gain an alatnium gear. It is harder than diamond."},{CHAR_NAME+": I can probably find one of those elsewhere."}};
			Choice takeSword = new Choice(events[StoryEvent.BOSS_1_DEFEATED],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, takeSword);
		}
		if (i==StoryEvent.AIRSHIP_UNLOCKED){
			String[] context = {"NORM: Have you got a alatnium gear?"};
			String[] choices = {"Give gear.","Do not give gear."};
			boolean[] outcome = {true, false};
			String[][] consequences= {{"NORM: Do you understand how hard these are to find!?","NORM: How did you ever find one of these?",CHAR_NAME+": It was in the den of the giant snake I defeated in the last StoryPoint","NORM: Whoah, that's so meta."},{"NORM: Well, let me know if you ever find one."}};
			Choice takeSword = new Choice(events[StoryEvent.BOSS_1_DEFEATED],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, takeSword);
		}if(i==StoryEvent.GEAR_BOUGHT){
			String[] context = {"PEDLER: You can buy this rare gear for only 10,000 nerp."};
			String[] choices = {"Buy gear.","Do not buy gear."};
			boolean[] outcome = {true, false};
			String[][] consequences= {{"PEDLER: Pleasure doing business with you!"},{"PEDLER: It's a shame. These gears are so rare."}};
			Choice takeSword = new Choice(events[StoryEvent.GEAR_FOUND],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, takeSword);
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
		if(descisionAtHand.isDisplayingLastLine()){
			descisionAtHand.getChoices().choose(i);
			choiceMade = true;
			currentString = descisionAtHand.getChoices().nextLine();
			selection = i;		
		}

	}

	//determines which point to go to next, depending on the decision that was previously made
	public int getNextPoint() {
		if(choiceID==StoryEvent.FATHER_LEAVES)return StoryEvent.SWORD_FOUND;
		else if(choiceID==StoryEvent.SWORD_FOUND)return StoryEvent.BOSS_1_DEFEATED;
		else if(choiceID==StoryEvent.BOSS_1_DEFEATED)return StoryEvent.GEAR_FOUND;
		else if(choiceID==StoryEvent.GEAR_FOUND){
			if(selection == 0)return StoryEvent.AIRSHIP_UNLOCKED;
			else return StoryEvent.GEAR_BOUGHT;
		}
		else if(choiceID==StoryEvent.GEAR_BOUGHT){
			if(selection == 0)return StoryEvent.AIRSHIP_UNLOCKED;
			else return StoryEvent.GEAR_BOUGHT;
		}
		return 0;
	}

}
