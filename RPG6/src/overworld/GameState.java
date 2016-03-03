package overworld;

import java.awt.Graphics;

//import FirstRpg.Game;
//import FirstRpg.Entity.Creatures.Player;
//import FirstRpg.Worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world, world2, world3, world4;
	
	public GameState(Game game){
		super(game);
		player=new Player(game, 100,100);
		world= new World(game,"resources/worlds/world1.txt");
		world2= new World(game,"resources/worlds/world2.txt");
		world3= new World(game,"resources/worlds/world3.txt");
		world4= new World(game,"resources/worlds/world4.txt");
	}

	public void update() {
		world.update();
		player.update();
	}

	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
