/**
 * 
 */
package enemies.Demo;

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
	ArrayList<Target> targets;
	SampleEnemy enemy1;
	SampleEnemy enemy2;
	/**
	 * @param game
	 */
	public EnemyBattleScreen(Game game) {
		super(game);
		this.targets=new ArrayList<Target>();
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		this.enemy1= new SampleEnemy(1, targets);
		this.enemy2= new SampleEnemy(2, targets);
		this.enemy3= new SampleEnemy(3, targets);
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
		g2.drawString("Press '1' to make enemy 1 take its turn", 120, 100);
		g2.drawString("Press '2' to make enemy 1 take its turn", 120, 125);
		
		g2.drawString("TARGETS", 50, 155);
		int y = 175;
		for(Target t:targets){
			g2.drawString(t.getName(), 75, y);
			y+=25;
		}
	
		y+=25;
		g2.drawString(battleMessage, 50, y);
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
			enemy2.takeBossTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			enemy3.takeTurn();
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
