package overworld;

import java.awt.image.BufferedImage;



public class GrassEdgeFRTile extends Tile{

	public GrassEdgeFRTile(int id) {
		super(Assets.grassEdgeFR, id);
		// TODO Auto-generated constructor stub
	}
	public boolean isSolid(){
		return true;
	}
}
