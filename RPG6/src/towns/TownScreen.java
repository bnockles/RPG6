package towns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import directors.Game;
import directors.Screen;

/**
 * @author Teacher
 *
 */
public class TownScreen extends Screen implements KeyListener{

	SampleCharacter character;
	Merchant merchant1;
	Minigame rpsMan;
	Storage storageDude;
	int timesWon = 0;	
	
	
	private BufferedImage img;
	
	ArrayList<String> inventory = new ArrayList<String>();
	
	
	public static String message = "Press 1, 2, or 3 to talk to different NPCs, or press Q, W, E for information about them!";
	/**
	 * @param game
	 */
	public TownScreen(Game game) {
		super(game);
		inventory.add("Health Potion");
		inventory.add("Mana Potion");
		inventory.add("Broad Sword");
		inventory.add("Long Bow");
		this.character = new SampleCharacter(400, "Smith","/images/character.png",9,590, inventory);
		this.merchant1 = new Merchant("Kathy","Female","Kathy is a merchant, merchants sell specific items based on what town you are in, Kathy sells potions." , true);
		this.rpsMan = new Minigame("Bob","Male","Bob triggers a minigame, there are different minigames in each town that will help you earn money in the game, Bob lets you play rock, paper, scissors in this demo." , true);
		this.storageDude = new Storage("Greg","Male","Greg is your storage guy, he is in every town in case you want to store items and then take them back for later.", true);
		update();
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
			g2.drawString("NAME: " + character.getName(), 170, 620);
			g2.drawString("BLANACE: " + character.getCurrency() + " Gems", 170, 640);
			g2.drawString("Current Inventory: ", 170, 720);

			int x = 170;
			for(int i=0; i<inventory.size();i++){
				g2.drawString(inventory.get(i), x,740);
				x += 100;
			}
			g2.drawString("Available NPCs", 50, 75);
			g2.drawString(merchant1.getName(), 50, 100);
			g2.drawString(rpsMan.getName(), 50, 200);
			g2.drawString(storageDude.getName(), 50, 300);
			g2.drawString("Press '1' to talk to the merchant or 'Q' for information.", 160, 100);
			g2.drawString("Press '2' to talk to the storage NPC or 'W' for information.", 160, 200);
			g2.drawString("Press '3' to talk to play mini games or 'E' for information.", 160, 300);

			g2.drawString(message, 50, 400);
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
			//inventory.add("drugs");
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			System.out.println("2 was pressed");
			//enemy2.takeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			System.out.println("3 was pressed");
			//enemy1.takeTurn();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_Q){
			System.out.println("Q was pressed");
			message = merchant1.getDescription();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_E){
			System.out.println("E was pressed");
			message = storageDude.getDescription();
			update();
			game.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_W){
			System.out.println("W was pressed");
			message = rpsMan.getDescription();
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

