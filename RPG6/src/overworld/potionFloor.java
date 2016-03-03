package overworld;

import java.awt.Graphics;


public class potionFloor extends ItemOnFloor {

	public potionFloor(Game game,int x, int y) {
		super(x, y, ItemOnFloor.width, ItemOnFloor.height);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.potion, (int) x, (int) y, width, height, null);
	}

}

