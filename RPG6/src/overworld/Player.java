package overworld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Player extends Creatures{

	//Animations
	private Animation down, up, left, right;
	private float OGX=0;
	private float OGY=0;
	private BufferedImage lastStance;
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
		// TODO Auto-generated constructor stub
		bounds.x=6;
		bounds.y=20;
		bounds.width=19;
		bounds.height=28;
		down = new Animation(100, Assets.player_down);
		up = new Animation(100, Assets.player_up);
		left = new Animation(100, Assets.player_left);
		right = new Animation(100, Assets.player_right);
		lastStance=down.getStandingFrame();
	}

	@Override
	public void tick() {
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove=0;
		yMove=0;
		if(handler.getKeyManager().up){
			up.tick();
			yMove=-speed;
		}
		if(handler.getKeyManager().down){
			down.tick();
			yMove=speed;
		}
		if(handler.getKeyManager().left){
			left.tick();
			xMove=-speed;
		}
		if(handler.getKeyManager().right){
			right.tick();
			xMove=speed;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), 
		//		(int)(y + bounds.y - handler.getGameCamera().getyOffset()) , bounds.width , bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		if(xMove < 0){
			lastStance=left.getStandingFrame();
			return left.getCurrentFrame();
		}else if(xMove > 0){
			lastStance=right.getStandingFrame();
			return right.getCurrentFrame();
		}else if(yMove < 0){
			lastStance=up.getStandingFrame();
			return up.getCurrentFrame();
		}else if(yMove > 0){
			lastStance=down.getStandingFrame();
			return down.getCurrentFrame();
		}else{
			return lastStance;
		}
		
	}
	
	public Handler getPlayerHandler(){
		return this.handler;
	}
}
