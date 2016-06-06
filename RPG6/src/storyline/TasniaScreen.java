package storyline;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;


public class TasniaScreen extends Screen implements KeyListener {
	String myOutput = "";
	int i=1;
	public TasniaScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			//outline
			TextReader y = new TextReader("0");
			myOutput = new JTextField(y.getDialogue("TEXT"+i), 20).getText();
			i++;
			update();
			game.repaint();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawString(myOutput, 100, 100);
	}


	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

}
