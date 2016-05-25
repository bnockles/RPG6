package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class  MenuGrid extends Menu {
	private List<Menu> grid;
	private Point cursor;
	
	private boolean loop;
	
	public MenuGrid(MenuScreen screen) {
		super(screen);
		
		this.grid = new ArrayList<Menu>();
		this.cursor = new Point(0, 0);
		this.loop = false;
	}

	
	@Override
	public void draw(Graphics2D g2){
		for(Menu menu : grid){
			menu.draw(g2);
		}
		
		postDraw(g2);
	}
	
	
	//This is where we draw things like cursors etc
	public abstract void postDraw(Graphics2D g2);
	
	
	public void setLoop(boolean loop){
		this.loop = loop;
	}

	public void moveCursor(int x, int y){
		
	}
	
	public void setCursor(){
		
	}
}
