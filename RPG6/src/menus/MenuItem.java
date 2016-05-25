package menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MenuItem {
	
    private String name;
    private BufferedImage image;
    private ArrayList<MenuItem> children = new ArrayList<MenuItem>();
    private MenuItem parent;

    public MenuItem(String name) {
    	this.name = name;
    	this.image = createImage(name,50,50);
    }

	public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getChildren() {
        return children;
    }

    public MenuItem getParent() {
        return parent;
    }
    
    public void setParent(MenuItem parent) {
		this.parent = parent;
	}
    
    public void addChild(MenuItem item) {
        children.add(item);
    }
    
    public void addAllChildren(ArrayList<MenuItem> items) {
        children.addAll(items);
    }
    
    public void removeAllChildren() {
        children.removeAll(this.children);
    }
    
	public final BufferedImage createImage(String path, int imgWidth, int imgHeight){
		BufferedImage img = null;
		BufferedImage canvas = null;
		try{
			URL imageURL = this.getClass().getResource(path+".png");
			img = ImageIO.read(imageURL);
			canvas = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) canvas.getGraphics();
			g.drawImage(img,0,0,imgWidth,imgHeight,null);
			g.dispose();
		}
		catch(Exception e){
		}
		return canvas;
	}

	public BufferedImage getImage() {
		return image;
	}
}
