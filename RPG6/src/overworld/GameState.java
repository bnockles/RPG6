package overworld;

import java.awt.Graphics;



public class GameState extends State{

	private Player player;
	private World world;

	
	public GameState(Handler handler){
		super(handler);
		world=new World(handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		
	
		//player.determineStance(g);
		
	}

}
