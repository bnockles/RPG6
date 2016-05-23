package items;

public class ForEnemies {
	
	private boolean canDrop;
	private int dropRate;
	private int enemyTag;

	public ForEnemies(boolean canDrop, int dropRate, int enemyTag) {
		this.canDrop = canDrop;
		this.dropRate = dropRate;
		this.enemyTag = enemyTag;
	}

}
