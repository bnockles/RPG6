package directors;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public abstract class Screen{

<<<<<<< HEAD
<<<<<<< HEAD
	protected BufferedImage screenImage;
	protected Game game;
=======
	protected BufferedImage screenImage;
	protected Game game;
>>>>>>> refs/remotes/origin/battles

=======

	protected BufferedImage screenImage;
	protected Game game;
>>>>>>> refs/remotes/origin/cutscenes
	public int width;
	public int height;
	
	//Every Screen must access the Game instance so one screen
	//can cause the game to switch to a new screen
	public Screen(Game game) {
		this.game = game;
		this.width = game.WIDTH;
		this.height = game.HEIGHT;
		screenImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		//TODO paint on the screen Image
		Graphics2D g2 = (Graphics2D)screenImage.getGraphics();
		try{
			paintScreen(g2);
		}catch(Exception e){
			//Screen might not paint in sub classes with constructors that initialize 
		}
	}

	//this method cannot be overriden
	public final BufferedImage getScreenImage(){
		return screenImage;
	}
	
	//abstract makes this a required method for classes that extend this one
	public abstract void paintScreen(Graphics2D g2);
	
	
	public abstract KeyListener getKeyListener();
<<<<<<< HEAD
<<<<<<< HEAD

=======

>>>>>>> refs/remotes/origin/battles
	public void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		paintScreen(g2);
	}

<<<<<<< HEAD
=======
>>>>>>> refs/remotes/origin/cutscenes

<<<<<<< HEAD
	
	
	
	
	
	
=======

>>>>>>> refs/remotes/origin/battles
=======
	public void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		paintScreen(g2);
	}

>>>>>>> refs/remotes/origin/cutscenes
}
