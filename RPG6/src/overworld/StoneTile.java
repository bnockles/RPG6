package overworld;

import java.awt.image.BufferedImage;



public class StoneTile extends Tile{

	public StoneTile(int id) {
		super(Assets.stone, id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
