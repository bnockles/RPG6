/**
 * 
 */
package storyline;

/**
 * A StoryEvent is something that can happen in the story, 
 * such as having a character join you or gaining a permanent new ability 
 * StoryEvents should be things that affect the game in a major way, and are not mere 
 * inventory items
 * @author bnockles -Tasnia
 *
 */
public abstract class StoryEvent {

	private String description;//how it displays in the demo GUI
	private boolean state;
	

	public static final int DESTROY_VILLAGE = 0;
	public static final int DIRECTION = 1;
	// ^ Left is true Right is false
	// ^these are for that choice1 thing
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int NEW_ALLY = 4;
	public static final int ACCEPT_ALLY = 5;
	public static final int KISS_SO= 6;
	public static final int LOVE_PATH = 7;
	/// vvvv might not keep these(IGNORE)
	public static final int KISS_SO_YELLOW= 8;
	public static final int KISS_SO_GREEN= 9;
	public static final int KISS_SO_PURPLE= 10;
	public static final int KISS_SO_ORANGE= 11;
	public static final int REGRET = 12;
	//^^^ (IGNORE)
	public static final int DEATH = 13;
	public static final int ENDING = 14;
	//final int PLOT_TWIST = WHATEVER THE LAST NUMBER IS; this for later

	/**
	 * 
	 */
	public StoryEvent(int event) {
		state = false;//most cases start as false
		switch(event){
		case DESTROY_VILLAGE: 	
			description = "Your village has been destroyed.";
			break;
		case DIRECTION: 	
			description = "You have turned left.";
			break;
		case NEW_ALLY:
			description = "You have found a new ally.";
			break;
		case ACCEPT_ALLY:
			description = "You have accepted this ally";
			break;
		case KISS_SO:
			description = "Kiss a friend?";
			break;
		case LOVE_PATH:
			description = "Who do you choose?"
			break;
		case KISS_SO_YELLOW:
			description = "You kissed Yellow";
			break;
		case KISS_SO_ORANGE:
			description = "You kissed Orange";
			break;
		case KISS_SO_GREEN:
			description = "You kissed Green";
			break;
		case KISS_SO_PURPLE:
			description = "You kissed Purple";
			break;
		case REGRET:
			description = "What are ya? Afraid? Hmmm??? Whatever, man. Have fun being alone..... forever....";
			break;
		case DEATH:
			description = "YOU DIE!!!!!!!!";
			break;
		case ENDING:
			description = "DEMO ENDS";
			break;
	  }
	}

	public String getDescription() {
		return description;
	}

	public boolean state() {
		return state;
	}
	
	public void setState(boolean newState) {
		this.state = newState;
	}
	
}
