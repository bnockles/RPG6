package items;

public class Consumable extends Item {
	int amount;
	int value;
	public Consumable(String name, String description, String req, String type, int tag, int amount, int value) {
		super(name, description, req, type, tag);
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

}
