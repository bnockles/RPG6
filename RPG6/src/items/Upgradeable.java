package items;

public interface Upgradeable {
<<<<<<< HEAD

	int maxUpgradeValue = 7;
	Stats upgradedStats = new Stats(1, 1, 1, 1, 1, 1);

	public void upgrade(Item item);
	// if (item.getType() = "equipment" && item.getupgradedValue() != maxUpgradeValue){
	//	item.getupgradedValue += 1;
	//	item.getStats() += upgradedStats;
	//} NOTE: ALL VALUES ARE NOT DEFINED. MUST DEFINE THEM. THIS IS FOR THE SAKE OF UNDERSTAND WHAT THIS WILL DO.

=======
	
	public boolean canUpgrade(Item i);
	
>>>>>>> refs/remotes/origin/characters
}
