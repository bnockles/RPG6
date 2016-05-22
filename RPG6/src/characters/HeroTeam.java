package characters;

public class HeroTeam {
	public static final int LINK = 0;
	public static final int KNIGHT = 1;
	public static final int ADVENTURER = 2;
	
	//name, health, currHealth, attack, defense, mana, currMana,
	//speed, dropRate, critHitChance, currentExp
	public static Hero getHero(int member){
		if(member == LINK) return new Hero("Link", 100.0, 100.0, 10.0, 10.0, 190.0, 190.0, 5.0, 0, 0, 5.0);
		if(member == KNIGHT) return new Hero("Knight", 200.0, 200.0, 15.0, 9.0, 50.0, 50.0, 5.0, 0, 0, 5.0);
		if(member == ADVENTURER) return new Hero("Adventurer", 90.0, 90.0, 20.0, 9.0, 150.0, 150.0, 5.0, 0, 0, 5.0);
		return null;
	}

}
