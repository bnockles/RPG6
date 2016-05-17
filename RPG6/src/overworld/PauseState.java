package overworld;
//jay

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class PauseState extends State {

	private Game game;
	private int width, height;
	
	public PauseState(Game game, int width, int height){
		super(game);
		this.width=width;
		this.height=height;
	}
	
	
	public void drawScreen(Graphics g) {
		State.getGameState().render(g);
		g.setColor(new Color(.3f, .3f, .3f, .3f));
		g.drawRect (0, 0, width, height);    
		g.fillRect (0, 0, width, height);
		g.drawRect (0, 0, width, height);    
	    g.fillRect (0, 0, width, height);
	    g.setColor(Color.black);
	    g.setFont(new Font("Aharoni", Font.BOLD, 100));
	    g.drawString("PAUSED", 220, 300);
	    g.setFont(new Font("Aharoni", Font.BOLD, 30));
	    g.drawString("Press 'R' to resume", 280, 340);
	   
	  }
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		drawScreen(g);
	}
}

