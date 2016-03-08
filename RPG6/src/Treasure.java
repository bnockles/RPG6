
public class Treasure {
	String rarity;
	int money;
	String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Treasure(String rarity,int money,String description){
		this.rarity = rarity;
		this.money = money;
	}
	public String getRarity() {
		return rarity;
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
