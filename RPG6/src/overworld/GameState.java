package overworld;

import java.awt.Graphics;


//import FirstRpg.Game;
//import FirstRpg.Entity.Creatures.Player;
//import FirstRpg.Worlds.World;

public class GameState extends State{
	

	private Boss boss1;
	private Boss boss2;
	private Boss boss3;
	private potionFloor p1;
	private swordFloor s1;
	private swordFloor s2;
	private chestFloor c1;
	private chestFloor c2;
	
	private Player player;
	private World world, world2, world3, world4;
	private SelectWorld sWorld;
	private boolean origin;
	private int worldNum;
	
	public GameState(Game game){
		super(game);
		worldNum=0;
		sWorld=new SelectWorld(game);
		player=new Player(game, 100,100);
		world=new World(game,"resources/worlds/world1.txt");
		world2=new World(game,"resources/worlds/world2.txt");
		world3=new World(game,"resources/worlds/world3.txt");
		world4=new World(game,"resources/worlds/world4.txt");
		
		boss1 = new Boss(game, 100, 100);
		boss2 = new Boss(game, 500, 500);
		boss3 = new Boss(game, 500, 10);
		p1 = new potionFloor(game, 200, 200);
		s1 = new swordFloor(game, 300, 300);
		s2 = new swordFloor(game, 300, 400);
		c1 = new chestFloor(game, 100, 400);
		c2 = new chestFloor(game, 100, 500);
		
	}

	public void update() {
		if(game.getKeyManager().world1)worldNum=1;
		if(game.getKeyManager().world2)worldNum=2;
		if(game.getKeyManager().world3)worldNum=3;
		if(game.getKeyManager().world4)worldNum=4;
		selectW();
		player.update();
	}

	public void render(Graphics g) {
		selectWG(g);
		player.render(g);
		
		boss1.render(g);
		boss2.render(g);
		boss3.render(g);
		p1.render(g);
		s1.render(g);
		s2.render(g);
		c1.render(g);
		c2.render(g);
	}
	public void selectW(){
		if(worldNum==0)sWorld.updateWorld(world);
		if(worldNum==1)sWorld.updateWorld(world);
		if(worldNum==2)sWorld.updateWorld(world2);
		if(worldNum==3)sWorld.updateWorld(world3);
		if(worldNum==4)sWorld.updateWorld(world4);
	}
	public void selectWG(Graphics g){
		if(worldNum==0)sWorld.updateWorldG(world,g);
		if(worldNum==1)sWorld.updateWorldG(world,g);
		if(worldNum==2)sWorld.updateWorldG(world2,g);
		if(worldNum==3)sWorld.updateWorldG(world3,g);
		if(worldNum==4)sWorld.updateWorldG(world4,g);
	}
	
}
