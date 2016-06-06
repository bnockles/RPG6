package storyline;

public class TasniaDemo extends Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TasniaDemo();

	}
	
	public void reset(){
		Screen demoScreen = new TasniaScreen(this);
		setScreen(demoScreen);
	}

}


