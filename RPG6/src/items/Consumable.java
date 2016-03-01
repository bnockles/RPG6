package items;

public abstract class Consumable extends Item {
	int amount;
	public Consumable(String name, String description, int amount) {
		super(name, description);
		this.amount = amount;
	}
	
	public abstract boolean canUse(Character user);

	public abstract void use(Character user);

}
