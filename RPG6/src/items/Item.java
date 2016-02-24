package items;

public abstract class Item {
	private String name;
	private String description;
	private DrawItem draw;

	public Item(String name, String description){
		this.description = description;
		this.name = name;
	}
	
	public String toString(){ return this.name; }
	public boolean equals(Item item){ return this.name == item.name; }
	
	public String getDescription() { return this.description; }
	public String getName() { return this.name; }
	
	

	public abstract boolean canUse(Character user);
	public abstract void use(Character user);
	
}
