/**
 * 
 */
package example;

/**
 * A StoryEvent is something that can happen in the story, 
 * such as having a character join you or gaining a permanent new ability 
 * StoryEvents should be things that affect the game in a major way, and are not mere 
 * inventory items
 * @author bnockles
 *
 */
public abstract class StoryEvent {

	private String description;//how it displays in the demo GUI
	private boolean state;

	public static final int FATHER_LEAVES = 0;
	public static final int SWORD_FOUND = 1;
	public static final int BOSS_1_DEFEATED = 2;
	public static final int BOSS_2_DEFEATED = 3;
	public static final int BOSS_3_DEFEATED = 4;
	public static final int AIRSHIP_UNLOCKED = 5;

	/**
	 * 
	 */
	public StoryEvent(int event) {
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
		case BOSS_2_DEFEATED:
			description = "Boss two defeanted";
			break;
		case BOSS_3_DEFEATED:
			description = "Boss three defeanted";
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
