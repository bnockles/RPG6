package overworld;

import java.awt.image.BufferedImage;



public class GrassEdgeFTile extends Tile{

	public GrassEdgeFTile(int id) {
		super(Assets.grassEdgeF, id);
		// TODO Auto-generated constructor stub
	}

	public boolean isSolid(){
		return false;
	}
}
