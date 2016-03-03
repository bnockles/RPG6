package overworld;

import java.awt.Graphics;

public class SelectWorld {
	
	private Game game;
	public int worldNum;
	private Graphics g;
	//private World world;
	
	public SelectWorld(Game game){
		this.game=game;
	}
	public void updateWorld(World world){
		world.update();
	}
	public void updateWorldG(World world, Graphics g){
		world.render(g);
	}

}
