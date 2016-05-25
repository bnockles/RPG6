package gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyListener;

public abstract class MenuComponent implements Drawable, KeyListener
{
	private static int defaultWidth = 200, defaultHeight = 100;
	private static Color defaultColor = Color.BLACK;
	
	public static void setDefaultDimensions(int width, int height){
		defaultWidth = width;
		defaultHeight = height;
	}
	
	public static void setDefaultColor(Color color){
		defaultColor = color;
	}

	
	private Coord coord;

	protected int width, height;
	protected Color color;
	protected Updatable onUpdate;
	protected boolean hidden;

	public MenuComponent(Menu menu){
		this(menu, 0, 0);
	}

	public MenuComponent(Menu menu, int x, int y){
		coord = new Coord(menu.getCoord().getGlobal());
		coord.setPosition(x, y);
		
		this.width = defaultWidth;
		this.height = defaultHeight;
		this.color = defaultColor;
		
		this.onUpdate = new Updatable(){
			public void update(long dt, MenuComponent component){}
		};
		
		this.hidden = false;
		
		menu.addComponent(this);
	}
	
	

	//wrapper methods to shorten constructor
	public void setDimensions(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setPosition(int x, int y){
		coord.setPosition(x, y);
	}
	
	public void setHidden(boolean hidden){
		this.hidden = hidden;
	}
	
	public boolean isHidden(){
		return hidden;
	}

	
	public Color getColor(){
		return this.color;
	}
	
	public Coord getCoord() {
		return coord;
	}
	
	//shorthand method for getCoord().getGlobal();
	public Point getParentGlobal(){
		return coord.getGlobal();
	}
	
	public void setOnUpdate(Updatable onUpdate){
		this.onUpdate = onUpdate;
	}
	
	//update method to run logic each frame
	public final void update(long dt){
		this.onUpdate.update(dt, this);
	}
}
