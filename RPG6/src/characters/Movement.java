package characters;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Adam Fan
public class Movement implements KeyListener{

	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W){
			System.out.println("w was pressed. You are moving foward.");
			/**
			 * Note from Mr. Nockles
			 * This will work well for the demo, but you need to plan carefully how the Movement KeyListener is used.
			 * Is it used by Character? If so, maybe character needs to implement a Mover class that has methods like
			 * "moveLeft", "moveRight", etc..
			 * */
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			System.out.println("a was pressed. You are moving to the left.");
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			System.out.println("s was pressed. You are moving backward.");
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			System.out.println("d was pressed. You are moving to the right.");
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
