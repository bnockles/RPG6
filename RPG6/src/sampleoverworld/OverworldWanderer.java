package sampleoverworld;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public interface OverworldWanderer extends KeyListener{

	public BufferedImage getImage();
	public int getX();
	public int getY();
	
}
