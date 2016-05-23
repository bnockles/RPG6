package Battles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import directors.Screen;
import directors.Game;

public abstract class InventoryDemoScreen extends Screen implements KeyListener{

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
	DemoCharacter player= new DemoCharacter("/images/ArchAngel.png",100,350,playerStats,playerMoves,playerMovesSpells,"Charles");;  
	DemoCharacter enemy;
	static int displayHPEnemy;
	static int displayHPPlayer;
	public static int enemyCurrentHP;
	public static int playerCurrentHP;
	private BufferedImage img;
	private String keyStored;
	
	ItemsComponent inventory;
	ArrayList<Consumable> items = new ArrayList<Consumable>();
	ArrayList<Consumable> displayitems;
	//stats,MeleeMoves,Spells,Name
	//Boolean to turn itemscreen on
	boolean itemscreen = false;
	int index = 0;
	
	public InventoryDemoScreen(Game game) {
		super(game);
		CreateItems();
		battleScreen();
		displayItemsFirst();
		inventory=new ItemsComponent();
	}
	public void battleScreen() {
		mapSelect = 0;
		action = "home";
		maps.add("/images/sewerFloor.png");
		maps.add("/images/modernsewer.png"); 
		maps.add("/images/DemonCastleFloor.png");
		maps.add("/images/DemonCastleBackground.png");
		maps.add("/images/LavaCaveFloor.png");
		maps.add("/images/LavaCave.png");
		playerMoves.add("Slash");
		playerMoves.add("Punch");
		playerMoves.add("Kick");
		playerMoves.add("CombatCombo");
		playerMoves.add("Back");
		playerMoves.add("More");
		playerMovesSpells.add("FireBall");
		playerMovesSpells.add("IceBlast");
		playerMovesSpells.add("AtomicBlast");
		playerMovesSpells.add("WindSlash");
		playerMovesSpells.add("Back");
		playerMovesSpells.add("More");
		playerBag.add("HP Potion");
		playerBag.add("MP Potion");
		playerBag.add("Pokeball");
		playerBag.add("OP Item Here");
		playerBag.add("Back");
		playerBag.add("More");
		playerStats.add(100);
		playerStats.add(10);
		select = false;
		selectX=0;
		selectY=0;
		this.player = new DemoCharacter("/images/ArchAngel.png",100,350,playerStats,playerMoves,playerMovesSpells,"Charles");//stats,MeleeMoves,Spells,Name
		this.enemy = new DemoCharacter("/images/Lich.png",500,350,playerStats,playerMoves,playerMovesSpells,"Evil Dude");
		displayHPEnemy=100;
		displayHPPlayer=100;
		enemyCurrentHP=100;
		playerCurrentHP=100;

	}

	public void CreateItems(){
		items.add(potionStock.consumableStock(potionStock.HP_100));
		items.add(potionStock.consumableStock(potionStock.HP_500));
		items.add(potionStock.consumableStock(potionStock.HP_1000));
		items.add(potionStock.consumableStock(potionStock.MP_100));
		items.add(potionStock.consumableStock(potionStock.MP_500));
		items.add(potionStock.consumableStock(potionStock.MP_1000));
		items.add(potionStock.consumableStock(potionStock.PT_RES));
		items.add(potionStock.consumableStock(potionStock.ATK_I));
		items.add(potionStock.consumableStock(potionStock.ATK_II));
		items.add(potionStock.consumableStock(potionStock.DEF_I));
		items.add(potionStock.consumableStock(potionStock.DEF_II));
		items.add(potionStock.consumableStock(potionStock.SPD_I));
		items.add(potionStock.consumableStock(potionStock.SPD_II));
		items.add(potionStock.consumableStock(potionStock.ARROWS));
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.drawRect (width-150, height-120, 150, 120);
		g2.drawRect (width-300, height-120, 150, 120);
		g2.drawRect (width-150, height-240, 150, 120);
		g2.drawRect (width-300, height-240, 150, 120);
		g2.drawRect (width-650, height-120, 350, 120);
		g2.drawRect (width-650, height-240, 350, 120);
		g2.drawRect (width-1000, height-120, 350, 120);
		g2.drawRect (width-1000, height-240, 350, 120);
		g2.setColor(Color.black);
		g2.drawImage(inventory.getImage(), inventory.getX(), inventory.getY(), null);
		
	}
	
	public void displayItemsFirst(){
		displayitems = switchTabs(items,index);
	}
	public static int loopIndex(ArrayList<Consumable> stuff, int index){
		return (((index*4)%stuff.size())/4);//fix it later experiment
	}
	public static ArrayList<Consumable> switchTabs(ArrayList<Consumable> stuff, int index){
		ArrayList<Consumable> display = new ArrayList<Consumable>();
		index*=4;
		int count = 0;
		while(count<4){
			count++;
			if(index+count<stuff.size())
			display.add(stuff.get(index+count));
		}
		return display;
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_I){
			itemscreen =!itemscreen;
		}
		if(keyCode == KeyEvent.VK_J){
			index++;
			index = loopIndex(items,index);
			displayitems = switchTabs(items,index);
			System.out.println();
			for(Consumable t:displayitems)
				System.out.print(t.getName());
		}
	}

}