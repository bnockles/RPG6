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
public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	
	private KeyManager keyManager;
	private Pause pauseGame;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		pauseGame= new Pause(this, width, height);
	}
	
	private void initialize(){
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.initialize();
		
		gameState = new GameState(this);
		State.setState(gameState);
	}
	
	private void tick(){
		keyManager.update();
		
		if(State.getState() != null){
			State.getState().update();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		initialize();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				if(this.getKeyManager().pause)pauseGame.pause(thread);
				
				tick();
				render();
				delta--;
			}
			
			if(timer >= 1000000000){
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

