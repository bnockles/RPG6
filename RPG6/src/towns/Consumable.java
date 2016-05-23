package towns;

public class Consumable extends Item {
	int amount;
	int value;
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

	public boolean reparable(Equipment item) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDurability() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRarity(Equipment item) {
		// TODO Auto-generated method stub
		return 0;
	}

}

