package directors;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game extends JFrame{

	//final means that the value can never change
	public final int WIDTH = 1000;
	public final int HEIGHT = 800;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		applySettings();//display the JFrame the way I want it
		setVisible(true);
		reset();//starts the game from the beginning
	}
	
	private void reset() {
		//TODO determine this method
	}

	private void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		setSize(WIDTH,HEIGHT);
		setLocation((monitorWidth-WIDTH)/2,(monitorHeight-HEIGHT)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
	}
}
