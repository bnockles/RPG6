/**
 * 
 */
package storyline;

import directors.Game;

/**
 * @author bnockles
 *
 */
public class VarietyDemo extends Game {

	
	public static void main(String[] args){
		new VarietyDemo();
	}
	/**
	 * 
	 */
	public VarietyDemo() {
		super();
	}

	public void reset(){
		StorylineScreen screen = new StorylineScreen(this);
		setScreen(screen);
	}
	
}
