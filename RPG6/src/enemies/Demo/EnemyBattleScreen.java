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
	public static String battleMessage = "Press 1,2, or 3 to make an enemy take its turn";
	static ArrayList<Target> targets;
	//ArrayList<String> battleMessages = new ArrayList<String>(5);
	//public int battleMessageNumber = 5;			//later use this to make sure we can mod and show 5 messages at once
	//int numEnemies = (int) (Math.ceil(Math.random()*3));	//generate num enemies 1-3

	SampleEnemy enemy1;
	SampleEnemy enemy2;
	SampleEnemy enemy3;
	//int randomEnemy1 = (int) Math.ceil(Math.random()*5);
	//int randomEnemy2 = (int) Math.ceil(Math.random()*5);
	//int randomEnemy3 = (int) Math.ceil(Math.random()*5);

	/**
	 * @param game
	 */
	public EnemyBattleScreen(Game game) {
		super(game);
		this.targets=new ArrayList<Target>();
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		targets.add(new SampleTarget());
		//this.enemy1= new SampleEnemy(1, targets);
		//this.enemy2= new SampleEnemy(2, targets);
		//this.enemy3= new SampleEnemy(3, targets);

		//(String type, int level, ArrayList<Target> targets)
		this.enemy1 = new SampleEnemy("regular", 10, targets);		//Implement this later
		//System.out.println(enemy1.attack);
		this.enemy2 = new SampleEnemy("tank", 10, targets);
		this.enemy3 = new SampleEnemy("mage", 10, targets);

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
			int X_COORDINATE_FOR_TEXT = 50;
			int Y_COORDINATE_FOR_TEXT = 75;
			g2.drawString("ENEMIES", X_COORDINATE_FOR_TEXT, Y_COORDINATE_FOR_TEXT);
			g2.drawString(enemy1.name, X_COORDINATE_FOR_TEXT, Y_COORDINATE_FOR_TEXT+25);
			g2.drawString(enemy2.name, X_COORDINATE_FOR_TEXT, Y_COORDINATE_FOR_TEXT+50);
			g2.drawString(enemy3.name, X_COORDINATE_FOR_TEXT, Y_COORDINATE_FOR_TEXT+75);
			g2.drawString("Press '1' to make enemy 1 take its turn", X_COORDINATE_FOR_TEXT+70, Y_COORDINATE_FOR_TEXT+25);
			g2.drawString("Press '2' to make enemy 2 take its turn", X_COORDINATE_FOR_TEXT+70, Y_COORDINATE_FOR_TEXT+50);
			g2.drawString("Press '3' to make enemy 3 take its turn", X_COORDINATE_FOR_TEXT+70, Y_COORDINATE_FOR_TEXT+75);


			g2.drawString("TARGETS", X_COORDINATE_FOR_TEXT, Y_COORDINATE_FOR_TEXT+100);
			int y = 195;
			for(Target t:targets){
				g2.drawString(t.getName(), 75, y);
				y+=25;
			}
			//y+=25;		This moves the battle message down a bit, I think it looks better without so comment out.
			g2.drawString(battleMessage, X_COORDINATE_FOR_TEXT, y);

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
			enemy1.newTakeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			System.out.println("2 was pressed");
			enemy2.newTakeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			System.out.println("3 was pressed");
			enemy3.newTakeTurn();
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
