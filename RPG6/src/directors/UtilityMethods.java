package directors;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class UtilityMethods {

	public static void centerText(Graphics2D g2, String string, int width, int height){
		FontMetrics fm = g2.getFontMetrics();
		int w = fm.stringWidth(string);
		int h = fm.getHeight();
		int x = (width-w)/2;
		int y = (height+h)/2;
		g2.drawString(string, x, y);
	}
	
	public static void centerTextAtY(Graphics2D g2, String string, int width, int y){
		FontMetrics fm = g2.getFontMetrics();
		int w = fm.stringWidth(string);
		int x = (width-w)/2;
		g2.drawString(string, x, y);
	}
	
	
	public static BufferedImage getImageFromFile(Object requestingObject, String addressInResourcesFolder) throws IOException{
		URL url = requestingObject.getClass().getResource(addressInResourcesFolder);
		BufferedImage image = ImageIO.read(url);
		return image;
	}

	public static BufferedImage getScaledImage(BufferedImage original,
			int width, int height) {
		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = result.createGraphics();
		g2.drawImage(original,0,0,width,height,0,0,original.getWidth(),original.getHeight(),null);
		return result;
	}
	
}
