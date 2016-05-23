package overworld;

import java.awt.image.BufferedImage;



public class MountainStoneTile extends Tile {

	public MountainStoneTile(int id) {
		super(Assets.mountainStone, id);
		// TODO Auto-generated constructor stub
	}
	public boolean isSolid(){
		return true;
	}

}
