package characters;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Adam
public class Movement implements KeyListener{

	
	public KeyListener getKeyListener() {
		return this;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W){
			System.out.println("w was pressed. You are moving foward.");
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
