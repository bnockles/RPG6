package HowardDemo;

import java.util.ArrayList;

public class ExampleClass {
	ArrayList<enemy> enemyList;
	
	public ExampleClass(){
		enemyList = new ArrayList<enemy>();
	}
	
	public static void main(String[] args) {
		
	}
	
	public String doTheThing(){
		return "Do thing";
	}
	
	public ArrayList<enemy> getEnemyList(){
		return enemyList;
	}
	
	public void addEnemy(enemy enemy){
		enemyList.add(enemy);
	}
}