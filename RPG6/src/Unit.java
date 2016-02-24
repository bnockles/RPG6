
public class Unit{
    
    String name;
    int level;
    double hitPoints;
    double costPoints;
    double rechargeRate;
    double strength;
    double spirit;
    double armor;
    double willpower;
    double evasion;
    boolean haste = false;
    boolean slow = false;
    
    public Unit(String name, double recharge){
        this.name = name;
        this.rechargeRate = recharge;
    }

    public String getName() {
        return name;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public double getCostPoints() {
        return costPoints;
    }

    public double getRechargeRate() {
        return rechargeRate;
    }
    
    public void setHaste() {
        this.haste = true;
    }

    public void setSlow() {
        this.slow = true;
    }
}
