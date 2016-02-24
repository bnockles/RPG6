package overworld;

import java.awt.image.BufferedImage;

//import FirstRpg.gfx.Assets;

public class GreyStoneTile extends Tile{

	public GreyStoneTile(int id) {
		super(Assets.greyStone, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
