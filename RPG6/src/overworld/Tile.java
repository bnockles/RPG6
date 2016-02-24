package overworld;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC
	
	public static Tile[] tiles= new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile GreyStoneTile= new GreyStoneTile(1);
	
	//CLASS
	public static final int TILEWIDTH = 32, TILEHEIGHT=32;
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture=texture;
		this.id=id;
		
		tiles[id]=this;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isSolid(){
		return false;
	}
	
}
