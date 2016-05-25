package gui;

import java.awt.Point;

public final class Coord {
	private Point origin;
	private final Point global, local;
	
	
	//Linking the parent's global coordinate to the child's origin
	//	allows us to synchronize movement between the two.
	//
	//	E.G. 
	//		Given parent -> child,
	//			when parent moves, child moves with it
	//			this is because the parent's global point is referenced
	//			within the child's origin
	
	public Coord(Coord coord){
		this(coord.getGlobal());
	}
	
	public Coord(Point origin){
		this(origin, new Point(0, 0));
	}
	
	public Coord(Point origin, Point local){
		this.origin = origin;
		this.global = new Point(origin.x + local.x, origin.y + local.y);
		this.local = new Point(global.x - origin.x, global.y - origin.y);
	}
	
	private void updateGlobal(){
		global.setLocation(origin.x + local.x, origin.y + local.y);
	}
	
	public String toString(){
		updateGlobal();
		return "("+global.x+","+global.y+")";
	}
	
	
	public void translate(int x, int y){
		local.translate(x, y);
	}
	
	public void setPosition(int x, int y){
		local.move(x, y);
	}
	
//	public Point getOrigin(){ return origin; }
	public void setOrigin(Point origin){
		global.setLocation(origin.x + local.x, origin.y + local.y);
		this.origin = origin;
	}
	
	public Point getGlobal(){
		updateGlobal();
		return this.global; 
	}
}
