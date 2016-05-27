package SonyaDemo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class SonyaScreen extends Screen implements KeyListener {
	String theMessage;
	ExampleClass thing;
	boolean cIsPressed;
	boolean sIsPressed;
	boolean gIsPressed;
	boolean enemiesCreated;
	boolean doneBefore;
	Enemy sampleEnemy;
	
	ArrayList<Enemy>enemies= new ArrayList<Enemy>();
	ArrayList<ActiveSkills>activeSkills = new ArrayList<ActiveSkills>();
	ArrayList<ActiveSkills>activeSkillsFinal = new ArrayList<ActiveSkills>();
	public SonyaScreen(Game game) {
		super(game);
		thing = new ExampleClass();
		theMessage = "sonya was here";
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			System.out.println("space bar was pressed");
			//code that happens when you press the spacebar
			theMessage=thing.doThing();
		}
		if(e.getKeyCode()==KeyEvent.VK_C){
			System.out.println("C key was pressed");
			cIsPressed=true;
			if(!doneBefore){
			enemies =SonyaDemoExecution.createEnemies();
			activeSkills = SonyaDemoExecution.createActiveSkills();
			enemies = SonyaDemoExecution.sortAndOrganize(enemies);
			activeSkills = SonyaDemoExecution.sortAndOrganizeSkills(activeSkills);
			doneBefore=true;
			}
			//code that happens when you press the spacebar
			//theMessage=thing.doThing();
		}
		if(e.getKeyCode()==KeyEvent.VK_G){
			sampleEnemy= enemies.get((int)Math.random()*enemies.size());
			gIsPressed=true;
			System.out.println("G was pressed. Enemy generated.");
			System.out.println("Enemy generated with level "+sampleEnemy.getLevel());
			
			//theMessage=thing.doThing();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			System.out.println("S key was pressed");
			activeSkillsFinal = SonyaDemoExecution.getSkills(sampleEnemy);
			sIsPressed = true;
			//theMessage=thing.doThing();
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		if(!cIsPressed){
			theMessage="You need to press C first.";
			System.out.println("You need to press C first.");
			g2.drawString(theMessage,50,100);
		}
		else{
			if(!enemiesCreated){
				g2.drawString("The enemies created:",50,125);
				System.out.println("The enemies created:");
				int xCoord=50;
				int yCoord=150;
				for(int i=0;i<enemies.size();i++){
					System.out.println("Enemy #" + (i+1)+": " + enemies.get(i).getLevel()+"");
					g2.drawString("Enemy #" + (i+1)+": " + enemies.get(i).getLevel()+"",xCoord,yCoord);
					yCoord+=25;
				}
				//enemiesCreated=true;
			}
			g2.drawString("Press 'S' to get the skills the enemy can use:",150,125);
			System.out.println("Press 'S' to get the skills the enemy can use:");
			if(sIsPressed){
				int yCoord = 150;
				System.out.println("Here are the skills:");
				g2.drawString("Here are the skills:",150,yCoord);
				for(int i=0;i<activeSkillsFinal.size();i++){
					yCoord+=25;
					System.out.println("Active Skill #" + (i+1)+": " + activeSkills.get(i).getDamage()+"");
					g2.drawString("Active Skill #" + (i+1)+": " + activeSkills.get(i).getDamage()+"",150,yCoord);
				}
				
			}
			if(gIsPressed){
				g2.drawString("G was pressed. Enemy generated with level" +sampleEnemy.getLevel() , 200, 100);
			}
		}
		
		
	}

	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

}

