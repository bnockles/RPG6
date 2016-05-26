package Battles.WilsonDemo;

import java.awt.image.BufferedImage;

public interface BattleComponent {
	
	public BufferedImage getImage();
	
	public int getX();
	
	public int getY();
	
	public void keyAction(int keyCode);
	
}
