
public abstract class Treasure {
	String rarity;
	int level;
	String description;
	int type;
	public static final int COMMON = 0;
	public static final int UNCOMMON = 1;
	public static final int RARE = 2;
	public Treasure(int type,int level,String description){
		this.level = level;
		this.type = type;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRarity() {
		if(type == COMMON){
			rarity = "Common";
		}
		if(type == UNCOMMON){
			rarity = "Uncommon";
		}
		if(type == RARE){
			rarity = "Rare";
		}
		return rarity;
	}
	
	public abstract void getItems();
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	

}
