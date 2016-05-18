import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;


public class LootScreen extends Screen implements KeyListener{
	Treasure[]boxes;
	int money;
	boolean haveBox;
	public LootScreen(Game game,int level) {
		super(game);
		update();
		haveBox = false;
		boxes = new Treasure[3];
		for(int i=0;i<boxes.length;i++){
			int y = (int)(Math.random()*3);
			if(y==0){
				Treasure x=new Treasure("Common",(int)(Math.random()*300),"Small box");
				boxes[i]=x;
			}
			else if(y==1){
				Treasure x=new Treasure("Less Common",(int)(Math.random()*3000),"Medium box");
				boxes[i]=x;
			}
			else{
				Treasure x=new Treasure("Rare",(int)(Math.random()*30000),"Large box");
				boxes[i]=x;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawString("Box1",500,300);
		g2.drawString("Box2",530,300);
		g2.drawString("Box3",560,300);
		g2.drawString("Choose a box.",530,200);
		String x = "";
		x = x+money;
		g2.drawString("You got $"+ x + " from the box.", 300, 200);
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(!haveBox){
			if(keyCode == KeyEvent.VK_Z){
				money+=boxes[0].getMoney();
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_X){
				money+=boxes[1].getMoney();
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_C){
				money+=boxes[2].getMoney();
				haveBox=true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
