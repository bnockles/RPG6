package demo;
// import directors;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * @author Tasnia
 *
 */
public class StorylineScreen extends Screen implements KeyListener {
	public static String message = "How would you like to proceed? Press L or R";
	public static String keyCode = "";
//	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		
		int height;
		int width;
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		//rest of code
		try {
			g2.drawString(message, 50, 125);
			g2.drawString("Go left", 50, 100);
			g2.drawString("Go right", 50, 150);
			if (keyCode = KeyPress.VK_L){
				Event.burnObject("building");
			}
			if (keyCode = KeyPress.VK_R){
				Event.floodObject("House");
			}
		}
	}
//	@Override
	public KeyListener getKeyListener() {
		return this;
	}
	
	public void keyPressed(KeyPress e) {
		if(e.getKeyCode()==KeyPress.VK_L){
			System.out.println("You chose to go left.");
			keyCode = e.getKeyCode();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyPress.VK_R){
			System.out.println("You chose to go right");
			keyCode = e.getKeyCode();
			update();
			game.repaint();
		}
	}
	public void keyReleased(KeyPress e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyPress e) {
		// TODO Auto-generated method stub

	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
