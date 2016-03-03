/**
 * 
 */
package storyline;

/**
 * A PlotEvent is something that can happen in the story, 
 * such as having a character join you or gaining a permanent new ability 
 * PlotEvents should be things that affect the game in a major way, and are not mere 
 * inventory items
 * 
 *
 */
public abstract class PlotEvent {

	private String description;//how it displays in the demo GUI
	private boolean state;

	public static final int DESTORY_VILLAGE = 0;
	public static final int DIRECTION = 1
	// ^ choic
	public static final int NEW_ALLY = 2;
	public static final int ACCEPT_ALLY = 3;
	// ^choice
	public static final int KISS_SO= 4;
	// ^choice
	public static final int PLOT_TWIST = 5;
	final int DEATH = 6;

	/**
	 * 
	 */
	public PlotEvent(int event) {
		state = false;//most cases start as false
		switch(event){
		case FATHER_LEAVES: 	
			description = "Father has left";
			break;
		case SWORD_FOUND: 	
			description = "Monster Slaying Sword found";
			break;
		case BOSS_1_DEFEATED:
			description = "Boss one defeanted";
			break;

		case GEAR_FOUND:
			description = "Alatnium gear found";
			break;
		case AIRSHIP_UNLOCKED:
		description = "Airship unlocked";
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
