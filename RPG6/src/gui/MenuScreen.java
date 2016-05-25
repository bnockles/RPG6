package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;


public abstract class MenuScreen extends Screen implements KeyListener {
	private final Point origin;
	private List<Menu> menus;
	
	
	public MenuScreen(Game game){
		this(game, 0, 0);
	}

	public MenuScreen(final Game game, int x, int y){
		super(game);
		
//		System.out.println("MENUSCREEN CONSTRUCTOR CALLED");
		
		this.origin = new Point(x, y);
		this.menus = new ArrayList<Menu>();
		
//		System.out.println("CONSTRUCTOR ORIGIN:\t(" +origin.x + "," + origin.y+")");	
//		System.out.println("CONSTRUCTOR MENUS:\t" + (menus.size()));
		
		new Timer(60, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.activeScreen.update();
				game.repaint();
			}
		}).start();
	}

	public void updateMenus(){
		if(menus == null) return;
		
		for(Menu menu : menus){
			menu.update();
		}
	}
	
	public void drawMenus(Graphics2D g2){
		if(menus == null) return;
		
//		System.out.println("DRAWING MENUS");
		
		for(Menu menu : menus){
			menu.draw(g2);
		}
	}

	public void setOrigin(int x, int y){
		this.origin.setLocation(x, y);
	}
	
	public Point getOrigin(){ return origin; }
	public Menu getMenu(int layer){
		if(menus == null || layer < 0 || layer >= menus.size()) return null;
		return menus.get(layer);
	}
	
	public void addMenu(int layer, Menu menu){
		menus.add(layer, menu);
	}

	public void addMenu(Menu menu){
		addMenu(menus.size(), menu);
	}
	

	public void keyPressed(KeyEvent e) {
		if(menus == null) return;
		
		for(Menu menu : menus){
			menu.keyPressed(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(menus == null) return;
		
		for(Menu menu : menus){
			menu.keyReleased(e);
		}
	}

	public void keyTyped(KeyEvent e) {
		if(menus == null) return;
		
		for(Menu menu : menus){
			menu.keyTyped(e);
		}
	}
}
