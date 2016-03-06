package items;

public class potionStock {
	public static final int HP_100 = 0;
	public static final int HP_500 = 1;
	public static final int HP_1000 = 2;
	public static final int MP_100 = 3;
	public static final int MP_500 = 4;
	public static final int MP_1000 = 5;
	public static final int PT_RES = 6;
	public static final int ATK_I = 7;
	public static final int ATK_II = 8;
	public static final int DEF_I = 9;
	public static final int DEF_II = 10;
	public static final int SPD_I = 11;
	public static final int SPD_II = 12;
	public static final int ARROWS = 13;
	
	
	public static Consumable consumableStock(int type){
		if(type == HP_100){
			return new Consumable("HP 100", "Restores 100 HP to the target.", "" , 10);
		}
		if(type == HP_500){
			return new Consumable("HP 500", "Restores 500 HP to the target.", "" , 2);
		}
		if(type == HP_1000){
			return new Consumable("HP 1000", "Restores 1000 HP to the target.", "" , 1);
		}
		if(type == MP_100){
			return new Consumable("MP 100", "Restores 100 MP to the target.", "" , 10);
		}
		if(type == MP_500){
			return new Consumable("MP 500", "Restores 500 MP to the target.", "" , 2);
		}
		if(type == MP_1000){
			return new Consumable("MP 1000", "Restores 1000 MP to the target.", "" , 1);
		}
		if(type == PT_RES){
			return new Consumable("PARTY RESTORE", "Restores everyone in your party full HP", "" , 99);
		}
		if(type == ATK_I){
			return new Consumable("ATK I", "Gives target +5 attack", "" , 3);
		}
		if(type == ATK_II){
			return new Consumable("ATK II", "Gives target +15 attack", "" , 1);
		}
		if(type == DEF_I){
			return new Consumable("DEF I", "Gives target +5 defense", "" , 3);
		}
		if(type == DEF_II){
			return new Consumable("DEF II", "Gives target +15 defense", "" , 1);
		}
		if(type == SPD_I){
			return new Consumable("SPD I", "Gives target +5 speed", "" , 3);
		}
		if(type == SPD_II){
			return new Consumable("SPD II", "Gives target +15 speed", "" , 1);
		}
		if(type == ARROWS){
			return new Consumable("ARROWS", "Quiver of arrows. Good with a bow", "" , 6);
		}
		return null;
	}

}
