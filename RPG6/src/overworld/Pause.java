package overworld;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


public class Pause {

	private Game game;
	private int width, height;
	boolean isPaused;
	private Thread newThread;
	private Graphics g;
	
	public Pause(Game game, int width, int height){
		this.game=game;
		this.width=width;
		this.height=height;
	}
	public void pause(Thread thread){
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawScreen(g);
	}
	public void resume(Game game){
		System.out.println("hello");
		newThread= new Thread(game);
		game.start();
	}
	public void drawScreen(Graphics g) {
	    g.drawRect (0, 0, width, height);    
	    g.fillRect (0, 0, width, height);
	    g.setColor(Color.gray);
	    int font=30;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, font));
	    g.drawString("PAUSED", 400, 300);
	  }
}

