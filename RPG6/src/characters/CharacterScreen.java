package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import directors.Game;
import directors.Screen;


public class CharacterScreen extends Screen implements KeyListener{

	String[] statNames = {"Health", "Attack", "Defense", "Mana", "Speed", "Drop Rate", "Crit Hit Chance", "CurrentExp"};
	int counter = 0;
	String name;
	double[] stats;
	Hero hero;
	boolean on = false;
	
	public CharacterScreen(Game game) {
		super(game);
		hero = new Hero("The Hero", 100.0, 10.0, 10.0, 100.0, 5.0, 0, 5.0, 0);
		name = hero.getName();
		stats = hero.getAllStats();
		// TODO Auto-generated constructor stub
	}

	public void keyPressed(KeyEvent e) {
		if(on){
			if(e.getKeyCode()==KeyEvent.VK_Q){	
				System.out.println("Q1 was pressed");
				on = false;
				update();
				game.repaint();
			}
		}else{
			if(e.getKeyCode()==KeyEvent.VK_Q){	
				System.out.println("Q2 was pressed");
				on = true;
				update();
				game.repaint();
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public void paintScreen(Graphics2D g2){
		g2.setColor(Color.black);
		g2.drawString("This is the hero", 30, 75);
//			g2.setColor(Color.white);
//			g2.fillRect(0, 0, width, height);
//			g2.setColor(Color.black);
//			try{
//				g2.drawString("Inventory", 50, 50);;
//				g2.drawString(SampleArmor.b, 120, 75);
//				g2.drawString(SamplePotion.c, 120, 100);
//				g2.drawString(SampleAccesory.a, 120, 125);
//				g2.drawString(SampleWeapon.d, 120, 150);
//			}catch(Exception e){
//				//idk
//			}
		if(on){
			int x = 50;
			int y = 100;
			g2.setColor(Color.black);	
			g2.drawString(name, x, y);
			
			for(int i = 0; i < stats.length; i++){
				y += 15;
				g2.drawString(statNames[i] + ": "+ stats[i], x, y);
			}
		}
	}
	
}
