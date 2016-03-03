package overworld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, world1, world2, world3, world4;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void update(){
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		world1=keys[KeyEvent.VK_1];
		world2=keys[KeyEvent.VK_2];
		world3=keys[KeyEvent.VK_3];
		world4=keys[KeyEvent.VK_4];
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

}
