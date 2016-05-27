package Battles;

import java.util.ArrayList;

public class TurnOrder {
	ArrayList<Object> charAndEnemy;
	ArrayList<Object> orderOfTurn;
	public TurnOrder(ArrayList<BattleCharacters> player, ArrayList<EnemyTeam> enemy){
		this.charAndEnemy = new ArrayList<Object>();
		for(Object x:player){
			this.charAndEnemy.add(x);
		}for(Object y:enemy){
			this.charAndEnemy.add(y);
		}
		this.orderOfTurn = new ArrayList<Object>();
		currentUnit();
	}
	public void updateArrays(ArrayList<BattleCharacters> player, ArrayList<EnemyTeam> enemy){
		for(Object x:player){
			this.charAndEnemy.add(x);
		}for(Object y:enemy){
			this.charAndEnemy.add(y);
		}
		this.orderOfTurn.clear();;
		currentUnit();
	}
	
	public void currentUnit(){
		this.orderOfTurn = new ArrayList<Object>();
		while(this.charAndEnemy.size()>0){
			int maxSpd = 0;
			int location = 0;
			for(int i=0;i<this.charAndEnemy.size();i++){
				if(this.charAndEnemy.get(i) instanceof BattleCharacters){
					System.out.println("Players");
					if(((BattleCharacters) this.charAndEnemy.get(i)).getSpeed()>maxSpd){
						maxSpd =(int) (((BattleCharacters) this.charAndEnemy.get(i)).getSpeed());
						location = i;
						System.out.println("Player "+maxSpd);
						
					}
				}
				if(this.charAndEnemy.get(i) instanceof EnemyTeam){
					System.out.println("Enemies");
					if(((EnemyTeam) this.charAndEnemy.get(i)).getSpeed()>maxSpd){
						maxSpd = (int) ((EnemyTeam) this.charAndEnemy.get(i)).getSpeed();
						location = i;
						System.out.println("Enemies "+maxSpd);
					}
				}
			}
			this.orderOfTurn.add(this.charAndEnemy.remove(location));
		}
		System.out.println(this.orderOfTurn.size());
		this.charAndEnemy.add(orderOfTurn);
		
	}
	public ArrayList<Object> returnTurnOrder(){
		return this.orderOfTurn;
	}
}

