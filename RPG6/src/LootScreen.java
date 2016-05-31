import items.Equipment;
import items.equipStock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;


public class LootScreen extends Screen implements KeyListener{
	Treasure[]boxes;
	int money;
	int chosenBox;
	boolean haveBox;
	equipStock y;
	int equipLevel;
	boolean seenDrop;
	public LootScreen(Game game,int level) {
		super(game);
		update();
		y = new equipStock();
		equipLevel = level;
		haveBox = false;
		seenDrop = false;
		boxes = new Treasure[3];
		for(int i=0;i<boxes.length;i++){
			int y = (int)(Math.random()*15)+1;
			if(y>0&&y<10){
				Treasure x = new Treasure(Treasure.COMMON,(int)(Math.random()*300),"This box has a small amount of money.");
				boxes[i]=x;
			}
			else if(y>=10&&y<15){
				Treasure x = new Treasure(Treasure.UNCOMMON,(int)(Math.random()*3000),"This box has a decent amount of money.");
				boxes[i]=x;
			}
			else{
				Treasure x = new Treasure(Treasure.RARE,(int)(Math.random()*30000),"This box has a large amount of money.");
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
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(300, 100, 500, 500);
		g2.setColor(Color.black);
		g2.drawString("End of Battle",500,150);
		if(seenDrop){
			g2.drawString("Choose a box.",400,200);
			g2.drawString("Box1",400,250);
			g2.drawString("Box2",430,250);
			g2.drawString("Box3",460,250);
			String x = "";
			x = x+money;
			if(haveBox){
				if(boxes[chosenBox].getRarity() == "Rare"){
					g2.setColor(Color.BLUE);
				}
				else if(boxes[chosenBox].getRarity() == "Uncommon"){
					g2.setColor(Color.GREEN);
				}
				g2.drawString("You have chosen a " + boxes[chosenBox].getRarity() + " box.",400,280);
				g2.setColor(Color.BLACK);
				g2.drawString(boxes[chosenBox].getDescription(),400,300);
				g2.drawString("You got $"+ x + " from the box.",400,320);
			}
		}
		else{
			Equipment equip = y.equipStocks((equipLevel));
			g2.drawString("You have aquired a "+equip.getName()+" from the battle.",400,250);
			g2.drawString(equip.getDescription(),400,280);
			g2.drawString("Description - "+equip.getReq(),400,310);
			g2.setColor(Color.RED);
			g2.drawString("Press z to continue", 400, 340);
		}
	}
	
	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(!seenDrop){
			if(keyCode == KeyEvent.VK_Z){
				seenDrop = true;
			}
		}
		if(!haveBox){
			if(keyCode == KeyEvent.VK_1){
				money+=boxes[0].getMoney();
				chosenBox = 0;
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_2){
				money+=boxes[1].getMoney();
				chosenBox = 1;
				haveBox=true;
			}
			if(keyCode == KeyEvent.VK_3){
				money+=boxes[2].getMoney();
				chosenBox = 2;
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
