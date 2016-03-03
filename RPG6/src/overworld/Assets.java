package overworld;

import java.awt.image.BufferedImage;

//import FirstRpg.gfx.ImageLoader;
//import FirstRpg.gfx.SpriteSheet;

public class Assets {
	//JOEe
	private static final int pWidth=32, pHeight=48;
	private static final int tWidth=32, tHeight=32;
	
	private static int eWidth = 32, eHeight = 32;
	
	public static BufferedImage player,dirt, grass, greyStone, woodWall,
								woodFloor, water, potion, chest, zakum, axe, sword, lance;
	
	public static void initialize(){
		SpriteSheet cSheet = new SpriteSheet(ImageLoader.loadImage("/textures/mc2.png"));
		SpriteSheet tSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet sheetI = new SpriteSheet(ImageLoader.loadImage("/textures/sheetI.png"));
		
		potion = sheetI.crop(0,0,eWidth,eHeight);
		chest = sheetI.crop(eWidth,0,eWidth,eHeight);
		zakum = sheetI.crop(0,eHeight,eWidth,eHeight);
		axe = sheetI.crop(eWidth,eHeight,eWidth,eHeight);
		sword = sheetI.crop(0,eHeight*2,eWidth,eHeight);
		lance = sheetI.crop(eWidth,eHeight*2,eWidth,eHeight);
		
		player= cSheet.crop(0, 0, pWidth, pHeight);
		dirt= tSheet.crop(tWidth * 4, tHeight * 6, tWidth, tHeight);
		grass= tSheet.crop(tWidth, 0, tWidth, tHeight);
		greyStone= tSheet.crop(0, tHeight, tWidth, tHeight);
		woodWall= tSheet.crop(tWidth*5, 0, tWidth, tHeight);
		woodFloor= tSheet.crop(tWidth*4, tHeight, tWidth, tHeight);
		
	}
	
}