import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import directors.Game;
import directors.Screen;

public class BattleEndScreen extends Screen{
	public BattleEndScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	private int inventoryIdx = Math.random() * Inventory.size();
	
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	
 	public void win(Hero hero, Enemy enemy, int level ,Item item,double getExpGained, double currentExp,int battleGold){
 		public void paintScreenWin(Graphics g){
 			g.drawString("Current Level:" +level, 30, 65);  
 			g.drawString("Experience Earned: "+enemy.getExpGained(), 30,75);
 			g.drawString("Current Exp:"+ hero.getCurrentExp(), 30, 85);
 			g.drawString("Gold Gained: "+ battleGold,30,95);
 			g.drawString("Item Obtained: "+ item, 30, 105);
 		
 	
 		}
 	}
	public void lose(Hero hero, Enemy enemy, int level ,Item item,double getExpGained, double currentExp,int battleGold){
		public void paintScreenLose(Graphics g2){
 			g2.drawString("Current Level:" +level, 30, 65);  
 			g2.drawString("Experience Lost: "+enemy.getExpGained(), 30,75);
 			g2.drawString("Current Exp:"+ hero.getCurrentExp(), 30, 85);
 			g2.drawString("Gold Lost: "+ battleGold,30,95);
 		
		
	}
		public void paintScreen(Graphics2D g2) {
			// TODO Auto-generated method stub
			g2.setColor(Color.white);
			g2.fillRect(0, 0, width, height);
			g2.setColor(Color.black);
		}
		
		public KeyListener getKeyListener() {
			// TODO Auto-generated method stub
			return null;
		}
	
}