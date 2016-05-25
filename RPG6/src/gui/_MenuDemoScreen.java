package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public final class _MenuDemoScreen extends MenuScreen implements KeyListener {
	private static final int 	MODE_ANIMATION = 1<<0,
								MODE_INVENTORY = 1<<1,
								MODE_CUTSCENE  = 1<<2;
	
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

		_DemoPlayer dp = new _DemoPlayer(menu, 100, 100);
		
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
						c.getCoord().translate(s+1, s);
					}
				});
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
//		
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

	private void setUpCutscene(){
		menu.removeAllComponents();
		
		
	}
	

	@Override
	public void paintScreen(Graphics2D g2) {
		updateMenus();
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
			System.out.println("SWITCHING TO CUTSCENE");
			currentMode = MODE_CUTSCENE;
			setUpCutscene();
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
