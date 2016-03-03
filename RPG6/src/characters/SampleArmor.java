package characters;

public class SampleArmor extends SampleItem {
	double defenseBoost;
	
	public SampleArmor(String name, double defenseBoost) {
		super(name);
		// TODO Auto-generated constructor stub
		this.defenseBoost = defenseBoost;
	}

	public double statBoost(){
		return defenseBoost;
	}
}
