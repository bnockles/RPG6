package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DrawItem {
	private static void drawBg(Graphics g, int x, int y, int w, int h){
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
	}
	
	
	private BufferedImage icon24;
	private BufferedImage icon32;
	private BufferedImage icon64;
	

	
	// utility method to assign icon images
	// uses builder pattern
	//	i.e. you can do [[ DrawItem d = new DrawItem().setIcon32(...); ]]
	private DrawItem setIconXX(BufferedImage icon, int size){
		if(icon.getWidth() == size && icon.getHeight() == size){
			switch(size){
			case 24:
				this.icon24 = icon;
				break;
			case 32:
				this.icon32 = icon;
				break;
			case 64:
				this.icon64 = icon;
				break;
			default:
				System.out.println("Invalid icon size!");
				break;
			}
		}
		else{
			System.out.println("Icon"+size+" must be assigned a "+size+"x"+size+" icon!");
		}
		
		return this;
	}
	
	public DrawItem setIcon24(BufferedImage icon){
		return setIconXX(icon, 24);
	}
	
	public DrawItem setIcon32(BufferedImage icon){
		return setIconXX(icon, 32);
	}
	
	public DrawItem setIcon64(BufferedImage icon){
		return setIconXX(icon, 64);
	}
	

	public void drawIcon24(Graphics g, int x, int y){
		g.drawImage(this.icon24, x, y, (ImageObserver)this.icon24);
	}

	public void drawIcon32(Graphics g, int x, int y){
		g.drawImage(this.icon32, x, y, (ImageObserver)this.icon32);
	}
	
	public void drawIcon64(Graphics g, int x, int y){
		g.drawImage(this.icon64, x, y, (ImageObserver)this.icon64);
	}
}
