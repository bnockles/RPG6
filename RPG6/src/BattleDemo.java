

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BattleDemo {
	private JFrame battleScreen;
	private JPanel menuHolder;
	private JButton attack;
	private JButton run;
	private JButton spells;
	private JButton items;
	private JLabel something;
	private JPanel infoBox;
	private static int currPlayerHP; 
	private static int currEnemyHP;
	public BattleDemo(DemoChar player, DemoChar ai) {
		gui(player,ai);
	}
	private void gui( final DemoChar player, final DemoChar ai)  {

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		
		battleScreen = new JFrame("Battle Demo");
		infoBox = new JPanel();
		menuHolder = new JPanel();
		//menuHolder.setBackground(Color.RED);
		something = new JLabel();
		attack = new JButton(new AbstractAction("Attack") {
			public void actionPerformed(ActionEvent e) {
				characterFight(player,ai);
				
			}
	    });
		run = new JButton(new AbstractAction("Run") {
			public void actionPerformed(ActionEvent e) {
				characterAttemptToRunAway(player,ai);
				
			}
	    });
		spells = new JButton(new AbstractAction("Spells") {
			public void actionPerformed(ActionEvent e) {
				characterMagic(player,ai);
				
			}
	    });
		items = new JButton(new AbstractAction("Items") {
			public void actionPerformed(ActionEvent e) {
				characterCheckItems(player);
				
			}
	    });
		
		menuHolder.add(attack);
		menuHolder.add(run);
		menuHolder.add(spells);
		menuHolder.add(items);
		infoBox.add(something);
		container.add(menuHolder);
		container.add(infoBox);
		battleScreen.add(container);
		battleScreen.setVisible(true);
		battleScreen.setSize(1000,800);
		battleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	protected void characterCheckItems(DemoChar player) {
		something.setText("You got nothing...you might be in trouble :P");
		
	}
	protected void characterMagic(DemoChar player, DemoChar ai) {
		currPlayerHP-=ai.magicStat;
		currEnemyHP-=player.magicStat;
		String events ="<html>"+player.Title +" did "+ player.magicStat + " Damage to " + ai.Title + "<br>"+
				ai.Title +" did "+ ai.magicStat + " Damage to " + player.Title + "<br>"+
				player.Title+ " HP = "+currPlayerHP+"<br>"+
				ai.Title+ " HP = "+currEnemyHP +"<br>You are a wizard :O!!"
				+"</html>";
		something.setText(events);
		battleScreen.setVisible(true);
	}
	protected void characterAttemptToRunAway(DemoChar player, DemoChar ai) {
		if(player.speedStat>ai.speedStat){
			something.setText("You manage to get away great job you coward.....");
		}else{something.setText("There's no escaping this...prepare yourself to die in battle");}
		
	}
	protected void characterFight(DemoChar player, DemoChar ai) {
		currPlayerHP-=ai.attackStat;
		currEnemyHP-=player.attackStat;
		String events ="<html>"+player.Title +" did "+ player.attackStat + " Damage to " + ai.Title + "<br>"+
				ai.Title +" did "+ ai.attackStat + " Damage to " + player.Title + "<br>"+
				player.Title+ " HP = "+currPlayerHP+"<br>"+
				ai.Title+ " HP = "+currEnemyHP
				+"</html>";
		something.setText(events);
		battleScreen.setVisible(true);
		
	}
	public static void main(String[] args) {
		DemoChar Player = new DemoChar("Jose",9999,9999,9999,9999);
		DemoChar Enemy = new DemoChar("Wilson",1,1,1,1);
		currPlayerHP = Player.healthStat;
		currEnemyHP = Enemy.healthStat;
		new BattleDemo(Player,Enemy);
		
	}
	
}
