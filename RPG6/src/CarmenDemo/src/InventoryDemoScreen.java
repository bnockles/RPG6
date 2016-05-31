import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import items.Stats;
import directors.Screen;
import items.potionStock;
import items.Consumable;
import directors.Game;

public class InventoryDemoScreen extends Screen implements KeyListener{
	
	DemoCharacter player;
	DemoCharacter enemy;
	
	ArrayList<String>playerBag = new ArrayList<String>();
	ArrayList<Integer>playerStats = new ArrayList<Integer>();
	
	public static String action;
	public static String messageOut;
	public static boolean select;
	public static int selectX;
	public static int selectY;
	
	public static final int item1 = KeyEvent.VK_Q;
	public static final int item2 = KeyEvent.VK_W;
	public static final int item3 = KeyEvent.VK_E;
	public static final int item4 = KeyEvent.VK_R;
	public static final int attack = KeyEvent.VK_P;
	public static final int useItems = KeyEvent.VK_I;
	
	int startIndex = 0;
	
	ItemsComponent inventory;
	ArrayList<Consumable> displayitems;
	boolean itemscreen;	
	Consumable itemOne;
	Consumable itemTwo;
	Consumable itemThree;
	Consumable itemFour;
	Consumable itemFive;
	Consumable itemSix;
	Consumable itemSeven;
	Consumable itemEight;
	Consumable itemNine;
	Consumable itemTen;
	Consumable itemEleven;
	Consumable itemTwelve;
	Consumable itemThirteen;
	Consumable itemFourteen;
	
	int playerHP;
	int playerMP;
	int enemyHP;
	int enemyMP;
	
	ArrayList<Consumable>items = new ArrayList<Consumable>();
	
	public InventoryDemoScreen(Game game) {
		super(game);
		battleScreen();
		//displayItemsFirst();
		inventory=new ItemsComponent();
		itemscreen=false;
		
		itemOne=potionStock.consumableStock(potionStock.HP_100);
		itemTwo=potionStock.consumableStock(potionStock.HP_500);
		itemThree=potionStock.consumableStock(potionStock.HP_1000);
		itemFour=potionStock.consumableStock(potionStock.MP_100);
		itemFive=potionStock.consumableStock(potionStock.MP_500);
		itemSix=potionStock.consumableStock(potionStock.MP_1000);
		itemSeven=potionStock.consumableStock(potionStock.PT_RES);
		itemEight=potionStock.consumableStock(potionStock.ATK_I);
		itemNine=potionStock.consumableStock(potionStock.ATK_II);
		itemTen=potionStock.consumableStock(potionStock.DEF_I);
		itemEleven=potionStock.consumableStock(potionStock.DEF_II);
		itemTwelve=potionStock.consumableStock(potionStock.SPD_I);
		itemThirteen=potionStock.consumableStock(potionStock.SPD_II);
		itemFourteen=potionStock.consumableStock(potionStock.ARROWS);
		items.add(itemOne);
		items.add(itemTwo);
		items.add(itemThree);
		items.add(itemFour);
		items.add(itemFive);
		items.add(itemSix);
		items.add(itemSeven);
		items.add(itemEight);
		items.add(itemNine);
		items.add(itemTen);
		items.add(itemEleven);
		items.add(itemTwelve);
		items.add(itemThirteen);
		items.add(itemFourteen);
	}
	
	public void battleScreen(){
		select = false;
		selectX=0;
		selectY=0;		
		this.player= new DemoCharacter("/images/Luffy.png",50,180,new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));  
		this.enemy= new DemoCharacter("/images/Slime.png",650,180,new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		playerHP=player.getHealth();
		playerMP=player.getMana();
		enemyHP=enemy.getHealth();
		enemyMP=enemy.getMana();
	}
	
	public void displayItemsFirst(){
		displayitems = switchTabs(items,startIndex);
	}
	
	public static int loopIndex(ArrayList<Consumable> stuff, int index){
		return (((index*4)%stuff.size())/4);
	}
	
	public static ArrayList<Consumable> switchTabs(ArrayList<Consumable> stuff, int index){
		ArrayList<Consumable>display = new ArrayList<Consumable>();
		index*=4;
		int count = 0;
		while(count<4){
			count++;
			if(index+count<stuff.size())
			display.add(stuff.get(index+count));
		}
		return display;
	}

	public KeyListener getKeyListener() {
		return this;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(!itemscreen){
			if(keyCode == useItems){
				itemscreen=true;
			}
		}
		if(keyCode == attack){
			playerHP-=200;
			playerMP-=100;
			enemyHP-=300;
			enemyMP-=200;
		}
		if(keyCode == item1){
			if(startIndex==0)
				playerHP+=100;
			if(startIndex==2)
				playerHP+=1000;
			if(startIndex==4)
				playerMP+=500;
			if(startIndex==6)
				playerHP=10000;
			if(startIndex==8)
				enemyHP-=150;
			if(startIndex==10)
				playerHP+=500;
			if(startIndex==12)
				enemyHP-=250;
		}		
		if(keyCode == item2){
			if(startIndex==0)
				playerHP+=500;
			if(startIndex==2)
				playerMP+=100;
			if(startIndex==4)
				playerMP+=1000;
			if(startIndex==6)
				enemyHP=-50;
			if(startIndex==8)
				playerHP+=1000;
			if(startIndex==10)
				enemyHP-=500;
			if(startIndex==12)
				enemyHP-=2500;
		}
		if(keyCode == item3){
			if(startIndex==0)
				playerHP+=1000;
			if(startIndex==2)
				playerMP+=500;
			if(startIndex==4)
				playerHP=10000;
			if(startIndex==6)
				enemyHP-=150;
			if(startIndex==8)
				playerHP+=500;
			if(startIndex==10)
				enemyHP-=250;
		}
		if(keyCode == item4){
			if(startIndex==0)
				playerMP+=100;
			if(startIndex==2)
				playerMP+=1000;
			if(startIndex==4)
				enemyHP=-50;
			if(startIndex==6)
				playerHP+=1000;
			if(startIndex==8)
				enemyHP-=500;
			if(startIndex==10)
				enemyHP-=2500;
		}
		if(keyCode == KeyEvent.VK_O){
			if(startIndex>0){
				startIndex-=2;
			}
		}
		
		if(keyCode == KeyEvent.VK_L){
			if(startIndex<items.size() - 4){
				startIndex +=2;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {

	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	public void keyAction(KeyEvent e) {
		
	}
	
	public void paintScreen(Graphics2D g2) {
		Font myFont = new Font ("Courier New",1,18);
		g2.setColor(Color.black);
		g2.drawLine(0,height-300,width,height-300);
		g2.setFont(myFont);
		g2.setColor(Color.red);
		g2.drawString("PRESS I TO VIEW CONSUMABLE ITEMS",width-670,height-270);
		g2.setColor(Color.black);
		g2.drawLine(0,height-240,width,height-240);
		g2.drawLine(0,height-120,width,height-120);
		g2.drawLine(width/2,height-240,width/2,height);
		g2.drawImage(inventory.getImage(), inventory.getX(), inventory.getY(), null);	
		g2.drawImage(player.getImage(),player.getX(),player.getY(),null);
		g2.drawImage(enemy.getImage(),enemy.getX(),enemy.getY(),null);
		if(itemscreen){
			g2.setColor(Color.red);
			g2.drawString(items.get(startIndex).toString(),200,620);
			g2.drawString(items.get(startIndex+1).toString(),700,620);
			g2.drawString(items.get(startIndex+2).toString(),200,740);
			g2.drawString(items.get(startIndex+3).toString(),700,740);
		}
		g2.setColor(Color.black);
		g2.drawString("Player Health: " + playerHP + "",80,80);
		g2.drawString("Player Mana: " + playerMP + "",80,100);
		g2.drawString("Enemy Health: " + enemyHP + "",width-300,80);
		g2.drawString("Enemy Mana: " + enemyMP + "",width-300,100);
		if(player.getHealth()>=0&&player.getMana()>=0){
			g2.drawString("Player Health: " + playerHP + "",80,80);
			g2.drawString("Player Mana: " + playerMP + "",80,100);
			g2.drawString("Enemy Health: " + enemyHP + "",width-300,80);
			g2.drawString("Enemy Mana: " + enemyMP + "",width-300,100);
		}
	}
}