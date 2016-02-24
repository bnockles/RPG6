package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawItem {
	private BufferedImage icon24;
	
	
	public void draw(Graphics g, int x, int y, String[] text){}
	public void draw(Graphics g, int x, int y, String text1, String text2){
		drawBg(g, x, y);
		
		g.setColor(Color.white);
		g.drawString(text1, x+10, y+10);
		g.drawString(text2, x+10, y+100);
	}
	
	private void drawBg(Graphics g, int x, int y){
		//Color original = g.getColor();
		
		//replace these magic numbers with variabless
		g.setColor(Color.black);
		g.fillRect(x, y, 200, 300);
		
		//g.setColor(original);
	}
}
