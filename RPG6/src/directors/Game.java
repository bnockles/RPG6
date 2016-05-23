package directors;

import saving.Save;
import saving.SaveScreen;
import saving.SaveUtility;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Game extends JFrame{

	//final means that the value can never change
	public final int WIDTH = 1000;
	public final int HEIGHT = 800;
	protected Screen activeScreen;//whatever Screen we are currently on
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
	private static Save currentSave = null;
>>>>>>> refs/remotes/origin/saving
	
=======

>>>>>>> refs/remotes/origin/battles
=======

>>>>>>> refs/remotes/origin/cutscenes
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
<<<<<<< HEAD
<<<<<<< HEAD
	}
	

	public void reset() {

		Screen startScreen = new StartScreen(this);
		setScreen(startScreen);

			repaint();	
		
=======
>>>>>>> refs/remotes/origin/battles
=======
>>>>>>> refs/remotes/origin/cutscenes
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
<<<<<<< HEAD
<<<<<<< HEAD
	
=======

>>>>>>> refs/remotes/origin/battles
=======

>>>>>>> refs/remotes/origin/cutscenes
	protected void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		setSize(WIDTH,HEIGHT);
		setLocation((monitorWidth-WIDTH)/2,(monitorHeight-HEIGHT)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		saveBeforeClose();
	}

<<<<<<< HEAD
=======
	private void saveBeforeClose(){
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				currentSave.updateSave();
			}
		}));
	}

>>>>>>> refs/remotes/origin/saving

	public void paint(Graphics g){
		g.drawImage(activeScreen.getScreenImage(),0,0,null);
	}

<<<<<<< HEAD
=======
	public static void setCurrentSave(Save save){
        currentSave = save;
    }

    public static Save getCurrentSave(){
        return currentSave;
    }
	
	
	
	
	
	
>>>>>>> refs/remotes/origin/saving
}
