package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class DialogBox extends MenuBox {
	private List<String> bufferedText;
	private String currentText;
	private int cursor;
	
	private int maxLineChars;
	private int textPositionX, textPositionY;
	private int lineGap;
	private Color textColor;
	
	private long last, interval;

	public DialogBox(Menu menu, String text, int maxCharsPerLine, int x, int y) {
		super(menu, x, y);
		
		this.bufferedText = new ArrayList<String>();
		this.currentText = text;
		this.cursor = 0;
		
		while(!text.isEmpty()){
			String line = "";
			
			if(maxCharsPerLine < text.length()){
				line = text.substring(0, maxCharsPerLine);
				text = text.substring(maxCharsPerLine);
			}
			else{
				line = text.substring(0);
				text = "";
			}
			
			bufferedText.add(line);
		}
		
		this.maxLineChars = maxCharsPerLine;
		this.textPositionX = 4;
		this.textPositionY = 14;
		this.lineGap = 16;
		this.textColor = Color.WHITE;
		
		this.last = System.currentTimeMillis();
		this.interval = -1;
	}

	public void setMaxLineChars(int maxLineChars){
		this.maxLineChars = maxLineChars;
	}
	
	public void setTextPosition(int x, int y){
		this.textPositionX = x;
		this.textPositionY = y;
	}
	
	public void setTextColor(Color color){
		this.textColor = color;
	}
	

	@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);
		
		Point global = getParentGlobal();
		
		
		g2.setColor(textColor);
		int pos = 0;
		for(String str : bufferedText){
//			System.out.println(str);
			
			g2.drawString(str, global.x + textPositionX, global.y + textPositionY + pos * lineGap);
			++pos;
		}
	}

}
