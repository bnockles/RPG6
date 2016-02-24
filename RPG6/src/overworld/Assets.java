package overworld;

import java.awt.image.BufferedImage;

import FirstRpg.gfx.ImageLoader;
import FirstRpg.gfx.SpriteSheet;

public class Assets {
	//JOE
	private static final int pWidth=32, pHeight=48;
	private static final int tWidth=32, tHeight=32;
	
	public static BufferedImage player,dirt, grass, greyStone, woodWall,
								woodFloor, water;
	
	public static void init(){
		SpriteSheet cSheet = new SpriteSheet(ImageLoader.loadImage("/textures/mc2.png"));
		SpriteSheet tSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
	
		player= cSheet.crop(0, 0, pWidth, pHeight);
		dirt= tSheet.crop(tWidth * 4, tHeight * 6, tWidth, tHeight);
		grass= tSheet.crop(tWidth, 0, tWidth, tHeight);
		greyStone= tSheet.crop(0, tHeight, tWidth, tHeight);
		woodWall= tSheet.crop(tWidth*5, 0, tWidth, tHeight);
		woodFloor= tSheet.crop(tWidth*4, tHeight, tWidth, tHeight);
		
	}
	
}