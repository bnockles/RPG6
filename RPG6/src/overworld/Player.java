package overworld;

import java.awt.Graphics;

//import entities.creatures.Creature;
//import entities.creatures.Game;

//import FirstRpg.Game;
//import FirstRpg.gfx.Assets;

public class Player extends Creature{

	private Game game; 

	public Player(Game game,int x, int y) {
		super(x, y, Creature.pWidth, Creature.pHeight);
		this.game = game;
	}

	public void update() {
		getInput();
		move();
	}

	public void move(){
		x += xMove;
		y += yMove;
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up){
			yMove = -speed;
		}
		if(game.getKeyManager().down){
			yMove = speed;
		}
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		if(game.getKeyManager().right){
			xMove = speed;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, pWidth, pHeight, null);
	}
  
}
