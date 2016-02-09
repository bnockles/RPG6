package sampleoverworld;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * 
 * @author bnockles
 *
 */
public interface OverworldLocation {
	
	public BufferedImage getImage();
	public Rectangle getBoundary();
	public int[] getTileRowAndColumn();
	public int[] getLocationOnTile();
	public void enter();
	
}
