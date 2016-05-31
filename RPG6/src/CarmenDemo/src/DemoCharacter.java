import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import items.CharacterInterface;
import items.Item;
import items.Stats;

public class DemoCharacter implements CharacterInterface {
	
	ArrayList<Integer>stats = new ArrayList<Integer>();
	int x;
	int y;
	
	BufferedImage image;
	
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

	public DemoCharacter(String img,int horizontal,int vertical,Stats stats){
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

	@Override
	public int getPlayerCurrency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Item> getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return 10000;
	}

	public int getMana() {
		// TODO Auto-generated method stub
		return 5000;
	}
	
}
