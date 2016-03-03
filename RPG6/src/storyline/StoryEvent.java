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

	final int DESTROY_VILLAGE = 0;
	final int LEFT = 1;
	final int RIGHT = 2;
	// ^these are for that choice1 thing
	final int NEW_ALLY = 3;
	final int ACCEPT_ALLY = 4;
	final int KISS_SO= 5;
	final int PLOT_TWIST = 6;

	/**
	 * 
	 */
	public StoryEvent(int event) {
		state = false;//most cases start as false
		switch(event){
		case DESTROY_VILLAGE: 	
			description = "Your village has been destroyed.";
			break;
		case LEFT: 	
			description = "You have turned left.";
			break;
		case RIGHT:
			description = "You have turned right.";
			break;

		case NEW_ALLY:
			description = "You have found a new ally.";
			break;
		case ACCEPT_ALLY:
		description = "You have accepted this ally";
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
