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

	public QuestItem(String name, String description, String req, int amount) {
		super(name, description, req, req, amount, amount);
		this.amount = amount;
		
	}

}
