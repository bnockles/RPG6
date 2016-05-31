package directors;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

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
	
}
