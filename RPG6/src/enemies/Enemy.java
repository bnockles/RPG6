package enemies;

import java.util.ArrayList;

public abstract class Enemy extends Character {

	int factor;
	public Enemy(){
		//TODO
	}
	//gugyuyu
	public abstract Character determineTarget(ArrayList<Character> character);
	public int getHP(){
		return HP;
	}
	public void determineFactor(int enemyLevel, int damageLevel){
		double x;//maybe well change the algorithm later
		int xFinal;
		x=enemyLevel*(1/damageLevel);
		xFinal = (int)x*10;
		this.factor=xFinal;
		
	}
}
