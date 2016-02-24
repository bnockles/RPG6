package Demo;

public class SampleItemI implements ItemI {

	static int itemNumber=0;
	String name;
	boolean use;
	
	/**
	 * 
	 */
	public SampleItemI() {
		itemNumber++;
		name = "Item "+itemNumber+ " (has not been used yet)";
		use = false;
	}

	/* (non-Javadoc)
	 * @see enemies.Demo.Target#hit()
	 */

	public String getName() {
		return name;
	}


	public void castOn(SampleItem e) {
		name = name.replace(" not", "").replace(" yet", "");
		EnemyBattleScreen.battleMessage=name+ " was used by "+e.name + " and had this effect!";
	}
}
	
