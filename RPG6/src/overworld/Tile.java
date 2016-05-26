package overworld;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles=new Tile[2560];
	public static Tile grassTile=new GrassTile(0);
	public static Tile stoneTile=new StoneTile(1);
	public static Tile mossStoneTile=new MossStoneTile(2);
	public static Tile mountainStoneTile=new MountainStoneTile(3);
	public static Tile grassEdgeFTile=new GrassEdgeFTile(4);
	public static Tile grassEdgeFLTile=new GrassEdgeFLTile(5);
	public static Tile grassEdgeFRTile=new GrassEdgeFRTile(6);
	//CLASS
	
	public static final int TILEWIDTH=32,TILEHEIGHT=32;
	public static final int fatTreeTileWidth=56, fatTreeTileHeight=62;
	public static final int longTreeTileWidth=32, longTreeTileHeight=62;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
	}
	
	public void tick(){
		
	}
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT, null);
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isSolid(){
		return false;
	}
}
