import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import directors.Game;
import directors.Screen;

public class BattleEndScreen extends Screen implements KeyListener{
	Hero hero;
	Enemy enemy;
	Item item;
	int battleGold;
	private ArrayList<Item> inventory;
	
	public BattleEndScreen(Hero hero, Enemy enemy,int battleGold,Game game){
 		super(game);
 		this.hero = hero;
 		this.enemy = enemy;
 		this.battleGold = battleGold;
 	}
	
	//private int inventoryIdx = (int)Math.random() * Inventory.size();
	
	
 	public void paintScreenWin(Graphics g){
			g.drawString("Current Level:" + hero.getLevel(), 30, 65);  
			g.drawString("Experience Earned: "+enemy.getExp(), 30,75);
			g.drawString("Current Exp:"+ hero.getExp(), 30, 85);
			g.drawString("Gold Gained: "+ battleGold,30,95);
			g.drawString("Item Obtained: "+ item, 30, 105);
	}
 	
	public void paintScreenLose(Graphics g2){
 			g2.drawString("Current Level:" +hero.getLevel(), 30, 65);  
 			g2.drawString("Experience Lost: "+enemy.getExp(), 30,75);
 			g2.drawString("Current Exp:"+ hero.getExp(), 30, 85);
 			g2.drawString("Gold Lost: "+ battleGold,30,95);
	}
	
		public void paintScreen(Graphics2D g2) {
			// TODO Auto-generated method stub
			g2.setColor(Color.white);
			g2.fillRect(0, 0, width, height);
			g2.setColor(Color.black);
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public KeyListener getKeyListener() {
			// TODO Auto-generated method stub
			return this;
		}

		
	
}