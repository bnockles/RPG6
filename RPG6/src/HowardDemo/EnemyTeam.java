package HowardDemo;

public interface EnemyTeam {
	public String getName();
	public double getHealth();
	public void setHealth(double health);
	public double getXP();
//	public ArrayList<Items> getItemDrop();
	public double getAttack();
//	public ArrayList<Skills> getSkills();
	public double getSpeed();
	public void setSpeed(double speed);
	public double getDefense();
	public void setDefense(double defense);
	public void updateEnemyInfo(double health, double speed, double defense);
}