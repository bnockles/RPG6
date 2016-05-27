package SonyaDemo;


import java.awt.Component;

public class SonyaDemo extends Game {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SonyaDemo();
		
		
	}
	public void reset(){
		Screen demoScreen = new SonyaScreen(this);
		setScreen(demoScreen); 
	}

}

