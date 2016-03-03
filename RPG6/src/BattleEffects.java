import java.util.Timer;

public class BattleEffects{ 

	int timer = new Timer(3600,this);
	timer.run();

	public static void counter(){}
	public static void run(){
		for(int i=timer ; i>=0; i-=1){
			if(i==0) //player automatically uses attack
			}
		}	

	Player HP;
	int newHP = new Player HP/2; 

	public static void poisonChance(){
		int poison = (int)(Math.random() * ((100) +1)); // range from 1 to 100
		if(int poison > 50){
			HP -= 20;
		}
	}
	
	boolean escape = true; 

	public static boolean escapeChance(){
		if (newHP < HP){
			escape = false; //disabling the escape		
		}
		else{
			escape = true; 
		}
		return escape;
	}
}

