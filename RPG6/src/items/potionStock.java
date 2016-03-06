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
			return new Consumable("HP 100", "Restores 100 HP to the target.", "A red potion. Small but interesting" , 10, 100);
		}
		if(type == HP_500){
			return new Consumable("HP 500", "Restores 500 HP to the target.", "It's the size of your hand. Looks like it will take a while to drink." , 2, 500);
		}
		if(type == HP_1000){
			return new Consumable("HP 1000", "Restores 1000 HP to the target.", "This looks like it's enough for a whole family, but it's for one person." , 1, 1000);
		}
		if(type == MP_100){
			return new Consumable("MP 100", "Restores 100 MP to the target.", "A blue potion. Small but intriguing" , 10, 100);
		}
		if(type == MP_500){
			return new Consumable("MP 500", "Restores 500 MP to the target.", "The liquid is glowing. It'll be weird to drink this now." , 2, 500);
		}
		if(type == MP_1000){
			return new Consumable("MP 1000", "Restores 1000 MP to the target.", "It looks like snail juice; A huge jug of it. Appetizing indeed." , 1, 1000);
		}
		if(type == PT_RES){
			return new Consumable("PARTY RESTORE", "Restores everyone in your party full HP", "All in one potion. It's small but it will do everyone justice." , 99, 99999);
		}
		if(type == ATK_I){
			return new Consumable("ATK I", "Gives target +5 attack", "A quick boost. Looks like a pill of some sort." , 3, 5);
		}
		if(type == ATK_II){
			return new Consumable("ATK II", "Gives target +15 attack", "A sharp needle. Instructions: Inject for everlasting pleasure." , 1, 15);
		}
		if(type == DEF_I){
			return new Consumable("DEF I", "Gives target +5 defense", "A quick aid. It's a non-appetizing brown color." , 3, 5);
		}
		if(type == DEF_II){
			return new Consumable("DEF II", "Gives target +15 defense", "A sharp needle. Instructions: Inject for a nice hard body." , 1, 15);
		}
		if(type == SPD_I){
			return new Consumable("SPD I", "Gives target +5 speed", "A quick speed. It's red and white like a normal pill." , 3, 5);
		}
		if(type == SPD_II){
			return new Consumable("SPD II", "Gives target +15 speed", "A sharp needle. Instructions: Inject to be a ninja." , 1, 15);
		}
		if(type == ARROWS){
			return new Consumable("ARROWS", "Arrow itself: 5 ATK; With Bow: 15 ATK", "Quiver of arrows. Good with a bow", 6, 15);
		}
		return null;
	}

}
