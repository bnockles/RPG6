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

	//This code just for constructor demo
	//public static SampleEnemy enemy2;
	//public static SampleEnemy enemy3;
	//public static SampleEnemy enemy4;
	//public static SampleEnemy enemy5;

	/**
	 * 
	 */
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
	}

	public String toString(){
		return "The enemy named "+name+" is level "+level+" has "+hp+" hp, "+mp+" mp,"+attack+" attack, "+def+" defense, "+spd+" speed, has a "+drop_rate+" drop rate, you gain "+exp_gained_in_the_end+" exp by killing it, and drops "+money_dropped+" moneys. ";
	}

}
