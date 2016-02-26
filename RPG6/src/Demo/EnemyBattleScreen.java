/**
 * 
 */
package Demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import directors.Game;
import directors.Screen;

/**
 * @author Teacher
 *
 */
public class EnemyBattleScreen extends Screen implements KeyListener{

	//this String is ONLY useful for a demo
	public static String battleMessage = "Press 1 or 2 to make an enemy take its turn";
	ArrayList<ItemI> items;
	ArrayList<Target> targets;
	SampleEnemy enemy1;
	SampleEnemy enemy2;
	SampleItem item1;
	SampleItem item2;
	/**
	 * @param game
	 */
	public EnemyBattleScreen(Game game) {
		super(game);
		this.items=new ArrayList<ItemI>();
		items.add(new SampleItemI());
		items.add(new SampleItemI());
		items.add(new SampleItemI());
		this.targets=new ArrayList<Target>();
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		this.enemy1= new SampleEnemy(2, SampleEnemy.FLYING, targets);
		this.enemy2= new SampleEnemy(3, SampleEnemy.ZOMBIE, targets);
		this.item1= new SampleItem("item", items);
		this.item2= new SampleItem("item", items);
		update();
	}

	/* (non-Javadoc)
	 * @see directors.Screen#paintScreen(java.awt.Graphics2D)
	 */
	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("ENEMIES", 50, 75);
			g2.drawString(enemy1.name, 50, 100);
			g2.drawString(enemy2.name, 50, 125);
			g2.drawString("Press '1' to make enemy 1 attack an enemy", 160, 100);
			g2.drawString("Press '2' to make enemy 2 attack an enemy", 160, 125);
			g2.drawString("Press 'A' to make enemy 1 use an item", 425, 100);
			g2.drawString("Press 'S' to make enemy 1 use an item", 425, 125);
			g2.drawString("Press 'D' to make enemy 1 use an item", 425, 150);

			g2.drawString("ITEMS", 50, 155);
			int y = 175;
			for(ItemI t:items){
				g2.drawString(t.getName(), 75, y);
				y+=25;
			}
			g2.drawString("TARGETS", 50, 250);
			int xy = 270;
			for(Target t:targets){
				g2.drawString(t.getName(), 75, xy);
				xy+=25;
			}
			xy+=25;
			g2.drawString(battleMessage, 50, xy);
		}catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
	}

	/* (non-Javadoc)
	 * @see directors.Screen#getKeyListener()
	 */
	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_1){
			System.out.println("1 was pressed");
			enemy1.takeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			System.out.println("2 was pressed");
			enemy2.takeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			item1.selectItem();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			item1.selectItem();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			item1.selectItem();
			update();
			game.repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}