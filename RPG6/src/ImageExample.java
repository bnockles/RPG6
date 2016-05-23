import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageExample extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int WIDTH = 1000;
	public final int HEIGHT = 800;

	public static void main(String[] args) {
		new ImageExample();
	}

	public ImageExample() {
		applySettings();
		setVisible(true);
	}

	
	private void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		setSize(WIDTH,HEIGHT);
		setLocation((monitorWidth-WIDTH)/2,(monitorHeight-HEIGHT)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
	}
	
	
	public void paint(Graphics g){
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(getImage("Image Directory"), 500, 500, null);
//		g.drawImage(getImage("Link.png"), 500, 500, null);
	}
	
	public final BufferedImage getImage(String path){
		BufferedImage img = null;
		try{
			URL imageURL = this.getClass().getResource(path);
			img = ImageIO.read(imageURL);
		}
		catch(Exception e){
		}
		return img;
	}
}
