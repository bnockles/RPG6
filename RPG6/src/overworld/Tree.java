package overworld;

import java.awt.Graphics;



public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.fatTreeTileWidth, Tile.fatTreeTileHeight);
		// TODO Auto-generated constructor stub
		bounds.x = 30;
		bounds.y = 30;
		bounds.width = width-60;
		bounds.height = 10;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.tree, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width,height,null);
	}

}
