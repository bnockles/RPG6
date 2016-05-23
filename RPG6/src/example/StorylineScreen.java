/**
 * 
 */
package example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import directors.Game;
import directors.Screen;

/**
 * @author bnockles
 *
 */
public class StorylineScreen extends Screen implements KeyListener {

	StoryPoint storyPoint;
	int decisionPoint;
	
	/**
	 * @param game
	 */
	public StorylineScreen(Game game) {
		super(game);
		decisionPoint=1;
		storyPoint = new StoryPoint();
	}


	public void keyTyped(KeyEvent e) {
		
	}


	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(k==KeyEvent.VK_SPACE){
			if(storyPoint.nextLn()){
				nextDescision();
			};
		}
		if(k==KeyEvent.VK_1){
			storyPoint.select(0);
			storyPoint.update();
			
		}
		if(k==KeyEvent.VK_2){
			storyPoint.select(1);
			storyPoint.update();
//			storyPoint.nextLn();;
			
		}
		if(k==KeyEvent.VK_Q){
			nextDescisionAuto();
		}

	}


	private void nextDescisionAuto() {
		storyPoint.select(0);
		decisionPoint = storyPoint.getNextPoint();
		storyPoint=new StoryPoint(storyPoint.getEvents(), decisionPoint);
	}


	private void nextDescision() {
//		storyPoint.select(0);
		decisionPoint = storyPoint.getNextPoint();
		storyPoint=new StoryPoint(storyPoint.getEvents(), decisionPoint);
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		try{
			g2.drawImage(storyPoint.getImage(), 0, 0,null);
		}catch(Exception e){
			
		}
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

}