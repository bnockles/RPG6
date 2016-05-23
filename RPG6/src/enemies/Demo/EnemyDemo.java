/**
 * 
 */
package enemies.Demo;

import directors.Game;
import directors.Screen;
import enemies.Demo.EnemyBattleScreen;


/**
 * 
 * @author Mr. Nockles
 * 
 * I have written this class to demonstrate to the class how to get started 
 * with their demo. I have intentionally made this demo BARE BONES
 * so that you are left with a lot of work to do!
 *
 */
public class EnemyDemo extends Game{


	public static void main(String[] args) {
		new EnemyDemo();

		//		SampleEnemy enemy1 = new SampleEnemy("regular",5);		//Implement this later
		//		SampleEnemy enemy2 = new SampleEnemy("tank",5);
		//		SampleEnemy enemy3 = new SampleEnemy("mage",5);
		//		SampleEnemy enemy4 = new SampleEnemy("speedy",5);
		//		SampleEnemy enemy5 = new SampleEnemy("fluffy",5);
		//		
		//		System.out.println(enemy1.toString());
		//		System.out.println(enemy2.toString());
		//	   	System.out.println(enemy3.toString());
		//	   	System.out.println(enemy4.toString());
		//	   	System.out.println(enemy5.toString());

	}
<<<<<<< HEAD
	
//	public EnemyDemo() {
//		applySettings();//display the JFrame the way I want it
//		reset();//starts the game from the beginning
//		setVisible(true);
//	}
	
=======

	public EnemyDemo() {
		applySettings();//display the JFrame the way I want it
		reset();//starts the game from the beginning
		setVisible(true);
	}

>>>>>>> refs/remotes/origin/enemies
	public void reset() {
		Screen demoScreen = new EnemyBattleScreen(this);
		setScreen(demoScreen);
		repaint();
	}

}
