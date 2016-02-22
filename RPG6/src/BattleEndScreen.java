import java.util.ArrayList;

public class EndBattle extends Screen{
	//int expBar;
	private int inventoryIdx = Math.random() * Inventory.size();
	
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	
 	public void win(Character character ,Item item,int battleExp,int battleGold){
		//expBar+=exp//exp gain algorithm;
 		System.out.println(character.getLevel());
 		character.setExp(character.getExp()+battleExp);
 		character.setGold(character.getGold()+battleGold);
 		System.out.println(character.getGold());
		Inventory.add(item);
		System.out.println("You win! You have earned "+exp+"exp and gained "+item+".");
	}
	public void lose(Character character,int battleExp,int battleGold){
		//expBar-=exp//exp loss algorithm;
		System.out.println(character.getLevel());
		character.setExp(character.getExp()-battleExp);
		if(character.getExp()<0){
			character.setExp(0);
		}
		character.setGold(character.getGold()+battleGold);
		System.out.println(character.getGold());
		Inventory.remove(inventoryIdx);
		System.out.println("You died! You have lost "+exp+"exp and lost "+item+".");
	}
	
}