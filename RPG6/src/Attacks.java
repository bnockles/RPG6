public class Attacks {
	public String name;
	private int power; 
	private int crit ; 
	private int lifesteal; 
	    
	public Attacks (String name, int power, int crit, int lifesteal){ 
	   	this.name=name;
	    this.power=power; 
	    this.setCrit(crit); 
	    this.setLifesteal(lifesteal); 
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getLifesteal() {
		return lifesteal;
	}

	public void setLifesteal(int lifesteal) {
		this.lifesteal = lifesteal;
	}
}

//possible instances
//Attacks attacks1 = new Attacks("Barrier Aerial", 70, 20, 10);
//Attacks attacks2 = new Attacks("Sand Slash Storm", 60, 10, 15);
//Attacks attacks3 = new Attacks("Dance of Fairies", 65, 15, 17);
//Attacks attacks4 = new Attacks("Imperial Salvation", 85, 30, 40);
