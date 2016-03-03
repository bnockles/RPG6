package overworld;

import java.awt.Graphics;

//import Starter.Game;
//import Starter.gfx.Assets;

public class Boss extends Creature{
	
	public Boss(Game game,int x, int y) {
		super(x, y, Creature.width, Creature.height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.zakum, (int) x, (int) y, width, height, null);
	}

}
