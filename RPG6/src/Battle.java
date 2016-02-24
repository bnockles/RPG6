public class Battle {
	
	public Battle() {
		
	}
	
	public class Turn{
		//methods for a turn
	}
	
	public class CharacterAction{
		//uses methods from turn but suited for a character
	}
	
	public static class BattleMechanic{
		//exp formulas, algorithms, most likely extend enemy design ai for enemy turn
		//or give them interface for ai
		
		/**
		 * need fields: double expRequiredToLevel, double currentExp
		 * @param hero in the battle
		 * @return sets hero exp to current+amount enemy gives
		 */
		public static void giveExp(Hero hero, Enemy enemy){
			if(hero.getCurrentExp()+enemy.getExpGained() > hero.getExpNeededToLevel()){
				hero.levelUp();
				hero.setCurrentExp((hero.getCurrentExp()+enemy.getExpGained())-hero.getExpNeededToLevel());
			}else{
				hero.setCurrentExp(hero.getCurrentExp()+enemy.getExpGained());
			}
		}
		
		/**
		 * 
		 * @param c character who is attempting to dodge
		 */
		public static boolean dodgeAttack(Char c){
			boolean willDodge = false;
			int rand = 1 + (int)(Math.random() * ((10000 - 1) + 1));
			if(rand <= c.getEvasion()*100){
				willDodge = true;
			}
			return willDodge;
		}
		
		/**
		 * 
		 * @param character in battle
		 * @return returns if a character willCrit
		 */
		public static boolean willCrit(Char c){
			boolean willCrit = false;
			int rand = 1 + (int)(Math.random() * ((100) + 1));
			if(rand <= c.getCritHitChance()){
				willCrit = true;
			}
			return willCrit;
		}
		
	}
	
	public class BattleScreen{
		//the fields(Dimensions) for a battle screen and the layout for how a battle is supposed to be design
		//most likely to extend menus
	}
	
	public class BattleConfig{
		//methods and extending menus to design a textbox to select teammates/skills for upcoming battle
		//character design will provide such info
	}
	
	public class BattleType{
		//most likely group effort utilizing previous classes and methods to create subclasses for
		//minibattles, regularbattle, bossbattles
	}
	
	public class EndOfBattleReport{
		//will design the layout and template for the end of a game report where info will display to the player
		//items obtained and exp gained etc
	}
	
}
