package HowardDemo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HowardScreen extends Screen implements KeyListener {

	ExampleClass list;
	boolean on;
//	static ArrayList<enemy> enemyList = new ArrayList<enemy>();
	
	public HowardScreen(Game game){
		super(game);
		list = new ExampleClass();
		on = false;
		allEnemies();
	}
	
	public void allEnemies(){
    	enemy rat = new enemy("Rat", 1, 30, 0, new Stats(30, 8, 3, 1), 30, 3, 1);
    	enemy cat = new enemy("Cat", 6, 55, 0, new Stats(55, 15, 5, 2), 29, 5, 3);
    	enemy slime = new enemy("Slime", 11, 105, 0, new Stats(105, 32, 10, 3), 27, 7, 5);    
    	enemy wraith = new enemy("Wraith", 16, 177, 0, new Stats(177, 58, 18, 5), 25, 11, 8);
    	enemy zombie = new enemy("Zombie", 21, 270, 0, new Stats(270, 95, 24, 7), 24, 13, 11);
    	enemy berserkStump = new enemy("Berserk Stump", 26, 382, 0, new Stats(382, 143, 36, 10), 20, 18, 15);
    	enemy fireBoar = new enemy("Fire Boar", 31, 513, 0, new Stats(513, 205, 69, 20), 19, 22, 19);
    	enemy golem = new enemy("Golem", 36, 663, 0, new Stats(663, 282, 84, 25), 17, 28, 24);
    	enemy werewolf = new enemy("Werewolf", 41, 830, 0, new Stats(830, 374, 100, 30), 15, 30, 29);
    	enemy centaur = new enemy("Centaur", 46, 1014, 0, new Stats(1014, 482, 127, 38), 13, 35, 35);
    	enemy griffin = new enemy("Griffin", 51, 1215, 0, new Stats(1215, 608, 160, 48), 11, 39, 41);
    	enemy gargoyle = new enemy("Gargoyle", 56, 1432, 0, new Stats(1432, 752, 200, 60), 10, 45, 48);
    	enemy rogue = new enemy("Rogue", 61, 1665, 0, new Stats(1665, 916, 297, 83), 9, 50, 55);
    	enemy mage = new enemy("Mage", 66, 1914, 0, new Stats(1914, 1101, 357, 107), 7, 60, 63);
    	enemy spartan = new enemy("Spartan", 71, 2179, 0, new Stats(2179,1307, 420, 126), 5, 70, 71);
    	enemy spearman = new enemy("Spearman", 76, 2459, 0, new Stats(2459, 1532, 524, 157), 5, 80, 80);
    	enemy wyvern = new enemy("Wyvern", 81, 2754, 0, new Stats(2754, 1790, 637, 191), 5, 80, 80);
    	enemy reaper = new enemy("Reaper", 86, 3065, 0, new Stats(3065, 2069, 720, 216), 5, 90, 99);
    	enemy homunculus = new enemy("Homunculus", 91, 3390, 0, new Stats(3390, 2373, 836, 250), 5, 95, 109);
    	enemy spider = new enemy("Spider", 100, 4011, 0, new Stats(4011, 3008, 1000, 300), 5, 100, 110);
   	 
    	list.addEnemy(rat);
    	list.addEnemy(cat);
    	list.addEnemy(slime);
    	list.addEnemy(wraith);
    	list.addEnemy(zombie);
    	list.addEnemy(berserkStump);
    	list.addEnemy(fireBoar);
    	list.addEnemy(golem);
    	list.addEnemy(werewolf);
    	list.addEnemy(centaur);
    	list.addEnemy(griffin);
    	list.addEnemy(gargoyle);
    	list.addEnemy(rogue);
    	list.addEnemy(mage);
    	list.addEnemy(spartan);
    	list.addEnemy(spearman);
    	list.addEnemy(wyvern);
    	list.addEnemy(reaper);
    	list.addEnemy(homunculus);
    	list.addEnemy(spider);
   
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
//			//theMessage = thing.doTheThing();
//			theMessage = thing.showEnemy(0);
			on = !on;
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public void paintScreen(Graphics2D g2){
		if(on){
			int Yname = 100,Ylevel = 100, YcurrentHp = 100, YcurrentMana = 100;
			int Yhealth = 100, Yattack = 100, Ydefense = 100, Yspeed = 100;
			int Ydrop = 100, Yexp = 100, Ygold = 100;
			int increment = 20;
			for(int i = 0; i < list.getEnemyList().size(); i++){
				g2.drawString(list.getEnemyList().get(i).getName(), 50, Yname += increment);
				g2.drawString("Level: " + list.getEnemyList().get(i).getLevel(), 140, Ylevel += increment);
				g2.drawString("currentHp: " + list.getEnemyList().get(i).getCurrHealth(), 225, YcurrentHp += increment);
				g2.drawString("currentMp: " + list.getEnemyList().get(i).getCurrMana(), 350, YcurrentMana += increment);
				g2.drawString("Hp: " + list.getEnemyList().get(i).getStats().getHealth(), 450, Yhealth += increment);
				g2.drawString("Attack: " + list.getEnemyList().get(i).getStats().getAttack(), 525, Yattack += increment);
				g2.drawString("Defense: " + list.getEnemyList().get(i).getStats().getAttack(), 625, Ydefense += increment);
				g2.drawString("Speed: " + list.getEnemyList().get(i).getStats().getSpeed(), 725, Yspeed += increment);
				g2.drawString("Drop_Rate: " + list.getEnemyList().get(i).getDropRate(), 825, Ydrop += increment);
				g2.drawString("Exp: " + list.getEnemyList().get(i).getExp(), 925, Yexp += increment);
			
			}
		}
	}

	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

}