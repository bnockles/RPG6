package items;


public abstract class Item {
	private String id;
	private String name;
	private String description;
	private DrawItem drawItem;

	public Item(String id, String name, String description){
		this.id = id;
		this.description = description;
		this.name = name;
		this.drawItem = new DrawItem();
	}
	
	//return this for builder pattern 
	public Item setDrawItem(DrawItem d){ 
		this.drawItem = d;
		return this;
	}
	
	//register the item to the Items class' manager 
	public Item register(){
		Items.registerItem(this);
		return this;
	}
	
	public String toString(){ return this.name; }
	public boolean equals(Item item){ return this.id.equals(item.id); }

	public String getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	

	public abstract boolean canUse(Character user);
	public abstract void use(Character user);
	
	public void draw(){}
}
