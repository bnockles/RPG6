package characters;

import items.Stats;

public class HeroTeam {
	public static final int LINK = 0;
	public static final int KNIGHT = 1;
	public static final int ADVENTURER = 2;

	public static Hero getHero(int member){//int hp, int mp, int atk, int def, int spd, int str, int dex, int iq, int wis, int luck
		if(member == LINK) return new Hero("Link", 5, 100.0, 10.0, new Stats(100, 10, 20, 10, 10, 50, 25, 5, 5, 10));
		if(member == KNIGHT) return new Hero("Knight", 5, 200.0, 15.0,  new Stats(200, 15, 50, 60, 10, 50, 25, 5, 5, 10));
		if(member == ADVENTURER) return new Hero("Adventurer", 5, 90.0, 20.0,  new Stats(90, 20, 15, 5, 50, 50, 25, 5, 5, 50));
		return null;
	}

}
