package overworld;

import java.awt.image.BufferedImage;



public class GrassEdgeFLTile extends Tile{

	public GrassEdgeFLTile(int id) {
		super(Assets.grassEdgeFL, id);
		// TODO Auto-generated constructor stub
	}
	public boolean isSolid(){
		return true;
	}
}
