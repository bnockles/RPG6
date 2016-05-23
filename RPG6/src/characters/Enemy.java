package characters;

import items.Stats;

import java.awt.image.BufferedImage;
import java.io.IOException;

import directors.Game;
import directors.Screen;
import directors.UtilityMethods;


public class Enemy extends Character {
	BufferedImage image;
	BufferedImage enemyImage;
	BufferedImage tomb;
	public Enemy(String name, int level, double currHealth, double currMana, Stats stats){
		super(name, level, currHealth, currMana, stats);
		// TODO Auto-generated constructor stub
		try {
			BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/character/sample/" + name.toLowerCase() + ".png");
			BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/character/sample/tomb.png");
			enemyImage=UtilityMethods.getScaledImage(origimage0,50,this.getCharHeight());
			tomb=UtilityMethods.getScaledImage(origimage1,50,this.getCharHeight());
			image = enemyImage;
		} catch (IOException e) {
			//will throw Exception when files cannot be found
			e.printStackTrace();
		}
	}

	@Override
	public void interaction(Player player) {
		image = changeImage(0);
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage sprite = image;
		return sprite;
	}

	public BufferedImage changeImage(int num){
		if(num == 1){
			return enemyImage;
		}else{
			return tomb;
		}
	}
}
