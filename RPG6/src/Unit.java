
public class Unit{
    
    String name;
	int level;
	int health;
	int attack;
	int defence;
	int speed;
	int exp;
    
    public Unit(String name, int level, int heatlh int speed){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.exp = 0;
    }

    public String getName() {
        return name;
    }
    
    public void displayStats(){
	System.out.println(this.name+"\nLv. "+this.level+"\nHealth "
	+this.health+"\nSpeed "+this.speed+"\nEXP "+this.exp+"\nNext Lv "
	+BattleMethods.nextLevel(this)+"\n---------------");
    }
}
