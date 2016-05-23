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
