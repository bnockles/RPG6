package items;

import java.awt.image.BufferedImage;

public abstract class QuestItem extends Item {
	int amount;
	String storylineProgress;
	
	
	public int getAmount() {
		return amount;
	}

	public String getStorylineProgress() {
		return storylineProgress;
	}

	public QuestItem(String description, String name, BufferedImage image,
			boolean durable, int amount) {
		super(name, description);
		this.amount = amount;
		// TODO Auto-generated constructor stub
	}

	public abstract void onUse();
		// TODO Auto-generated method stub

	

}
