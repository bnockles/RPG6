package items;

public class Consumable extends Item {
	int amount;
	public Consumable(String name, String description, String req, int amount) {
		super(name, description, req);
		this.amount = amount;
	}
	
	public boolean canUse(Character user){
		return true;
	}

	public void use(Character user){
		
	}

}
