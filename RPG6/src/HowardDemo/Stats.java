package HowardDemo;

public class Stats {
	private double health;
	private double attack;
	private double defense;
	private double speed;

	public Stats(double health, double attack, double defense, double speed){
    	this.health=health;
    	this.attack=attack;
    	this.defense=defense;
    	this.speed=speed;
	}
    
	public double getHealth(){
    	return this.health;
	}
    
	public double getAttack(){
    	return this.attack;
	}
    
	public double getDefense(){
    	return this.defense;
	}
    
	public double getSpeed(){
    	return this.speed;
	}
	
	public void setHealth(double health){
		this.health=health;
	}

	public void setAttack(double attack){
		this.attack=attack;
	}

	public void setDefense(double defense){
		this.defense=defense;
	}

	public void setSpeed(double speed){
		this.speed=speed;
	}
}