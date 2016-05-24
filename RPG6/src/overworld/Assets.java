package overworld;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player, grass, stone, brick, mossStone, mountainStone, grassEdgeF,grassEdgeFL,grassEdgeFR,tree,longTree;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	private static final int tWidth=32, tHeight=32;
	private static final int pWidth=32, pHeight=48;
	private static final int fatTreeW=56, fatTreeH=62;
	
	public static void init(){
		SpriteSheet pSheet = new SpriteSheet(ImageLoader.loadImage("/textures/mc.png"));
		SpriteSheet tSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tileSheet.png"));
		SpriteSheet extEntSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ExteriorEnt.png"));
		
		tree= extEntSheet.crop(132, 2, fatTreeW, fatTreeH);
		longTree= extEntSheet.crop(64, 2, 32, 62);
		
		player_down= new BufferedImage[3];
		player_up= new BufferedImage[3];
		player_left= new BufferedImage[3];
		player_right= new BufferedImage[3];
		
		player_down[0]= pSheet.crop(0, 0, pWidth, pHeight);
		player_down[1]= pSheet.crop(pWidth, 0, pWidth, pHeight);
		player_down[2]= pSheet.crop(pWidth*3, 0, pWidth, pHeight);
		
		player_up[0]= pSheet.crop(0, pHeight*3, pWidth, pHeight);
		player_up[1]= pSheet.crop(pWidth, pHeight*3, pWidth, pHeight);
		player_up[2]= pSheet.crop(pWidth*3, pHeight*3, pWidth, pHeight);
		
		player_left[0]= pSheet.crop(0, pHeight, pWidth, pHeight);
		player_left[1]= pSheet.crop(pWidth, pHeight, pWidth, pHeight);
		player_left[2]= pSheet.crop(pWidth*3, pHeight, pWidth, pHeight);
		
		player_right[0]= pSheet.crop(0, pHeight*2, pWidth, pHeight);
		player_right[1]= pSheet.crop(pWidth, pHeight*2, pWidth, pHeight);
		player_right[2]= pSheet.crop(pWidth*3, pHeight*2, pWidth, pHeight);
		
		stone=tSheet.crop(0, 0, tWidth, tHeight);
		mossStone=tSheet.crop(tWidth, 0,tWidth, tHeight);
		grass=tSheet.crop(tWidth*5, tHeight*4, tWidth, tHeight);
		mountainStone=tSheet.crop(tWidth, tHeight*5, tWidth, tHeight);
		grassEdgeF=tSheet.crop(tWidth*5, tHeight*5, tWidth, tHeight);
		grassEdgeFL=tSheet.crop(tWidth*4, tHeight*5, tWidth, tHeight);
		grassEdgeFR=tSheet.crop(tWidth*6, tHeight*5, tWidth, tHeight);
	}
	
}
