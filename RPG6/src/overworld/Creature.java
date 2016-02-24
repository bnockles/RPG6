package overworld;

import FirstRpg.Game;
import FirstRpg.Entity.Entity;

public abstract class Creature extends Entity {

	protected int health;
	
	public static final int DEFAULT_HEALTH=10;
	public static final float DEFAULT_SPEED=3.0f;
	public static final int defaultWidth=32,
							defaultHeight=48;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Game game,float x, float y, int width, int height) {
		super(game, x, y, width, height);
		health=DEFAULT_HEALTH;
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
	}

	public void move(){
		x+=xMove;
		y+=yMove;
	}

	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
