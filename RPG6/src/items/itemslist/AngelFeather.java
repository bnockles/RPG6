package items.itemslist;

import items.QuestItem;

public class AngelFeather extends QuestItem /* implements Storyline's Progressor */{
	
	int necessaryProgress = 3;
	int storylineProgress;
	String characterLocation;
	
	public AngelFeather(String name, String description, int amount) {
		super("Angel's Feather", "Activates Angel's Event", 3);
	}

	public boolean canUse(items.Character user) {
		if (characterLocation.equals("town")){
			return true;
		}
		return false;
	}

	public void use(items.Character user) {
		if (/*Progressor */ storylineProgress == necessaryProgress){
			System.out.println("You have activated the Angel's Event!");
			//initiate event
		}
		else{
			System.out.println("Nothing happened!");
		}
	}


}
