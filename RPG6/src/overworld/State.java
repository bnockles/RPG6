package overworld;

import java.awt.Graphics;



public abstract class State {
	
	private static State currentState=null;
	private static State gameState=null;
	public static void setState(State state){
		currentState=state;
	}
	public static State getState(){
		return currentState;
	}
	public static State getGameState(){
		return gameState;
	}
	public static void setGameState(State gs){
		gameState=gs;
	}
	protected Handler handler;
	public State(Handler handler){
		this.handler=handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
