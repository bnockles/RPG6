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
	private int choices;
	// this is so we arent limited to 2 choices, allowing more branching
	// 0 would be false, 1 true 
	private boolean state;

	public static final int DESTROY_VILLAGE = 0;
	public static final int DIRECTION = 1;
	// ^ Left is true Right is false
	// ^these are for that choice1 thing
	public static final int NEW_ALLY = 2;
	public static final int ACCEPT_ALLY = 3;
	public static final int KISS_SO= 4;
	/// vvvv might not keep these
	final int KISS_SO_YELLOW= 5;
	final int KISS_SO_GREEN= 6;
	final int KISS_SO_PURPLE= 7;
	final int KISS_SO_ORANGE= 8;
	//^^^
	//final int PLOT_TWIST = 9; this for later

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
			description = "Will you kiss a friend?";
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
	  }
	}

	public String getDescription() {
		return description;
	}


	public boolean state() {
		return state;
	}
	
	public int getChoices(){
		return choices;
	}

	public void setState(boolean newState) {
		this.state = newState;
	}
	
	public void setChoices(int choices) {
		this.state = choices;
	}



}
