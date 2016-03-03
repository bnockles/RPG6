package overworld;

import java.awt.Graphics;


public class swordFloor extends ItemOnFloor {

	public swordFloor(Game game,int x, int y) {
		super(x, y, ItemOnFloor.width, ItemOnFloor.height);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sword, (int) x, (int) y, width, height, null);
	}

}

