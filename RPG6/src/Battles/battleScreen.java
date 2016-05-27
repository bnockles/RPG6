package Battles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import javax.imageio.ImageIO;

import directors.Game;
import directors.Screen;

public class battleScreen extends Screen implements KeyListener {
	
	ArrayList<String>playerMoves = new ArrayList<String>();

	
	ArrayList<String>playerMovesSpells = new ArrayList<String>();
	
	ArrayList<String>playerBag = new ArrayList<String>();
	
	
	ArrayList<Integer>playerStats = new ArrayList<Integer>();
	
	static ArrayList<String>maps = new ArrayList<String>();
	static ArrayList<String>buttonNames = new ArrayList<String>();
	
	public static int mapSelect;
	
	public static String action;
	public static String messageOut;
	public static boolean select;
	public static int selectX;
	public static int selectY;
	DemoCharacter player;  
	DemoCharacter enemy;
	static int displayHPEnemy;
	static int displayHPPlayer;

	public final int BUTTONWIDTH = 283;
	public final int BUTTONHEIGHT = 75;
	public final int STARTX = 50;
	public final int STARTY = 600;
	public final int BUTTONXDISTANCE = 308;
	public final int BUTTONYDISTANCE = 90;
	public final int PLAYERPLACEMENTX = 100;
	public final int ENEMYPLACEMENTX = 500;
	public final int PLAYERPLACEMENTY =350;

	public static int enemyCurrentHP;
	public static int playerCurrentHP;
	private BufferedImage img;

	MapLoader battleMaps;

	private String keyStored;
	
	public battleScreen(Game game) {
		super(game);
		//arList.addAll(Arrays.asList(1, 2, 3, 4, 5));
		buttonHome();
		mapSelect = 0;
		action = "home";
		maps.addAll(Arrays.asList("/images/sewerFloor.png","/images/modernsewer.png","/images/DemonCastleFloor.png","/images/DemonCastleBackground.png","/images/LavaCaveFloor.png","/images/LavaCave.png"));
		playerMoves.addAll(Arrays.asList("Slash","Punch","Kick","CombatCombo","Back","More"));
		playerMovesSpells.addAll(Arrays.asList("FireBall","IceBlast","AtomicBlast","WindSlash","Back","More"));
		playerBag.addAll(Arrays.asList("HP Potion","MP Potion","Pokeball","OP Item Here","Back","More"));
		playerStats.add(100);
		playerStats.add(10);
		select = false;
		selectX=0;
		selectY=0;
		this.player = new DemoCharacter("/images/ArchAngel.png",PLAYERPLACEMENTX,PLAYERPLACEMENTY,playerStats,playerMoves,playerMovesSpells,"Charles");//stats,MeleeMoves,Spells,Name
		this.enemy = new DemoCharacter("/images/Lich.png",ENEMYPLACEMENTX,PLAYERPLACEMENTY,playerStats,playerMoves,playerMovesSpells,"Evil Dude");
		displayHPEnemy=100;
		displayHPPlayer=100;
		enemyCurrentHP=100;
		playerCurrentHP=100;
		update();
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		Font stringFont = new Font("SansSerif",Font.PLAIN,18);
		g2.setFont(stringFont);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawImage(background(maps.get(mapSelect),1000,800), 0, 40, null);
			g2.drawImage(background(maps.get(mapSelect+1),1000,800),0,0,null);
			g2.drawImage(player.getImage(),player.getX(),player.getY(),null);
			g2.drawImage(enemy.getImage(),enemy.getX(),enemy.getY(),null);
			drawButtons(select,selectX,selectY,stringFont,g2,buttonNames);
//			g2.drawString("NAME: " + player.getTitle(), 170, 620);
			g2.drawImage(background("/images/HPBar.png",175,20), 600, 320, null);
			g2.drawImage(background("/images/HPBar.png",175,20),200,320,null);
			g2.setColor(Color.green);
			g2.fillRect(600, 320, 175*displayHPEnemy/100, 20);
			g2.fillRect(200, 320, 175*displayHPPlayer/100, 20);
			
		}
		
		catch(Exception e){
			//there will only ever be one error when the Screen first prints (since enemies have not been initialized)
		}
		System.out.println("hi");

	}
	public void drawButtons(boolean selector, int x, int y, Font fontString, Graphics2D g, ArrayList<String>nameOfButtons) {
			AffineTransform affinetransform = new AffineTransform();
			FontRenderContext frc = new FontRenderContext(affinetransform ,true,true); 
			int counter = 0;

			if(selector){
				g.drawImage(background("/images/boxSelect.png",300,158),40+(308*x),560+(90*y),null);
			}

			for(int i = 0;i<3;i++){
				for(int j=0;j<2;j++){
					g.drawImage(background("/images/bluebutton.png", BUTTONWIDTH, BUTTONHEIGHT),STARTX + i*BUTTONXDISTANCE,STARTY+j*BUTTONYDISTANCE,null);
					int textwidth = (int)(fontString.getStringBounds(nameOfButtons.get(counter), frc).getWidth());
					int textheight = (int)(fontString.getStringBounds(nameOfButtons.get(counter), frc).getHeight());
					g.drawString(nameOfButtons.get(counter), ((STARTX + i*BUTTONXDISTANCE)+(283-textwidth)/2),((STARTY+j*BUTTONYDISTANCE)+(75-textheight)/2));
					counter++;
				}
			}
	}
	/*
	 *public void drawButtons(boolean selector, int x, int y, Font fontString, Graphics2D g, ArrayList<String>nameOfButtons) {
			AffineTransform affinetransform = new AffineTransform();
			FontRenderContext frc = new FontRenderContext(affinetransform ,true,true); 
			int counter = 0;

			if(selector){
				g.drawImage(background("/images/boxSelect.png",300,158),40+(308*x),560+(90*y),null);
			}

			for(int i = 0;i<3;i++){
				for(int j=0;j<2;j++){
					g.drawImage(background("/images/bluebutton.png", BUTTONWIDTH, BUTTONHEIGHT),STARTX + i*BUTTONXDISTANCE,STARTY+j*BUTTONYDISTANCE,null);
					int textwidth = (int)(fontString.getStringBounds(nameOfButtons.get(counter), frc).getWidth());
					int textheight = (int)(fontString.getStringBounds(nameOfButtons.get(counter), frc).getHeight());
					g.drawString(nameOfButtons.get(counter), ((STARTX + i*BUTTONXDISTANCE)+(283-textwidth)/2),((STARTY+j*BUTTONYDISTANCE)+(75-textheight)/2));
					counter++;
				}
			}
	}
	 * */
	 

	public BufferedImage background(String imagePath,int x1,int y1){
		BufferedImage bImg = new BufferedImage(x1, y1, BufferedImage.TYPE_INT_ARGB);
//		System.out.println("The image being printed is: "+imagePath);
		URL url = getClass().getResource(imagePath);
		try {
			BufferedImage original = ImageIO.read(url);
			
			Graphics2D g = (Graphics2D) bImg.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original,0,0,x1,y1,0,0,w,h,null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return bImg;
		
	}
//"Attack[Press Q]","Magic[Press A]","Bag[Press W]","Items[Press S]","Heros[Press E]","Run[Press D]"
	public static void buttonHome(){
		buttonNames.clear();
		buttonNames.add("Attack[Press Q]");
		buttonNames.add("Magic[Press A]");
		buttonNames.add("Bag[Press W]");
		buttonNames.add("Hero[Press S]");
		buttonNames.add("Items[Press E]");
		buttonNames.add("Run[Press D]");
	}
	public static void buttonMaker(ArrayList<String> keyPressAction){
			buttonNames.clear();
			buttonNames.addAll(keyPressAction);
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Q){
			if(!select||!keyStored.equals("q")){	
				select =true;
				selectX = 0;
				selectY = 0;
				keyStored = "q";
				
			}
			else{
				if(action.equals("home")){
					buttonMaker(playerMoves);
					action = "attack";
					System.out.println(action);
				}
				else if(action.equals("attack")||action.equals("magic")){
					attackedEnemy();
				}
				select = false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			if(!select||!keyStored.equals("a")){	
				select =true;
				selectX = 0;
				selectY = 1;
				keyStored = "a";
				
			}
			else{
				if(action.equals("home")){
					buttonMaker(playerMovesSpells);
					action = "magic";
					System.out.println(action);
				}
				else if(action.equals("attack")||action.equals("magic")){
					attackedEnemy();
				}
				select = false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_W){
			if(!select||!keyStored.equals("w")){	
				select =true;
				selectX = 1;
				selectY = 0;
				keyStored = "w";
			}
			else{
				if(action.equals("home")){
					buttonMaker(playerMovesSpells);
					action = "magic";
					System.out.println(action);
				}
				else if(action.equals("attack")||action.equals("magic")){
					attackedEnemy();
				}
				select = false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_S){
			if(!select||!keyStored.equals("s")){	
				select =true;
				selectX = 1;
				selectY = 1;
				keyStored = "s";
				
			}
			else{
				if(action.equals("home")){
					buttonMaker(playerMovesSpells);
					action = "magic";
					System.out.println(action);
				}
				else if(action.equals("attack")||action.equals("magic")){
					attackedEnemy();
				}
				select = false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_E){
			if(!select||!keyStored.equals("e")){	
				select =true;
				selectX = 2;
				selectY = 0;
				keyStored = "e";
			}
			else{
				if(action.equals("home")){
					buttonMaker(playerBag);
					action = "bag";
					System.out.println(action);
				}else{
					buttonHome();
					action="home";
				}
				select = false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_D){
			if(!select||!keyStored.equals("d")){	
				select =true;
				selectX = 2;
				selectY = 1;
				keyStored = "d";
				
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_1){
			mapSelect=2;
			this.enemy = new DemoCharacter("/images/GreatDevil.png",500,350,playerStats,playerMoves,playerMovesSpells,"You");
			this.player = new DemoCharacter("/images/Goliath.png",100,350,playerStats,playerMoves,playerMovesSpells,"Evil Dude");
			resetGameValues();
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			mapSelect=4;
			this.enemy = new DemoCharacter("/images/BlackDragon.png",500,350,playerStats,playerMoves,playerMovesSpells,"something");
			this.player = new DemoCharacter("/images/Infantry.png",100,350,playerStats,playerMoves,playerMovesSpells,"Evil Dude");
			resetGameValues();
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			mapSelect=0;
			this.player = new DemoCharacter("/images/ArchAngel.png",100,350,playerStats,playerMoves,playerMovesSpells,"Charles");//stats,MeleeMoves,Spells,Name
			this.enemy = new DemoCharacter("/images/Lich.png",500,350,playerStats,playerMoves,playerMovesSpells,"Evil Dude");
			resetGameValues();
		}
		update();
		game.repaint();
		
	}

	private void resetGameValues() {
		displayHPEnemy=100;
		displayHPPlayer=100;
		
	}

	private void attackedEnemy() {
		enemy.stats.set(0,(int) (enemy.stats.get(0)-(1.5*player.stats.get(1)*Math.random())));
		displayHPEnemy = enemy.stats.get(0);
		System.out.println("EnemyHP:"+displayHPEnemy);
		player.stats.set(0,(int) (player.stats.get(0)-enemy.stats.get(1)*Math.random()));
		displayHPPlayer = player.stats.get(0);
		System.out.println("PlayerHP:"+displayHPPlayer);
		update();
		game.repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
