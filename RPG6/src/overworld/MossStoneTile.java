package overworld;

import java.awt.image.BufferedImage;



public class MossStoneTile extends Tile{

	public MossStoneTile(int id) {
		super(Assets.mossStone, id);
		// TODO Auto-generated constructor stub
	}
	public boolean isSolid(){
		return true;
	}

}
