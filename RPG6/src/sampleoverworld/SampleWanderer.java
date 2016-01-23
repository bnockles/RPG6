package sampleoverworld;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SampleWanderer implements OverworldWanderer{

	BufferedImage image;
	ArrayList<Integer> pressedKeys;//allow for multiple input
	boolean walking;
	int count;
	int spriteX;
	int spriteY;
	public static final int MOVE_UNIT = 6;
	Navigatable map;
	
	public SampleWanderer() {
		image = 
	}
	
	public BufferedImage getImage(){
		return image;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return spriteY;
	}

	private void checkMotion() {
		int proposedNewY=spriteY;
		int proposedNewX=spriteX;
		
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY-=MOVE_UNIT;
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY+=MOVE_UNIT;
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX+=MOVE_UNIT;
		
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX-=MOVE_UNIT;
		if(walking)count++;
		
		if(!map.isCollision(proposedNewX, proposedNewY)){
			spriteY=proposedNewY;
			spriteX=proposedNewX;
		}
		
	
	}
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			walking=true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(pressedKeys.isEmpty())walking=false;
	}

}
