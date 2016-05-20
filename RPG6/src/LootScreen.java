import items.Equipment;
import items.equipStock;

import java.awt.Color;
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
	equipStock y;
	int equipLevel;
	public LootScreen(Game game,int level) {
		super(game);
		update();
		y = new equipStock();
		equipLevel = level;
		haveBox = false;
		boxes = new Treasure[3];
		for(int i=0;i<boxes.length;i++){
			int y = (int)(Math.random()*15)+1;
			if(y>0&&y<10){
				Treasure x = new Treasure(Treasure.COMMON,(int)(Math.random()*300),"This is a small box");
				boxes[i]=x;
			}
			else if(y>=10&&y<15){
				Treasure x = new Treasure(Treasure.UNCOMMON,(int)(Math.random()*3000),"This is a medium box");
				boxes[i]=x;
			}
			else{
				Treasure x = new Treasure(Treasure.RARE,(int)(Math.random()*30000),"This is a large box");
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
		g2.setColor(Color.CYAN);
		g2.fillRect(300, 100, 500, 500);
		g2.setColor(Color.black);
		g2.drawString("Choose a box.",400,200);
		g2.drawString("Box1",400,250);
		g2.drawString("Box2",430,250);
		g2.drawString("Box3",460,250);
		String x = "";
		x = x+money;
		if(haveBox){
			g2.drawString("You got $"+ x + " from the box.",400,300);
		}
		Equipment equip = y.equipStocks(equipLevel);
		g2.drawString("You have aquired a "+equip.getName()+" from the battle.",400,370);
		g2.drawString(equip.getDescription(),400,400);
		g2.drawString("Description - "+equip.getReq(),400,430);
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
			if(keyCode == KeyEvent.VK_1){
				money+=boxes[0].getMoney();
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_2){
				money+=boxes[1].getMoney();
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_3){
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
