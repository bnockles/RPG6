package items;

import java.awt.image.BufferedImage;

public abstract class Item {
	
	String description;
	String name;
	boolean durable;
	BufferedImage itemImage;
	//hi
	
	public Item(String description, String name, BufferedImage image, boolean durable){
		this.description = description;
		this.name = name;
		this.itemImage = image;
		this.durable = durable;
	}
	
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public boolean isDurable() {
		return durable;
	}

	public BufferedImage getItemImage() {
		return itemImage;
	}

	public abstract void onUse();
}
