package items;

public class Equipment extends Item {
	public Equipment(String name, String description){
		this.name = name;
		this.description = description;
	}
	

	public boolean canUse(Character user){ return true; }
	public void use(Character user){ /*user.equip(this);*/ }
}
