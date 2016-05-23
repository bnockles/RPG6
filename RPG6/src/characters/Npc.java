package characters;

import items.Stats;

import java.awt.image.BufferedImage;
import java.io.IOException;

import directors.UtilityMethods;

public class Npc extends Character {
	BufferedImage image;
	String dialogue;
	boolean inDialogue;
	public Npc(String name, int level, double currHealth, double currMana, Stats stats){
		super(name, level, currHealth, currMana, stats);
		try {
			BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/character/sample/" + name.toLowerCase() + ".png");
			image=UtilityMethods.getScaledImage(origimage0,50,this.getCharHeight());
		} catch (IOException e) {
			//will throw Exception when files cannot be found
			e.printStackTrace();
		}
		dialogue = "";
		inDialogue = false;
	}

	
	@Override
	public void interaction(Player player) {
		inDialogue = !inDialogue;
		dialogue = "Hi "+ player.getName() + ", I'm Billy.";
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage sprite = image;
		return sprite;
	}


	public String getDialogue() {
		return dialogue;
	}

	public boolean isDialogue(){
		return inDialogue;
	}
}
