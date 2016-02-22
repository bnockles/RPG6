package items;

public abstract class effect {
	String ailment;
	int buff;
	int damage;
	String description;
	
	public effect (String ailment, int buff, int damage) {
		this.ailment=ailment;
		this.buff=buff;
		this.damage=damage;
	}
	
	public int skillDamage(Character user,String damage) {
		
		return 0;
	}

	public String getAilment() {
		return ailment;
	}


	public int getBuff() {
		return buff;
	}


	public int getDamage() {
		return damage;
	}
	
	public String toString(){
		return description;
	}
}
