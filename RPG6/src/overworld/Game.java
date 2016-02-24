package overworld;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
/*
import FirstRpg.Display.Display;
import FirstRpg.Input.KeyManager;
import FirstRpg.State.GameState;
import FirstRpg.State.MenuState;
import FirstRpg.State.State;
import FirstRpg.gfx.GameCamera;
import FirstRpg.gfx.ImageLoader;
import FirstRpg.gfx.SpriteSheet;
import overworld.Assets;
*/
public class Game implements Runnable{
	
	private Display display;
	private int width, height;
	
	private Thread thread;
	private boolean running=false;
	private String title;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	

	
	public Game(String title, int width, int height){
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager= new KeyManager();
	}
	
	private void init(){
		display= new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		
		gameState= new GameState(this);
		State.setState(gameState);
	}
	
	private void update(){
		keyManager.update();
		if(State.getState()!=null)
			State.getState().update();
	}
	
	private void render(){
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Start Draw
	
		if(State.getState()!=null)
			State.getState().render(g);
		
		//End Draw
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		int fps=60;
		double timePerTick=1000000000 / fps;
		double delta=0;
		long now;
		long lastTime =System.nanoTime();
		
		while(running){
			now= System.nanoTime();
			delta +=(now-lastTime)/timePerTick;
			lastTime=now;
			
			if(delta>=1){
				update();
				render();
				delta--;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)return;
		running=true;
		thread= new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running)return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
