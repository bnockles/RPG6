package overworld;

import java.awt.image.BufferedImage;

//import FirstRpg.gfx.ImageLoader;
//import FirstRpg.gfx.SpriteSheet;

public class Assets {
	//JOEe
	private static int width = 32, height = 32;
	
	public static BufferedImage player,dirt, grass, greyStone, woodWall,
								woodFloor, water, potion, chest, zakum, 
								axe, sword, lance, cobbleStone, lava;

	
	public static void initialize(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		int sheetWidth = SpriteSheet.getWidth();
		int sheetHeight = SpriteSheet.getHeight();
		
		BufferedImage[][] pics = new BufferedImage[sheetWidth/width][sheetHeight/height];
		
		for(int i=0;i<pics.length;i++){
			for(int j=0;j<pics[i].length;j++){
				pics[i][j] = sheet.crop(i*width,j*height,height,height);
			}
		}
		
		potion = pics[11][8];
		chest = pics[12][8];
		zakum = pics[11][9];
		axe = pics[12][9];
		sword = pics[11][10];
		lance = pics[12][10];
		
		lava = pics[11][13];
		water = pics[12][12];
		
		player = pics[11][12];
		dirt = pics[9][17];
		grass = pics[9][14];
		greyStone = pics[0][9];
		woodWall = pics[5][8];
		woodFloor = pics[4][9];
		cobbleStone = pics[6][10];
		
	}
	
}