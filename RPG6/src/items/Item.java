package items;

import java.awt.image.BufferedImage;

public abstract class Item {
	private String description;
	private String name;
	//BufferedImage itemImage;
	//hi
	
	public Item(String description, String name){
		this.description = description;
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public abstract void onUse();
}
