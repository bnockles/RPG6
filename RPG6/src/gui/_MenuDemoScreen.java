package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public final class _MenuDemoScreen extends MenuScreen implements KeyListener {
	private static final int 	MODE_ANIMATION = 1<<0,
								MODE_INVENTORY = 1<<1,
								MODE_BATTLE  = 1<<2;
	
	private static final int 	DEFAULT_MODE = MODE_ANIMATION;
	private int currentMode;
	private Menu menu;

	
	public _MenuDemoScreen(Game game) {
		super(game);

		this.menu = new Menu(this);
		
		currentMode = DEFAULT_MODE;
		setUpAnimation();
	}

	
	private void setUpAnimation(){
		menu.removeAllComponents();

		
		DialogBox db = new DialogBox(menu, "GeT A FRee SWORD TODAY"
				+ "                                            "
				+ "ONLY 200 GOLD DOLLARS", 32, 10, 80);
				db.setTextPosition(20, 36);
				db.setTextColor(Color.WHITE);
				db.setOnUpdate(new Updatable(){
					public void update(long dt, MenuComponent c){
						if(c.getColor().equals(Color.BLUE)){
							c.setColor(Color.BLACK);
						}
						else{
							c.setColor(Color.BLUE);
						}
						
						int s = (int)(.02 * dt);
						c.getCoord().translate(s+2, s);
					}
				});
				
		DialogBox mb = new DialogBox(menu, "I scale!", 10, this.width/2, this.height/2);
				mb.setDimensions(10, 10);
				mb.setFill(true);
				mb.setTextPosition(50, 50);
				mb.setOnUpdate(new Updatable(){
					public void update(long dt, MenuComponent c){
						c.scale(1.1, 1.1);
					}
				});

		_DemoPlayer dp = new _DemoPlayer(menu, this.width/2 - 250, this.height/2);
					dp.setSpeed(7);
	}

	private void setUpInventory(){
		menu.removeAllComponents();
		
		MenuBox mb = new MenuBox(menu, 10, 33);
				mb.setDimensions(this.width/2 - 10, this.height - 44);
				mb.setFill(true);
		
		MenuBox mb2 = new MenuBox(menu, 12, 35);
				mb2.setDimensions(this.width/2 - 15, this.height - 49);
				mb2.setColor(Color.WHITE);
				mb2.setFill(false);

		MenuBox mb3 = new MenuBox(menu, this.width/2 + 2, 33);
				mb3.setDimensions(this.width/2 - 13, this.height - 44);
				mb3.setFill(true);
		
		MenuBox mb4 = new MenuBox(menu, this.width/2 + 4, 35);
				mb4.setDimensions(this.width/2 - 18, this.height - 49);
				mb4.setColor(Color.WHITE);
				mb4.setFill(false);
		
		MenuBox mb5 = new MenuBox(menu, 16, 39);
				mb5.setDimensions(100, 100);
				mb5.setColor(Color.WHITE);
				mb5.setFill(false);
	}

	private void setUpBattle(){
		menu.removeAllComponents();
		
		
		MenuBox mb = new MenuBox(menu, 250, this.height - 180);
				mb.setDimensions(500, 146);
				mb.setColor(Color.BLACK);
				mb.setFill(true);
				
		MenuBox mb2 = new MenuBox(menu, 253, this.height - 177);
				mb2.setDimensions(493, 139);
				mb2.setColor(Color.WHITE);
				mb2.setFill(false);
				
		_BattleCursor bc = new _BattleCursor(menu, 256, this.height - 174);
		
		DialogBox fight = new DialogBox(menu, "FIGHT", 10, 285, this.height - 159);
				fight.setDimensions(40, 30);
				

		DialogBox items = new DialogBox(menu, "ITEMS", 10, 285, this.height - 102);
				items.setDimensions(40, 30);


		DialogBox run = new DialogBox(menu, "RUN", 10, 395, this.height - 159);
				run.setDimensions(40, 30);
		
				
		MenuBox hp = new MenuBox(menu, 600, this.height - 150);
				hp.setDimensions(100, 20);
				hp.setColor(Color.RED);
				hp.setFill(true);

		DialogBox hps = new DialogBox(menu, "100/100", 100, 600, this.height - 150);
				hps.setDimensions(0, 0);
				
		MenuBox mp = new MenuBox(menu, 600, this.height - 100);
				mp.setDimensions(100, 20);
				mp.setColor(Color.BLUE);
				mp.setFill(true);
		
		DialogBox mps = new DialogBox(menu, "999/999", 100, 600, this.height - 100);
				mps.setDimensions(0, 0);
	}
	
	public void drawBackground(Graphics2D g2){
		g2.setColor(Color.CYAN);
		g2.fillRect(0, 0, this.width, this.height);
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		updateMenus();
		
		drawBackground(g2);
		drawMenus(g2);
		
		if(this.menu != null){
			g2.setColor(Color.BLACK);
			g2.drawString("T:    " + this.menu.timeSinceStart(), this.width - 130, 50);
			g2.drawString("MODE: " + this.currentMode, 			 this.width - 130, 67);
			g2.drawString("COMPONENTS: " + this.menu.size(), 	 this.width - 130, 84);
		}
	}
	
	
	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		
		int code = e.getKeyCode();
		
		switch(code){
		case KeyEvent.VK_1:
			System.out.println("SWITCHING TO ANIMATIONS");
			currentMode = MODE_ANIMATION;
			setUpAnimation();
			break;
			
		case KeyEvent.VK_2:			
			System.out.println("SWITCHING TO INVENTORY");
			currentMode = MODE_INVENTORY;
			setUpInventory();
			break;
			
		case KeyEvent.VK_3:
			System.out.println("SWITCHING TO BATTLE");
			currentMode = MODE_BATTLE;
			setUpBattle();
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
	}
}
