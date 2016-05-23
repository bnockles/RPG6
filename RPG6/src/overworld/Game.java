package overworld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;



public class Game implements Runnable{
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running=false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State pauseState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	
	public Game(String title, int width, int height){
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager=new KeyManager();
	}
	
	
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		handler=new Handler(this);
		gameCamera=new GameCamera(handler, 0,0);
		Assets.init();
		gameState=new GameState(handler);
		pauseState=new PauseState(handler,width,height);
		State.setState(gameState);
	}
	

	
	private void update(){
		keyManager.tick();
		if(State.getState()!=null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw
		
		if(State.getState()!=null)
			State.getState().render(g);
		
		//End Draw
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		int fps=60;
		double timePerUpdate=1000000000/fps;
		double delta=0;
		long now;
		long lastTime= System.nanoTime();
		
		while(running){
			if(this.getKeyManager().pause){
				State.setGameState(gameState);
				State.setState(pauseState);
				
			}
			if(this.getKeyManager().resume){
				State.setState(gameState);
			}
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerUpdate;
			lastTime=now;
			if(delta>=1){
				update();
				render();
				delta--;
			}

		}
		stop();
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
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
		thread=new Thread(this);
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






























