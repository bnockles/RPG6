package overworld;

//import FirstRpg.Game;
//import FirstRpg.Entity.Entity;

public abstract class Creature extends Entity {

	public static int DEFAULT_SPEED = 3;
	public static int width = 64, height = 64;
	public static int pWidth = 32, pHeight = 48;
	
	int speed;
	int xMove, yMove;

	public Creature(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	
	
}
