package Battles.WilsonDemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class CharacterBattleComponent implements BattleComponent {
	
	private final BufferedImage WilsonBattleComponent = new BufferedImage(97, 201, BufferedImage.TYPE_INT_ARGB);;
	private int x = 200;
	private int y = 200;
	private BattleCharacters stats;
	private boolean ifStats;
    
	public CharacterBattleComponent(BattleCharacters c){
		stats = c;
		ifStats = false;
	}
	
	public void drawBattleComponent(String name,int hp, int currHp,int mp, int currMp, int atk,int def, int spd, String image){
		Graphics2D g2 = (Graphics2D)this.WilsonBattleComponent.getGraphics();
		
		//box
		Color blueBack = new Color(65,105,225);
		g2.setColor(Color.WHITE);
		g2.drawRect(0, 0, 96, 200);
		g2.setColor(blueBack);
		g2.fillRect(1, 1, 95, 199);
		
		if(!this.ifStats){
			
			//image
			g2.setColor(Color.WHITE);
			g2.drawRect(1, 104, 96, 96);
			g2.drawImage(createImage(image, 96,96),1,104,null);
			
			//name
			g2.setColor(Color.WHITE);
			g2.drawRect(1, 1, 94, 26);
			g2.setColor(Color.GRAY);
			g2.fillRect(1, 1, 94, 26);
			g2.setColor(Color.WHITE);
			g2.drawString(name, 5, 20);
			
			//hp
			g2.setColor(Color.WHITE);
			g2.drawRect(1,  28, 94, 26);
			g2.setColor(Color.RED);
			g2.fillRect(1, 28, 94, 26);
			g2.setColor(Color.WHITE);
			g2.drawString("HP: " + hp + "/" + currHp, 5, 47);
			
			//mp
			g2.setColor(Color.WHITE);
			g2.drawRect(1, 55, 94, 26);
			g2.setColor(Color.BLUE);
			g2.fillRect(1, 55, 94, 26);
			g2.setColor(Color.WHITE);
			g2.drawString("MP: " + mp + "/" + currMp, 5, 74);
			
			//instruction
//			g2.setColor(Color.WHITE);
//			g2.drawRect(1, 82, 94, 26);
			g2.drawString("Press S for stats", 5, 101);
			
		}else{
			int[] statArray = {stats.getAttack(), stats.getDefense(), stats.getSpeed(), stats.getStrength(), stats.getDexterity(), stats.getIntelligence(), stats.getExpNeededToLevel()};
			String[] statName = {"Atk", "Def", "Spd", "Str", "Dex", "Int", "Exp"};
			
			for(int i = 0; i < 7; i++){
				g2.setColor(Color.WHITE);
				g2.drawRect(1, 1+(i*27), 94, 26);
				g2.setColor(Color.GRAY);
				g2.fillRect(1, 1+(i*27), 94, 26);
				g2.setColor(Color.WHITE);
				if(i != 6){
					g2.drawString(statName[i] + ": " + statArray[i], 5, 20+(i*27));
				}else{
					g2.drawString(statName[i] + ": " + stats.getCurrExp() + "/" + statArray[i], 5, 20+(i*27));
				}
			}
			
		}
		
	}
	
	public BufferedImage getImage() {
		drawBattleComponent(stats.getName(), stats.getHp(), stats.getCurrHp(), stats.getMp(), stats.getCurrMp(), stats.getAttack(), stats.getDefense(), stats.getSpeed(), stats.getImageFilepath());
		return this.WilsonBattleComponent;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void keyAction(int keyCode) {
		if(keyCode == KeyEvent.VK_S){
			this.ifStats = !this.ifStats;
		}
	}
	
	public BufferedImage createImage(String imagePath,int x1,int y1){
		BufferedImage bImg = new BufferedImage(x1, y1, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imagePath);
		try {
			BufferedImage original = ImageIO.read(url);
			
			Graphics2D g = (Graphics2D) bImg.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original,0,0,x1,y1,0,0,w,h,null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return bImg;
	}
	

}
