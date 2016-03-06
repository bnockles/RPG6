package items;


public abstract class Item {
	private String name;
	private String description;
	public String req;


	public Item(String name, String description, String req){
		this.description = description;
		this.name = name;
		this.req = req;
	}
	
	
	public String toString(){ return this.name; }

	public String getReq() {
		return req;
	}
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	

	public abstract boolean canUse(Character user);
	public abstract void use(Character user);
	
	public void draw(){}
}
