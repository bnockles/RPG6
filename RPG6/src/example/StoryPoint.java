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

	//the default storypoint (beginning of the game)
	public StoryPoint(){
		events = new StoryEvent[NUMBER_OF_EVENTS];
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
				"You: What's that?",
				"Father: I'll go check it out...",
		"What do you do?"};
		String[] choices = {"Follow him.", "Stay home"};
		boolean[] outcome = {true, true};
		String[][] consequences= {{"Father: You need to stay here.","You: I'm scare for you.","Father: I said stay! It's too dangerous!","You trail behind him anyway","You walk about a mile, and your father disappears as he descends down a rocky crag","A beast howls and your father's terrified screams echo in your ears."}, {"You decide to stay home","Later you hear your father screaming. I guess he died."}};
		Choice followFather = new Choice(events[StoryEvent.FATHER_LEAVES],choices ,outcome, consequences);
		descisionAtHand = new Descision(context, followFather);
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
		for(StoryEvent se : events){
			y=printMultiLine(g, se.getDescription() + ": "+ se.state(), 30, y, 70);
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
	
	public StoryPoint(StoryEvent[] previousState, int i) {
		this.events = previousState;
		//automatically fills in all events, since events are numbered

		if (i==2){
			String[] context = {"It had been SEVEN years since your mother died",
					"Ever since then it was just you and your father...",
					"Living in the wilderness was never easy...",
					"Especially after the arrival of King Letralus",
					"The king withdrew the army from the farther reachest of the kingdom",
					"And that included the little region near the falls where your father and you had been living together",
					"Monsters had crept in...",
					"Making the forest more dangerous than ever...",
					"...",
					"You: What's that?",
					"Father: I'll go check it out...",
			"What do you do?"};
			String[] choices = {"Follow him.", "Stay home"};
			boolean[] outcome = {true, true};
			String[][] consequences= {{"Father: You need to stay here.","You: I'm scare for you.","Father: I said stay! It's too dangerous!","You trail behind him anyway","You walk about a mile, and your father disappears as he descends down a rocky crag","A beast howls and your father's terrified screams echo in your ears."}, {"You decide to stay home","Later you hear your father screaming. I guess he died."}};
			Choice followFather = new Choice(events[StoryEvent.SWORD_FOUND],choices ,outcome, consequences);
			descisionAtHand = new Descision(context, followFather);
		}
		currentString = descisionAtHand.nextLine();
		width = 600;
		height = 400;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		choiceMade = false;
		update();
	}

	public void select(int i) {
		if(descisionAtHand.isDisplayingLastLine()){
			descisionAtHand.getChoices().choose(i);
			choiceMade = true;
			currentString = descisionAtHand.getChoices().nextLine();
					
		}

	}

}
