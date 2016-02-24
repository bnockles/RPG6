package Demo;

/**
 * @author bnockles
 *
 */
public class SampleTarget implements Target {

	static int targetNumber=0;
	String name;
	boolean hit;
	
	/**
	 * 
	 */
	public SampleTarget() {
		targetNumber++;
		name = "Target "+targetNumber+ " (has not been hit yet)";
		hit = false;
	}

	/* (non-Javadoc)
	 * @see enemies.Demo.Target#hit()
	 */
	public void hit(SampleEnemy e) {
		name = name.replace(" not", "").replace(" yet", "");
		EnemyBattleScreen.battleMessage=name+ " was hit by "+e.name + " and took "+e.strength+" damage, (whatever that means.)";

	}

	public String getName() {
		return name;
	}
	

}