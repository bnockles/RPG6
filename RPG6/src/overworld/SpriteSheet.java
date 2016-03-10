package overworld;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	//Joe
	
	private static BufferedImage sheet;
	
	//SpriteSheet Class has access whatever Spritesheet image passed in
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x,int y,int width,int height){
		return sheet.getSubimage(x,y,width,height);
	}

	public static int getWidth() {
		return sheet.getWidth();
	}

	public static int getHeight() {
		return sheet.getHeight();
	}
	
	//x,y
		
				//width,height
}
