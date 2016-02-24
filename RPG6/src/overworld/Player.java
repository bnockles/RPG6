package overworld;

import java.awt.Graphics;

//import FirstRpg.Game;
//import FirstRpg.gfx.Assets;

public class Player extends Creature{
	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.defaultWidth,Creature.defaultHeight);
		
	}

	@Override
	public void update() {
		getInput();
		move();
	
	}
	public void getInput(){
		xMove=0;
		yMove=0;
		if(game.getKeyManager().up) yMove = -speed;
		if(game.getKeyManager().down) yMove = speed;
		if(game.getKeyManager().left) xMove = -speed;
		if(game.getKeyManager().right) xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}

}
