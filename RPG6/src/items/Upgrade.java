package items;

public class Upgrade {
	
	private int upgradeNumber;
	private Stats stats;
	public final int upgradeValue = 7;
	
	public Upgrade(int upgradeNumber, Stats stats) {
		this.upgradeNumber = upgradeNumber;
		this.stats = stats;
	}

	public int getUpgradeNumber() {
		return upgradeNumber;
	}

	public void setUpgradeNumber(int upgradeNumber) {
		this.upgradeNumber = upgradeNumber;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

}
