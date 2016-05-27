package Battles;

import java.util.ArrayList;

public interface EnemyTeam {
	public String getName();
	public double getHealth();
	public void setHealth(double health);
	public int getCurrHp();
	public double getXP();
	public ArrayList<Items> getItemDrop();
	public double getAttack();
	//public ArrayList<Skills> getSkills();
	public int getSpeed();
	public void setSpeed(double speed);
	public String getImageFilePath();
	public double getDefense();
	public void setDefense(double defense);
	public void updateEnemyInfo(double health, double speed, double defense);
}
