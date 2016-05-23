package towns;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SampleCharacter {
	
	/**
	 * 
	 * @author Khandaker Shayel, Jeffrey Lei
	 *
	 */
	
	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setimage(BufferedImage image) {
		this.image = image;
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

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public int currency;
	BufferedImage image;
	String name;
	int x ;
	int y;
	ArrayList<String> items;
	
	public SampleCharacter(int cur, String nm, String imageLocation, int locationX, int locationY, ArrayList<String> items){
		this.currency = cur;
		this.name = nm;
		this.items = items;
		int width = 150;
		int height = 200;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		x = locationX;
		y = locationY;
		URL url = getClass().getResource(imageLocation);
		
		try {
			BufferedImage original = ImageIO.read(url);
			
			//draw the image file into a scaled version on the image canvas
			Graphics2D g = (Graphics2D) image.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			
			
			g.drawImage(original,0,0,width,height,0,0,w,h,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SampleCharacter(String imageLocation, int locationX, int locationY){
		int width = 150;
		int height = 200;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		x = locationX;
		y = locationY;
		URL url = getClass().getResource(imageLocation);
		
		try {
			BufferedImage original = ImageIO.read(url);
			
			//draw the image file into a scaled version on the image canvas
			Graphics2D g = (Graphics2D) image.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			
			
			g.drawImage(original,0,0,width,height,0,0,w,h,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
