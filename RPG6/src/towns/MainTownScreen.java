package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import menus.MainMenu;

import directors.Game;
import directors.Screen;

public class MainTownScreen extends Screen implements KeyListener {

	
	public MainTownScreen (Game game) {
		super(game); 
		update();
	}

		@Override
		public void paintScreen(Graphics2D g2) {
			
			g2.setColor(Color.white);
			g2.fillRect(0, 0, width, height);
			g2.setColor(Color.black);
			
			try{
				g2.drawString("Available Towns to Warp to.", 50, 75);
				g2.drawString("Press '1' to warp to Pellet Town, Press '2' to go Big Root Town, Press '3' to go to Old Yelp Town.", 50, 125);
			}
			
			catch(Exception e){
				//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
			}
			
		}
		//testing1
		/* (non-Javadoc)
		 * @see directors.Screen#getKeyListener()
		 */
		@Override
		public KeyListener getKeyListener() {
			return this;
		}

		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode()==KeyEvent.VK_B){
				System.out.println("1 was pressed");
				Screen warpTown1 = new TownScreen(game);
				game.setScreen(warpTown1);
				
				update();
				game.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_N){
				System.out.println("2 was pressed");
				Screen warpTown2 = new TownScreen2(game);
				game.setScreen(warpTown2);
				update();
				game.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_M){
				System.out.println("3 was pressed");
				Screen warpTown3 = new TownScreen3(game);
				game.setScreen(warpTown3);
				update();
				game.repaint();
			}
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
//1
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

}
