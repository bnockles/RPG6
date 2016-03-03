package items;


public abstract class QuestItem extends Item {
	int amount;
	String storylineProgress;
	
	
	public int getAmount() {
		return amount;
	}

	public String getStorylineProgress() {
		return storylineProgress;
	}

	public QuestItem(String id, String name, String description, int amount) {
		super(id, name, description);
		this.amount = amount;
		
	}

}
