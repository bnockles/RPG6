package items;


public abstract class Item implements ItemTeam {
	private String name;
	private String description;
	private String req;
	private String type;
	private int tag;


	public Item(String name, String description, String req, String type, int tag){
		this.description = description;
		this.name = name;
		this.req = req;
		this.type = type;
		this.tag = tag;
	}
	
	public int getTag(){
		return tag;
	}
	public String getType() {
		return type;
	}
	
	public String getReq() {
		return req;
	}
	
	public String toString(){ return this.name; }


	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	

	public abstract boolean canUse(Character user);
	public abstract void use(Character user);
	
	public void draw(){}
}
