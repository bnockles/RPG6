package directors;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game extends JFrame{


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		applySettings();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		
	
	}
}
