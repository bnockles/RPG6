package Battles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class EnemyBattleComponent implements BattleComponent {
	
	private final BufferedImage SakifBattleComponent = new BufferedImage(100, 1000, BufferedImage.TYPE_INT_ARGB);;
	private int x = 880;
	private int y = 100;
	private boolean ifStats;
	private TurnOrder orderOfTurns;
    
	public EnemyBattleComponent(TurnOrder c){
		//drawBattleComponent(c.getName(),c.getHp(),c.getCurrHp(),c.getMp(),c.getCurrMp(),c.getAttack(),c.getDefense(),c.getSpeed(),c.getImageFilepath());
		this.orderOfTurns = c;
		ifStats = false;
	}
	
	public void drawBattleComponent(){
		Graphics2D g2 = (Graphics2D)this.SakifBattleComponent.getGraphics();
		//box
		Color blueBack = new Color(65,105,225);
		g2.setColor(Color.WHITE);
		g2.drawRect(0, 0, 96, 26*this.orderOfTurns.returnTurnOrder().size());
		g2.setColor(blueBack);
		g2.fillRect(1, 1, 95, 26*this.orderOfTurns.returnTurnOrder().size()-1);
		
		
			for(int i=0;i<this.orderOfTurns.returnTurnOrder().size();i++){
				g2.setColor(Color.WHITE);
				g2.drawRect(1,(27*i)+1, 94, 26);
				g2.setColor(Color.GRAY);
				g2.fillRect(1,(27*i)+1, 94, 26);
				g2.setColor(Color.WHITE);
				if(this.orderOfTurns.returnTurnOrder().get(i) instanceof EnemyTeam){
					if(!ifStats)
						g2.drawString(((EnemyTeam) this.orderOfTurns.returnTurnOrder().get(i)).getName(), 5, 20+27*i);
					else g2.drawString(((EnemyTeam) this.orderOfTurns.returnTurnOrder().get(i)).getCurrHp()+"", 5, 20+27*i);
				}
				if(this.orderOfTurns.returnTurnOrder().get(i) instanceof BattleCharacters){
					if(!ifStats)
						g2.drawString(((BattleCharacters) this.orderOfTurns.returnTurnOrder().get(i)).getName(), 5, 20+27*i);
					else g2.drawString(((BattleCharacters) this.orderOfTurns.returnTurnOrder().get(i)).getCurrHp()+"", 5, 20+27*i);
				}
			}
			
		
	}
	
	public BufferedImage getImage() {
		drawBattleComponent();
		return this.SakifBattleComponent;
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
