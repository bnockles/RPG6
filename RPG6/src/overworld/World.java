package overworld;

import java.awt.Graphics;

//import FirstRpg.Game;
//import FirstRpg.Tile.Tile;
//import FirstRpg.Utility.Utilities;

public class World {
	
	private Game game;
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	//private boolean origin;
	
	public World(Game game,String path){
		this.game=game;
		loadWorld(path);
	}
	
	public void update(){
	}
	
	public void render(Graphics g){
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				getTile(x,y).render(g,x* Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
			}
		}
		
	}
	
	public Tile getTile(int x, int y){
		Tile t=Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file=Utilities.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width=Utilities.parseInt(tokens[0]);
		height=Utilities.parseInt(tokens[1]);
		xSpawn=Utilities.parseInt(tokens[2]);
		ySpawn=Utilities.parseInt(tokens[3]);
		
		tiles = new int [width][height];
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				tiles[x][y]=Utilities.parseInt(tokens[(x + y * width)+4]);
			}
		}
	}
	
	
}
