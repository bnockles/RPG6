package Battles;

import java.util.TimerTask;

public class TimerSchedulePeriod extends TimerTask {

	@Override
	public void run() {
		while(battleScreen.displayHPEnemy!=battleScreen.enemyCurrentHP){
			battleScreen.displayHPEnemy--; 
		}

	}

}
