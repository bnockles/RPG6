package characters;

public class SpecialActions {

	/**
	 * @param args
	 */
	Hero hero;
	String name;
	
	public SpecialActions(Hero hero){
		this.hero = hero;
		this.name = hero.getName();
	}
	
	public static void specialActions(String hero){
		if(hero.equals("Zelda")){
			System.out.println("Zelda swung his sword and killed everyone!");
		}
	}
	

}
