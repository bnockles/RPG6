package characters;

public class SampleWeapon extends SampleItem {
	double attackBoost;
	
	public SampleWeapon(String name, double attackBoost) {
		super(name);
		// TODO Auto-generated constructor stub
		this.attackBoost = attackBoost;
	}

	public double statBoost(){
		return attackBoost;
	}

}
