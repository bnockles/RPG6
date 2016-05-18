package items;

public class Consumable extends Item {
	int amount;
	int value;
	public Consumable(String name, String description, String req, int amount, int value) {
		super(name, description, req);
		this.amount = amount;
		this.value = value;
	}
	
	public int getAmount() {
		return amount;
	}

	public int getValue() {
		return value;
	}

	public boolean canUse(Character user){
		return true;
	}

	public void use(Character user){
		
	}

}
