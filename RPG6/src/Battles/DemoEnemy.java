package Battles;

import java.util.ArrayList;

public class DemoEnemy implements EnemyTeam {

	private String name;
	private double hp;
	private double xpAmount;
	private double atk;
	private double def;
	private double spd;
	private String imageFile;
	public DemoEnemy(String name,double health,double xp, double ad, double def, double spd, String file){
		this.name = name;
		this.hp = health;
		this.xpAmount = xp;
		this.atk = ad;
		this.def = def;
		this.spd = spd;
		this.imageFile = file;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public double getHealth() {
		// TODO Auto-generated method stub
		return this.hp;
	}

	public void setHealth(double health) {
		// TODO Auto-generated method stub
		
	}

	public int getCurrHp() {
		// TODO Auto-generated method stub
		return (int) this.hp;
	}

	public double getXP() {
		// TODO Auto-generated method stub
		return this.xpAmount;
	}

	public ArrayList<Items> getItemDrop() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getAttack() {
		// TODO Auto-generated method stub
		return this.atk;
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		return (int) this.spd;
	}

	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}

	public String getImageFilePath() {
		// TODO Auto-generated method stub
		return this.imageFile;
	}

	public double getDefense() {
		// TODO Auto-generated method stub
		return this.def;
	}

	public void setDefense(double defense) {
		// TODO Auto-generated method stub
		
	}

	public void updateEnemyInfo(double health, double speed, double defense) {
		// TODO Auto-generated method stub
		
	}

}
