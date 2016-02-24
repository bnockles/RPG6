package overworld;

import java.awt.Graphics;

import FirstRpg.Game;
import FirstRpg.Entity.Creatures.Player;
import FirstRpg.Worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		player=new Player(game, 100,100);
		world= new World(game,"res/worlds/world1.txt");
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
