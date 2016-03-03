package characters;

public class SamplePotion extends SampleItem {
	double healAmt;
	
	public SamplePotion(String name, double healAmt) {
		super(name);
		// TODO Auto-generated constructor stub
		this.healAmt = healAmt;
	}


	public double heal(){
		return healAmt;
	}
}
