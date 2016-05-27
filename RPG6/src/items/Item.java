package items;


//<<<<<<< HEAD
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
/*=======
public abstract class Item implements ItemTeam, GetItem, Storable {
	private String name;
	private String description;
	private String req;
	private String type;
	private int shopTag;//0 is no shops sell, 1 is town1, 2 is town2, 3 is town3, etc
	private int enemyTag;//0 is no enemy drops, 1 is enemy1, 2 is enemy2, etc.
//	private int bossTag; //this will be for boss mobs that will be written later.


	public Item(String name, String description, String req, String type, int shopTag, int enemyTag){
		this.description = description;
		this.name = name;
		this.req = req;
		this.type = type;
		this.shopTag = shopTag;
		this.enemyTag = enemyTag;
	}
	
	public int getenemyTag(){
		return enemyTag;
	}
	public int getshopTag(){
		return shopTag;
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
	public abstract void use(Character user, Consumable consume);
	
	public void draw(){}
	
	public String getItemName(){
		return null;
	}
	
	public String getItemDesc(){
		return null;	
	}
	
	public int getItemBuyPrice(){
		return 0;
	}
	
	public int getItemSellPrice(){
		return 0;
	}
	
	public boolean getBuyable(){
		return true;
	}
>>>>>>> refs/remotes/origin/characters
}
*/