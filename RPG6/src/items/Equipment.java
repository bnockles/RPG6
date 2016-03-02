package items;

public class Equipment extends Item {
	public static final int NONE 	= 0;
	public static final int HELMET 	= 1;
	public static final int CHEST 	= 2;
	public static final int LEG 	= 3;
	public static final int SHOE    = 4;
	//s
	private int durability;
	private int type;
	private Stats stats;
	
	public Equipment(String name, String description, int type, Stats stats, int durability){
		super(name, description);
		this.durability = durability;
		this.type = type;
		this.stats = stats;
		
	}
	
	public int getType(){ return this.type; }
	public Stats getStats(){ return this.stats; }

	public boolean canUse(Character user){ return true; }
	public void use(Character user){ user.equip(this); }
}




