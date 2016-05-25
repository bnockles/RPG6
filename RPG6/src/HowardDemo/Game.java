package HowardDemo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Game extends JFrame{

	//final means that the value can never change
	public final int WIDTH = 1000;
	public final int HEIGHT = 800;
	protected Screen activeScreen;//whatever Screen we are currently on

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		applySettings();//display the JFrame the way I want it
		reset();//starts the game from the beginning
		setVisible(true);
		Timer timer = new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				activeScreen.update();
				Game.this.repaint();
			}
		});
		timer.start();
	}


	protected void reset() {
		Screen startScreen = new StartScreen(this);
		setScreen(startScreen);

		repaint();	

	}


	public void setScreen(Screen newScreen){
		activeScreen=newScreen;
		//Question: how does the following line of code work?
		addKeyListener(activeScreen.getKeyListener());
		repaint();
	}

	protected void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		setSize(WIDTH,HEIGHT);
		setLocation((monitorWidth-WIDTH)/2,(monitorHeight-HEIGHT)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
	}


	public void paint(Graphics g){
		g.drawImage(activeScreen.getScreenImage(),0,0,null);
	}

}
