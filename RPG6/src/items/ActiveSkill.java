package items;

import java.util.ArrayList;

public class ActiveSkill extends Spell {
	//s
	public int finalDamage;
	public int exp;
	public String name;
	public String description;
	public int cost;
	public int damage;
	public int type;
	public int turnNum;
	
	public static final int NORMAL = 0;
	public static final int AOE = 1;
	public static final int ATKHEAL = 2;
	public static final int BUFF = 3;
	public static final int HEAL = 4;
	public static final int DELAY = 5;
	public static final int MULTIPLE = 6;
	

	public ActiveSkill(String name, String description, int cost, int damage) {
		super(name,description,cost,damage);
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.damage = damage;
	}

	public int multiAttack(Character c, ActiveSkill a, int times){
		if(a.getType()==MULTIPLE){
			int d = damage;
			for (int i = 1;i<times;i++) d+=damage;
			return d;
		}
		return damage;
	}
	

	public int attack(Character c, ActiveSkill a){
		return c.getTrueStats().getHealth() - a.getDamage();
	}
	
	public void attckHeal(Character c,Character e, ActiveSkill a){
		if(a.getType()==ATKHEAL){
			heal(c,a);
			attack(e,a);
		}
	}
	
	public void attackAll(ArrayList<Character> c, ActiveSkill a){
		if(a.getType()==AOE){
			for (int i = 0; i<c.size();i++){
			attack(c.get(i),a);
			}
		}
	}
	
	public void delayAttack(Character c,ActiveSkill a, int currentTurn){
		if(a.getType()==DELAY){
			if (turnNum == currentTurn + 3)attack(c,a);
		}
	}
	public int heal(Character c, ActiveSkill a){
		return c.getTrueStats().getHealth() + a.getDamage();
	}
	
	public void attackSome(ArrayList<Character> c,ActiveSkill a, int targets){
		if (a.getType() == AOE)
			for (int i = 0;i<targets;i++){
				attack(c.get(i),a);
		}
	}


	public boolean canCast(Character caster, Character target) {
		if (target.getType().equals("enemy")){
			return true;
		}
		return false;
	}


	public int cast(Character caster, ActiveSkill skill, Character target) {
		if (canCast(caster, target)){
			finalDamage = (caster.getTrueStats().getAttack() + skill.getDamage()) - target.getTrueStats().getDefense();
		}
		increaseExp();
		return finalDamage;
	}

	private int increaseExp() {
		// TODO Auto-generated method stub
		return exp+=100;
	}

	public int getFinalDamage() {
		return finalDamage;
	}


	public void increaseLevel(int exp) {
		// TODO Auto-generated method stub
		int level;
		if (exp == 100){
			level = 2;
			increaseDamage(level);
			increaseCost(level);
		}
		if (exp == 200){
			level = 3;
			increaseDamage(level);
			increaseCost(level);
		}
		if (exp == 400){
			level = 4;
			increaseDamage(level);
			increaseCost(level);
		}
		if (exp == 800){
			level = 5;
			increaseDamage(level);
			increaseCost(level);
		}
		if (exp == 1600){
			level = 6;
			increaseDamage(level);
			increaseCost(level);
		}
		if (exp == 3200){
			level = 7;
			increaseDamage(level);
			increaseCost(level);
		}
	}


	public void increaseCost(int level) {
		// TODO Auto-generated method stub
		if(level == 2){
			cost += 10;
		}
		if(level == 3){
			cost += 10;
		}
		if(level == 4){
			cost += 10;
		}
		if(level == 5){
			cost += 10;
		}
		if(level == 6){
			cost += 10;
		}
		if(level == 7){
			cost += 10;
		}
	}

	public void increaseDamage(int level) {
		// TODO Auto-generated method stub
		if(level == 2){
			damage += 10;
		}
		if(level == 3){
			damage += 20;
		}
		if(level == 4){
			damage += 30;
		}
		if(level == 5){
			damage += 50;
		}
		if(level == 6){
			damage += 80;
		}
		if(level == 7){
			damage += 130;
		}
		
	}
	
	public int getExp() {
		return exp;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getCost() {
		return cost;
	}

	public int getDamage() {
		return damage;
	}

	public int getType() {
		return type;
	}


	public String getSkillInfo() {
		return "Name: " + this.getName() + " Description: " + this.getDescription();
	}

	public int getSkillDamage() {
		// TODO Auto-generated method stub
		return this.getDamage();
	}

	public int getSkillCost() {
		return this.getManaCost();
	}

	public boolean isUsable() {
		return true;
	}

}
