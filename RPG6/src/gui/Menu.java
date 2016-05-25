package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class Menu implements Drawable, KeyListener {
	private List<MenuComponent> components;
	private Coord coord;
	private boolean disabled;
	
	private long startTime, currentTime, lastTime, deltaTime;

	public Menu(MenuScreen screen){
		this.components = new ArrayList<MenuComponent>();
		this.coord = new Coord(screen.getOrigin());
		this.disabled = false;
		
		this.startTime = System.currentTimeMillis();
		this.currentTime = startTime;
		
		screen.addMenu(this);
	}

	public void update(){
		updateTime();
		
		for(MenuComponent component : components){
			component.update(deltaTime);
		}
	}
	
	public void draw(Graphics2D g2){
		if(disabled || components == null) return;
		
//		System.out.println("\tDRAWING MENU COMPONENTS");
		
		for(MenuComponent component : components){
			if(!component.isHidden()) component.draw(g2);
		}
	}
	
	
	//return this for constructor shortening
	public Menu addComponent(int layer, MenuComponent component){
		component.getCoord().setOrigin(coord.getGlobal());
		components.add(layer, component);
		return this;
	}

	public Menu addComponent(MenuComponent component){
		return addComponent(components.size(), component);
	}
	
	public MenuComponent getComponent(int layer){
		if(components == null || layer < 0 || layer >= components.size()) return null;
		return components.get(layer);
	}
	
	public MenuComponent removeComponent(int layer){
		if(components == null || layer < 0 || layer >= components.size()) return null;
		return components.remove(layer);
	}
	
	public void removeAllComponents(){
		components.clear();
	}
	
	public int size(){
		return components.size();
	}
	
	public Coord getCoord() {
		return coord;
	}
	
	public void disable(){ this.disabled = true; }
	public void enable(){ this.disabled = false; }

	public long timeSinceStart(){
		return System.currentTimeMillis() - startTime;
	}
	
	public long getDeltaTime(){
		return deltaTime;
	}
	
	public void updateTime(){
		lastTime = currentTime;
		currentTime = System.currentTimeMillis();
		deltaTime = currentTime - lastTime;
		
//		System.out.println(lastTime == currentTime);
	}

	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed!");
		if(disabled || components == null) return;
		
		for(MenuComponent component : components){
			component.keyPressed(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(disabled || components == null) return;
		
		for(MenuComponent component : components){
			component.keyReleased(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		if(disabled || components == null) return;
		
		for(MenuComponent component : components){
			component.keyTyped(e);
		}
	}
}
