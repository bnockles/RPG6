package overworld;

import java.awt.Graphics;



public class longTree extends StaticEntity{

	public longTree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.longTreeTileWidth, Tile.longTreeTileHeight);
		// TODO Auto-generated constructor stub
		bounds.x = 10;
		bounds.y = (int) (height / 1.6f);
		bounds.width = width-20;
		bounds.height = (int) (height-height / 1.6f);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.longTree, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width,height,null);
	}

}
