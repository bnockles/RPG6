/**
 * 
 */
package enemies.Demo;

import java.util.ArrayList;

/**
 * @author Mr. Nockles
 * I made this for my demo. This is bare bones!
 *
 */
public class SampleEnemy {

<<<<<<< HEAD
	ArrayList<Target> targets;
	public String name;
	
	//by not making getters and setters and making these variables public,
	//they are automatically read AND write! You might choose not to do this
	public int level;
	public double strength;
	
	//examples of how to add variety
	public static final int LIZARD = 0;
	public static final int RAPTOR = 1;
	public static final int FLYING = 2;
	public static final int ZOMBIE = 3;
	
	
	
=======
	//This code just for constructor demo
	//public static SampleEnemy enemy2;
	//public static SampleEnemy enemy3;
	//public static SampleEnemy enemy4;
	//public static SampleEnemy enemy5;

>>>>>>> refs/remotes/origin/enemies
	/**
	 * 
	 */
<<<<<<< HEAD
	public SampleEnemy(int number, ArrayList<Target> targets) {
		name = "enemy"+number;
		this.targets=targets;
		
	}
	
	public SampleEnemy(int level, int type, ArrayList<Target> targets) {
		name = "bad guy";//default name in case type is undefined
		this.level = level;
		this.targets=targets;
		if(type==LIZARD){
			name = "lizard enemy";
			strength = level*.8;
		}
		else if(type==RAPTOR){
			name = "raptor enemy";
			strength = level*1.8;
		}
		else if(type==FLYING){
			name = "flying enemy";
			strength = level*1.2;
		}
		else if(type==ZOMBIE){
			name = "undead enemy";
			strength = level*1.55;
		}
=======
	//public SampleEnemy(int number, ArrayList<Target> targets) {
	//	name = "enemy"+number;
	//	this.targets=targets;
	//	this.itemPosessed=determineRandomItem();
	//	attack = 10;
	//}

	//old determineRandomItem Code
	//	public static String determineRandomItem(){
	//		String[]items = {"potion A","potion B","poison A","","","","sword","armor","shield","hemlock","more poisonous stuff"};
	//		int x = (int)Math.random()*items.length;
	//		return items[x];
	//	}

	public static String determineRandomItem(){
		String[]items = {"potion A","potion B","poison A","","","","sword","armor","shield","hemlock","more poisonous stuff"};
		double x = Math.floor(Math.random()*items.length);
		//System.out.println(x);
		int y = (int)x;
		return items[y];
		//return "";
>>>>>>> refs/remotes/origin/enemies
	}

	public static String getItemPosessed(SampleEnemy e){
		return e.itemPosessed;
	}
	public int getAttack(){
		return this.attack;
	}
	//the following method will most likely be
	//something required by the Battles team. It is likely they will 
	//require a method for taking a turn in a battle

	//Old take turn code
	//	public void takeTurn(){
	//
	//		int targetSelection = (int) (Math.random()*targets.size());
	//		targets.get(targetSelection).hit(this);
	//
	//	}
	//	public void takeBossTurn(){
	//		int targetSelection = 0;
	//		for(int i = 0; i < targets.size() - 1; i++)
	//		{
	//			if(targets.get(i).getHP() < targets.get(targetSelection).getHP())
	//				targetSelection = i;
	//		}
	//		targets.get(targetSelection).hit(this); 
	//	}

	public int randomizer;
	public void newTakeTurn(){

		randomizer = (int) (Math.random()*10);

		if(randomizer < 4){
			int targetSelection = 0;
			for(int i = 0; i < targets.size() - 1; i++)
			{
				if(targets.get(i).getHP() < targets.get(targetSelection).getHP())
					targetSelection = i;
			}
			targets.get(targetSelection).hit(this); 

		}
		else if(randomizer >=4){
			int targetSelection = (int) (Math.random()*targets.size());
			targets.get(targetSelection).hit(this);
		}
		System.out.println("randomized number is " + randomizer);
	}

	ArrayList<Target> targets;
	public String name;
	String itemPosessed;
	public int attack;

	private String type;
	private int level;
	private double hp;
	private double mp;
	//private static double atk;
	private double def;
	private double spd;
	private double drop_rate;
	private double exp_gained_in_the_end;
	private double money_dropped;

	public SampleEnemy(String type, int level, ArrayList<Target> targets){
		this.type = type;
		this.level = level;
		this.targets=targets;
		this.itemPosessed=determineRandomItem();
		if(this.type == "regular"){    	//cant use spells, just attacks.
			name = "Slime";
			hp = 65+2*level;
			mp = 10;
			attack = 20+2*level;
			def = 5+2*level;
			spd = 10+2*level;
			exp_gained_in_the_end = 1500+10*level;
		}

		if(this.type == "tank"){
			name = "Spartan";
			hp = 80+3*level;
			mp = 15+2*level;
			attack = 15+2*level;
			def = 10+3*level;
			spd = 5+level;
			exp_gained_in_the_end = 2000+15*level;
		}

		if(this.type == "mage"){	//can attack but does low damage, spells have set damage
			name = "witch";
			hp = 50+2*level;
			mp = 30+2*level;
			attack = 5;
			def = 5+2*level;
			spd = 8+2*level;
			exp_gained_in_the_end = 2000+15*level;
		}

		if(this.type == "speedy"){
			name = "GATTA GO FAST";
			hp = 65+2*level;
			mp = 20;
			attack = 10+level;
			def = 5;
			spd = 1000;
			exp_gained_in_the_end = 1750+10*level;
		}
		if(this.type == "fluffy"){	//lucky exp giver
			name = "Fluffykins";
			hp = 50;//+Character.getLevel();   	 //hp increases depending on character level
			mp = 0;
			attack = 5;
			def = 5;
			spd = 1000;
			exp_gained_in_the_end = 10;//Character.getLevel();    //gives exp depending on characters level
		}
		
		
		//Jeff
		if(this.type == "rogue"){
			name = "Rogue";
			hp = 30+2*level;
			mp = 20;
			attack = 15+level;
			def = 5;
			spd = 100;
			exp_gained_in_the_end = 1750+10*level;
		}
		if(this.type == "snake"){
			name = "Snake";
			hp = 30;
			mp = 20;
			attack = 5+level;
			def = 5;
			spd = 10;
			exp_gained_in_the_end = 1750+10*level;
		}
		if(this.type == "spider"){
			name = "Spider";
			hp = 30+2*level;
			mp = 20;
			attack = 10+level;
			def = 5;
			spd = 15;
			exp_gained_in_the_end = 1750+10*level;
		}
		if(this.type == "boss"){
			name = "Boss";
			hp = 500+2*level;
			mp = 500;
			attack = 60+2*level;
			def = 50;
			spd = 300;
			exp_gained_in_the_end = 3000;
		}
		if(this.type == "boss2"){
			name = "Boss 2";
			hp = 600+2*level;
			mp = 500;
			attack = 80+2*level;
			def = 50;
			spd = 1000;
			exp_gained_in_the_end = 4000;
		}
		
		//sonya
		if(this.type == "cat"){
			name = "Furr-ocious";
			hp = 30+2*level;
			mp = 200;
			attack = 80+2*level;
			def = 100;
			spd = 100;
			exp_gained_in_the_end = 1500;
		}
		if(this.type == "dinosaur"){
			name = "Dino";
			hp = 200+2*level;
			mp = 300;
			attack = 80+2*level;
			def = 95;
			spd = 80;
			exp_gained_in_the_end = 2000;
		}
			if(this.type == "fish"){
			name = "Nemo";
			hp = 20+2*level;
			mp = 10;
			attack = 10+2*level;
			def = 5;
			spd = 100;
			exp_gained_in_the_end = 100;
		}
			if(this.type == "dog"){
			name = "Dug";
			hp = 40+2*level;
			mp = 100;
			attack = 50+2*level;
			def = 300;
			spd = 150;
			exp_gained_in_the_end = 300;
		}
			if(this.type == "vulture"){
			name = "Voltaire";
			hp = 80+2*level;
			mp = 400;
			attack = 70+2*level;
			def = 600;
			spd = 400;
			exp_gained_in_the_end = 400;
		}
	}

	public String toString(){
		return "The enemy named "+name+" is level "+level+" has "+hp+" hp, "+mp+" mp,"+attack+" attack, "+def+" defense, "+spd+" speed, has a "+drop_rate+" drop rate, you gain "+exp_gained_in_the_end+" exp by killing it, and drops "+money_dropped+" moneys. ";
	}

}
