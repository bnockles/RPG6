package HowardDemo;

import java.util.ArrayList;

public class ExampleClass {
	
	public ExampleClass(){
		
	}
	
	public static void main(String[] args) {
		
	}
	
	public String doTheThing(){
		return "Do thing";
	}
	
	public String showEnemy(int index){
		ArrayList<enemy> poop = new ArrayList<enemy>();
		String poopie = "null";
		if(poop !=null){
			System.out.println("Not null");
			poopie = "Not null";
		}
		
//		poop=enemy.getEnemyList();
//		String whatToShow = " ";
//		whatToShow = poop.get(index).getName();
//		return whatToShow;
		return poopie;
	}
}