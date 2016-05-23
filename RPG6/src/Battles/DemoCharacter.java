package Battles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DemoCharacter {
	String title;
	 
	ArrayList<String> meleeMoves = new ArrayList<String>();
	ArrayList<String> spellMoves = new ArrayList<String>();
	ArrayList<Integer>stats = new ArrayList<Integer>();
	int x;
	int y;
	
	BufferedImage image;
	public String getTitle() {
		return title;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
	public DemoCharacter(String img,int horizontal,int vertical,ArrayList<Integer>charInfo,ArrayList<String>giveMovesM,ArrayList<String>giveMovesS, String name){
		this.title = name;
		this.meleeMoves.addAll(giveMovesM);
		this.spellMoves.addAll(giveMovesS);
		this.stats.addAll(charInfo);
		this.x = horizontal;
		this.y = vertical;
		image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		System.out.println("The image being printed is: "+img);
		URL url = getClass().getResource(img);
		System.out.println(url);
		try {
			BufferedImage original = ImageIO.read(url);
			
			
			Graphics2D g = (Graphics2D) image.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			
			
			g.drawImage(original,0,0,300,250,0,0,w,h,null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
