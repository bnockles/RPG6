package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;


public class Enemy extends Character {
	BufferedImage image;
	BufferedImage tomb;
	public Enemy(String name, double health, double currHealth, double attack,
			double defense, double mana, double currMana, double speed,
			double dropRate, double critHitChance, double currentExp) {
		super(name, health, currHealth, attack, defense, mana, currMana, speed,
				dropRate, critHitChance, currentExp);
		// TODO Auto-generated constructor stub
		try {
			BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/character/sample/" + name.toLowerCase() + ".png");
			BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/character/sample/tomb.png");
			image=UtilityMethods.getScaledImage(origimage0,50,this.getCharHeight());
			tomb=UtilityMethods.getScaledImage(origimage1,50,this.getCharHeight());
		} catch (IOException e) {
			//will throw Exception when files cannot be found
			e.printStackTrace();
		}
	}

	@Override
	public void interaction(Player player) {
		changeImage(0);
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage sprite = image;
		return sprite;
	}

	public BufferedImage changeImage(int num){
		if(num == 1){
			return image;
		}else{
			return tomb;
		}
	}
}
