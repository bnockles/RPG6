package items;

public abstract class effect {
	String ailment;
	int buff;
	int damage;
	
	
	public effect (String ailment, int buff, int damage) {
		this.ailment=ailment;
		this.buff=buff;
		this.damage=damage;
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
}
