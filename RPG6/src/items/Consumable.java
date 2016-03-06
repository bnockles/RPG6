package items;

public abstract class Consumable extends Item {
	int amount;
	public Consumable(String id, String name, String description, int amount) {
		super(id, name, description);
		this.amount = amount;
	}
	//s
	public abstract boolean canUse(Character user);

	public abstract void use(Character user);

}
