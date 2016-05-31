package Battles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import directors.Game;
import directors.Screen;

public class UpdatedBattleScreen extends Screen implements KeyListener {

	ArrayList<BattleComponent> potatoes;
	ArrayList<BattleCharacters> players;
	ArrayList<EnemyTeam> opponents;
	TurnOrder turns;
	public UpdatedBattleScreen(Game game) {
		super(game);
		players = new ArrayList<BattleCharacters>();
		opponents = new ArrayList<EnemyTeam>();
		DemoCharacter playerOne = new DemoCharacter("Insert Name",500,250,25,25,45,10,20,"/images/BioBird.png");
		DemoCharacter playerTwo = new DemoCharacter("Bob",500,250,25,25,45,10,20,"/images/BioBird.png");
		DemoEnemy khan = new DemoEnemy("Khan", 100, 10, 10, 10, 10, "???");
		players.add(playerOne);
		players.add(playerTwo);
		opponents.add(khan);
		turns = new TurnOrder(players,opponents);
		potatoes = new ArrayList<BattleComponent>();
		potatoes.add(new CharacterBattleComponent(playerOne));
		potatoes.add(new EnemyBattleComponent(turns));
		potatoes.add(new LevelUpScreen(players));
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		for(BattleComponent x:potatoes){
			//System.out.println("Drawing Something");
			x.keyAction(arg0.getKeyCode());
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, this.width, this.height);
		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(120, 579, 693, 200, 10, 10);
		Color tmp = new Color(65,105,225);
		g2.setColor(Color.WHITE);
		g2.draw(roundedRectangle);
		g2.setColor(tmp);
		g2.fillRoundRect(121, 581, 692, 198, 10, 10);
		for(BattleComponent x:potatoes){
			//System.out.println("Drawing Something");
			g2.drawImage(x.getImage(), x.getX(), x.getY(), null);
		}
		
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

}
