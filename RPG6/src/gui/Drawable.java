package gui;

import java.awt.Graphics2D;

public interface Drawable {
	public Coord getCoord();
	public void draw(Graphics2D g2);
}
