package Battles;

public class Move {
	String moveTitle;
	int damage;
	public Move(String title,int dmg){
		this.moveTitle = title;
		this.damage = dmg;
	}
	public void updateInfo(String title,int dmg){
		this.moveTitle = title;
		this.damage = dmg;
	}
}
