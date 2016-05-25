package HowardDemo;


public class HowardDemo extends Game{
	public static void main(String[] args){
		new HowardDemo();
	}
	
	public void reset(){
		Screen demoScreen = new HowardScreen(this);
		setScreen(demoScreen);
	}
}