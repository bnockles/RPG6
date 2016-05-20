
public class Treasure {
	String rarity;
	int money;
	String description;
	int type;
	public static final int COMMON = 0;
	public static final int UNCOMMON = 1;
	public static final int RARE = 2;
	public Treasure(int type,int money,String description){
		this.money = money;
		this.type = type;
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
		return "Rare";
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

}
