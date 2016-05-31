package Battles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LevelUpScreen implements BattleComponent {

	/**
	 * @param args
	 */
	private final BufferedImage JoseBattleComponent = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);;
	private int x =300 ;
	private int y =250 ;
	private int counter = 0;
	private int lvlPoints = 5;
	private int[] points = {0,0,0};
	private ArrayList<BattleCharacters> characters;
	private ArrayList<BattleCharacters> needToLvlUp;
	public LevelUpScreen(ArrayList<BattleCharacters> players){
		this.needToLvlUp = new ArrayList<BattleCharacters>();
		this.characters = new ArrayList<BattleCharacters>();
		for(BattleCharacters x:players){
			this.characters.add(x);
		}
	}
	public void drawBattleComponent(){
		Graphics2D g2 = (Graphics2D)this.JoseBattleComponent.getGraphics();
		
		//box
		Color blueBack = new Color(65,105,225);
		g2.setColor(Color.WHITE);
		g2.drawRect(0, 0, 399, 399);
		g2.setColor(blueBack);
		g2.fillRect(1, 1, 398, 398);
		//Displaying Stats
		if(this.needToLvlUp.size()==0){
			for (BattleCharacters x:this.characters){
				if(x.getCurrExp()>=x.getExpNeededToLevel()){
					this.needToLvlUp.add(x);
					System.out.println(this.needToLvlUp.get(0).getName());
				}
			}
		}
		if(this.needToLvlUp.size()>0){
			//image
			g2.setColor(Color.WHITE);
			g2.drawRect(150, 1, 96, 96);
			g2.drawImage(createImage(this.needToLvlUp.get(0).getImageFilepath(), 96,96),150,1,null);
			//name
			g2.setColor(Color.WHITE);
			g2.drawRect(150, 100, 94, 26);
			g2.setColor(Color.GRAY);
			g2.fillRect(150, 100, 94, 26);
			g2.setColor(Color.WHITE);
			g2.drawString(this.needToLvlUp.get(0).getName(), 155, 119);
			int[] statArray = {this.needToLvlUp.get(0).getAttack()+this.points[0], this.needToLvlUp.get(0).getDefense()+this.points[1], this.needToLvlUp.get(0).getSpeed()+this.points[2]};
			String[] statName = {"Atk", "Def", "Spd"};
			for(int i = 0; i < 3; i++){
				Color selected = new Color(0,255,0);
				if(this.counter==i) selected = new Color(255,0,0);
				g2.setColor(Color.WHITE);
				g2.drawRect(150, 1+((i+1)*27)+99, 94, 26);
				g2.setColor(selected);
				g2.fillRect(150, 1+((i+1)*27)+99, 94, 26);
				g2.setColor(Color.WHITE);
				g2.drawString(" - "+statName[i] + ": " + statArray[i]+" + ", 155, 20+((i+1)*27)+99);
			}
			
		}
		
	}
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		drawBattleComponent();
		return this.JoseBattleComponent;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	public void keyAction(int keyCode) {
		switch(keyCode){
			case KeyEvent.VK_UP:
				this.counter--;
				if(this.counter<0) this.counter = 2;
				this.counter%=3;
				break;
			case KeyEvent.VK_DOWN:
				this.counter++;
				this.counter%=3;
				break;
			case KeyEvent.VK_LEFT:
				if(this.points[counter]>0){
					this.lvlPoints++;
					this.points[counter]--;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(this.lvlPoints>0){
					this.points[counter]++;
					this.lvlPoints--;
				}
				break;
			case KeyEvent.VK_ENTER:
				if(this.lvlPoints==0){
					this.characters.get(0).setExp(this.characters.get(0).getCurrExp()-this.characters.get(0).getExpNeededToLevel());
					this.characters.get(0).setStats(this.characters.get(0).getAttack()+this.points[0], this.characters.get(0).getAttack()+this.points[1], this.characters.get(0).getAttack()+this.points[2]);
					this.lvlPoints = 5;
					this.counter = 0;
					
					this.needToLvlUp.remove(this.needToLvlUp.get(0));
					
					for(int i=0;i<this.points.length;i++)this.points[i]=0;
				}
				break;
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
