package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public final class _MenuDemo extends Game {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new _MenuDemo();
	}
	
	public _MenuDemo(){
		super();
		
		
	}

	@Override
	public void reset(){
//		System.out.println("CALLING RESET");
		
		MenuScreen demoScreen = new _MenuDemoScreen(this);
		
		setScreen(demoScreen);
		repaint();
	}
}
