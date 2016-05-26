package items;

public class Consumable extends Item {
	int amount;
	int value;
<<<<<<< HEAD
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
		
=======
	public Consumable(String name, String description, String req, String type, int shopTag, int enemyTag, int amount, int value) {
		super(name, description, req, type, shopTag, enemyTag);
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
	
	@Override
	public void use(Character user, Consumable consume){
		if(canUse(user)){
			int currentHP = user.getTrueStats().getHealth() + consume.getValue();//fix this later, or fix with character class by implementing currentHP.
		}
	}


	public String getItemInfo() {
		String returnd = "Name: " + this.getName() + " Description: " + this.getDescription();
		return returnd;
	}


	public String getItemType() {
		return this.getType();
	}


	public boolean getIsUsableForBattle() {
		if(this.getType().equals("None")){
			return false;
		}
		return true;
	}


	public int getChangeValue() {
		return this.getValue();
	}

	public boolean isStorable(Item i) {
		return true;
	}

	public int getRarity(Item i) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> refs/remotes/origin/characters
	}

}
